#include <iostream>
#include <algorithm>
#include <cstdio>

using namespace std;
#define ll long long
char str;
int n, a, b, d;

class Tree {
public:
	int begin, end;
	ll maxim = 0; 
	ll sum = 0;
	ll add = 0;
	Tree *left_child = nullptr;
	Tree *right_child = nullptr;
	bool flag = true;

	Tree(int begin, int end) {
		this->begin = begin;
		this->end = end;
	}

	void pushing() {
		if (left_child == nullptr || right_child == nullptr) {
			int mid = (begin + end) >> 1;
			left_child = new Tree(begin, mid);
			right_child = new Tree(mid, end);
		}
		if (flag) {
			left_child->add = add;
			right_child->add = add;
			left_child->sum = add * (left_child->end - left_child->begin);
			left_child->maxim = add * (left_child->end - left_child->begin);
			left_child->flag = true;
			right_child->sum = add * (right_child->end - right_child->begin);
			right_child->maxim = add * (right_child->end - right_child->begin);
			right_child->flag = true;
			this->add = 0;
			this->flag = false;
		}
	}

	void update(int begin, int end, ll new_value) {
		if (begin >= end) {
			return;
		} else if (this->begin == begin && this->end == end) {
			this->add = new_value;
			this->sum = add * (this->end - this->begin);
			this->maxim = add * (this->end - this->begin);
			this->flag = true;
		} else {
			pushing();
			left_child->update(begin, min(left_child->end, end), new_value);
			right_child->update(max(right_child->begin, begin), end, new_value);
			maxim = max(left_child->maxim, left_child->sum + right_child->maxim);
			sum = left_child->sum + right_child->sum;
		}
	}

	int find(ll hight) {
		if (end - begin > 1) {
			pushing();
			if (left_child->maxim <= hight) {
				ll tmp = hight - left_child->sum;
				return right_child->find(tmp);
			} else {
				return left_child->find(hight);
			}
		}
		int res = begin;
		if (!(maxim <= hight))
			res--;
		return res;
	}
};

int main() {
	ios::sync_with_stdio(false);
	cin >> n >> str;
	Tree tree(0, n);
	while (str != 'E') {
		if (str == 'I') {
			cin >> a >> b >> d;
			a--;
			tree.update(a, b, d);
		} else {
			cin >> a;
			int res = tree.find(a) + 1;
			cout << res << '\n';
		}
		cin >> str;
	}
	return 0;
}