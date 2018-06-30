#include <iostream>
#include <fstream>
#include <algorithm>

using namespace std;
class Sum_Pref;
class Hash;
class Hash_Pref;
Sum_Pref *sums;
Hash *hash_el;
Hash_Pref *hash_pref_sum;
int n, m, t, x, y;
ifstream fin("permutation.in");
ofstream fou("permutation.out");
#define ll long long

class Sum_Pref {
public:
	ll *pref_sum;

	Sum_Pref() {
		pref_sum = new ll[n];
		pref_sum[0] = 1;
		for (int i = 1; i < n; ++i) 
			pref_sum[i] = pref_sum[i - 1] + i + 1;
	}
};

class Hash {
public:
	ll *hash;

	Hash() {
		hash = new ll[n];
		for (int i = 0; i <	n; ++i) {
			hash[i] = generate_hash(i + 1);
		}
	}

	ll generate_hash(ll value) {
		ll res = 1;
		ll a = 123;
		while (value) {
			if (value & 1) {
				res *= a;
			}
			a *= a;
			value = value >> 1;
		}
		return res;
	}
};

class Hash_Pref {
public:
	ll *sum;

	Hash_Pref() {
		hash_el = new Hash();
		sum = new ll[n];
		sum[0] = hash_el->hash[0];
		for (int i = 1; i < n; ++i) {
			sum[i] = sum[i - 1] + hash_el->hash[i];
		}
	}
};

struct Result {
	ll sum, hashSum;

	Result() {
		sum = hashSum = 0;
	}

	Result(int length) {
		sum = sums->pref_sum[length - 1];
		hashSum = hash_pref_sum->sum[length - 1];
	}

	Result(ll sum, ll hashSum) {
		this->sum = sum;
		this->hashSum = hashSum;
	}
};
Result zero;


struct Tree {
	int begin, end;
	Tree *left_child, *right_child;
	Result res;

	Tree(int begin, int end) {
		this->begin = begin;
		this->end = end;
		this->left_child = nullptr;
		this->right_child = nullptr;
		if (this->end - this->begin > 1) {
			int mid = (begin + end) / 2;
			left_child = new Tree(begin, mid);
			right_child = new Tree(mid, end);
			res = Result(left_child->res.sum + right_child->res.sum, left_child->res.hashSum + right_child->res.hashSum);
		} else {
			fin >> res.sum;
			res.hashSum = hash_el->hash[res.sum - 1];
		}
	}

	void update(int index, int value) {
		if (left_child != nullptr) {
			(index < left_child->end ? left_child : right_child)->update(index, value);
			res = Result(left_child->res.sum + right_child->res.sum, left_child->res.hashSum + right_child->res.hashSum);
		}
		else {
			res.sum = value;
			res.hashSum = hash_el->hash[res.sum - 1];
		}
	}

	bool is_permutation(int begin, int end) {
		Result tmp1(end - begin);
		Result tmp2 = count(begin, end);
		return (tmp1.sum == tmp2.sum) && (tmp1.hashSum == tmp2.hashSum);
	}

	Result count(int begin, int end) {
		if (begin >= end) {
			return zero;
		} else if (begin == this->begin && end == this->end) {
			return res;
		} else {
			Result tmp1 = left_child->count(begin, min(end, left_child->end));
			Result tmp2 = right_child->count(max(begin, right_child->begin), end);
			return Result(tmp1.sum + tmp2.sum, tmp1.hashSum + tmp2.hashSum);
		}
	}
};

int main() {
	ios::sync_with_stdio(false);
	fin >> n;
	sums = new Sum_Pref();
	hash_pref_sum = new Hash_Pref();
	Tree tree(0, n);
	fin >> m;
	for (int i = 0; i < m; ++i) {
		fin >> t >> x >> y;
		if (t == 1) {
			tree.update(x - 1, y);
		} else {
			if (tree.is_permutation(x - 1, y))
				fou << "YES" << '\n';
			else
				fou << "NO" << '\n';
		}
	}
	fin.close();
	fou.close();
	return 0;
}