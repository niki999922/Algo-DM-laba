#include <iostream>
#include <vector>
#include <fstream>
#include <algorithm>
#include <string>

using namespace std;

struct Node {
	long long value;
	long long add_value;
	bool flag_set;
	bool flag_add;
};

Node mas[3000000];
long long star[500100];
int n;
long long val, place, inf = LLONG_MAX-1;

void pushing(int v) {
	if (mas[v].flag_set && mas[v].flag_add) {
		mas[(v << 1) + 1].value = mas[v].value;
		mas[(v << 1) + 2].value = mas[v].value;
		mas[(v << 1) + 1].flag_set = 1;
		mas[(v << 1) + 2].flag_set = 1;
		mas[v].flag_set = 0;
		mas[(v << 1) + 1].add_value = mas[v].add_value;
		mas[(v << 1) + 2].add_value = mas[v].add_value;
		mas[(v << 1) + 1].flag_add = 1;
		mas[(v << 1) + 2].flag_add = 1;
		mas[v].value += mas[v].add_value;
		mas[v].flag_add = 0;
		mas[v].add_value = 0;
	}
	if (!mas[v].flag_set && mas[v].flag_add) {
		mas[(v << 1) + 1].add_value += mas[v].add_value;
		mas[(v << 1) + 2].add_value += mas[v].add_value;
		mas[(v << 1) + 1].flag_add = 1;
		mas[(v << 1) + 2].flag_add = 1;
		mas[v].value += mas[v].add_value;
		mas[v].flag_add = 0;
		mas[v].add_value = 0;
	}
	if (mas[v].flag_set && !mas[v].flag_add) {
		mas[(v << 1) + 1].value = mas[v].value;
		mas[(v << 1) + 2].value = mas[v].value;
		mas[(v << 1) + 1].add_value = 0;
		mas[(v << 1) + 2].add_value = 0;
		mas[(v << 1) + 1].flag_set = 1;
		mas[(v << 1) + 2].flag_set = 1;
		mas[v].flag_set = 0;
	}	
}

void add(int v, int tl, int tr,int l, int r)
{
	if (l > r)
        return;
	if (tl > tr || tr < l || tl > r)
		return;
	if (l <= tl && tr <= r)	{
		if (tl != tr) {
			mas[v].flag_add = 1;
			mas[v].add_value += val;
		} else {
			mas[v].value += val;
		}
		return;
	}
	int tmp = (tl + tr) >> 1;
	pushing(v);
	add((v << 1) + 1, tl, tmp, l, min(r,tmp));
	add((v << 1) + 2, tmp + 1, tr, max(l, tmp + 1), r);
	mas[v].value = min(mas[(v << 1) + 1].value + mas[(v << 1) + 1].add_value, mas[(v << 1) + 2].value + mas[(v << 1) + 2].add_value);
}

void set(int v, int tl, int tr,int l, int r)
{
	if (l > r)
        return;
	if (tl > tr || tr < l || tl > r)
		return;
	if (l <= tl && tr <= r)	{
		mas[v].flag_add=0;
		if (tl != tr) mas[v].flag_set=1;
		mas[v].value=val;
		mas[v].add_value=0;
		return;
	}
	int tmp = (tl + tr) >> 1;
	pushing(v);
	set((v << 1) + 1, tl, tmp, l, min(r,tmp));
	set((v << 1) + 2, tmp+1, tr, max(l, tmp + 1), r);
	mas[v].value = min(mas[(v << 1) + 1].value + mas[(v << 1) + 1].add_value,mas[(v << 1) + 2].value + mas[(v << 1) + 2].add_value);
}
 
long long min(int v, int tl, int tr,int l, int r)
{
	if (l > r)
        return inf;
	if (tl > tr || tr < l || tl > r)
		return inf;
	if (l <= tl && tr <= r) {	
		return mas[v].value + mas[v].add_value;
	}
    int tmp = (tl + tr) >> 1;
	pushing(v);
	mas[v].value = min(mas[(v << 1) + 1].value + mas[(v << 1) + 1].add_value, mas[(v << 1) + 2].value + mas[(v << 1) + 2].add_value);
	return min(min((v << 1) + 1, tl, tmp, l, min(r,tmp)), min((v << 1) + 2, tmp+1, tr, max(l, tmp + 1), r));
}
 
inline int get_hight() 
{
    int l = n - 1;
    int i = 0;
    while (l > 0)
    {
        ++i;
        l = l >> 1;
    }
    return i;
}
 
void build (int v, int tl, int tr) {
	if (tl == tr) {
		if (tl <= n)
			mas[v].value = star[tl-1];
		else 
			mas[v].value = inf;
	}
	else {
		int tm = (tl + tr) / 2;
		build ((v << 1) + 1, tl, tm);
		build ((v << 1) + 2, tm + 1, tr);
		mas[v].value = min(mas[(v << 1) + 1].value, mas[(v << 1) + 2].value);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	ifstream fin("rmq2.in");	
	ofstream fou("rmq2.out");
	fin >> n;
	for(int i = 0; i < n; ++i) 
		fin >> star[i];
	int el1, el2;
	string str;
	int line_l = (1 << get_hight()) - 1;
	build(0,1,line_l+1);
	while(fin >> str >> el1 >> el2) {
		if (str == "min") {
			fou << min(0, 1, line_l + 1, el1, el2) << '\n';
		}
		if (str == "set") {
			fin >> val;
			set(0, 1, line_l + 1, el1, el2);
		}
		if (str == "add") {
			fin >> val;
			add(0, 1, line_l + 1, el1, el2);
		}
	}
	fin.close();
	fou.close();
	return 0;
}