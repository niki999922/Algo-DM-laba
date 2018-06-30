#include <iostream>
#include <fstream>
#include <algorithm>

using namespace std;

struct Color {
	char color;
	long long point;
	long long trace;
};

struct Paint {
	long long  value_long;
	long long value_sum;
	bool is_black_left;
	bool is_black_right;
	bool flag_set;
};

struct Node {
	long long value;
	long long add_value;
	bool flag_set;
	bool flag_add;
};

Paint mas[4000300];
Color star[500100];
long long n, n_el;
long long inf = LLONG_MAX-1;
int val, real_hight;


inline int get_hight(long long tmp_n) 
{
    int l = tmp_n - 1;
    int i = 0;
    while (l > 0)
    {
        ++i;
        l = l >> 1;
    }
    return i;
}
 
void pushing(int v) {
	if (mas[v].flag_set) {
		if (mas[v].is_black_left) {
			mas[(v << 1) + 1].is_black_left = 1;
			mas[(v << 1) + 2].is_black_right = 1;
			mas[(v << 1) + 2].is_black_left = 1;
			mas[(v << 1) + 1].is_black_right = 1;
			mas[(v << 1) + 1].flag_set = 1;
			mas[(v << 1) + 2].flag_set = 1;
			mas[(v << 1) + 1].value_long = mas[v].value_long >> 1;
			mas[(v << 1) + 2].value_long = mas[v].value_long >> 1;
			mas[(v << 1) + 1].value_sum = mas[v].value_sum;
			mas[(v << 1) + 2].value_sum = mas[v].value_sum;
		} else {
			mas[(v << 1) + 1].is_black_left = 0;
			mas[(v << 1) + 2].is_black_right = 0;
			mas[(v << 1) + 2].is_black_left = 0;
			mas[(v << 1) + 1].is_black_right = 0;
			mas[(v << 1) + 1].flag_set = 1;
			mas[(v << 1) + 2].flag_set = 1;
			mas[(v << 1) + 1].value_long = mas[v].value_long;
			mas[(v << 1) + 2].value_long = mas[v].value_long;
			mas[(v << 1) + 1].value_sum = mas[v].value_sum;
			mas[(v << 1) + 2].value_sum = mas[v].value_sum;
		}
		mas[v].flag_set = 0;
	}
}

void set(long long v, int tl, int tr,int l, int r, long long sons)
{
	if (l > r)
        return;
	if (tl > tr || tr < l || tl > r)
		return;
	if (l <= tl && tr <= r)	{
		if (tl != tr) mas[v].flag_set=1;
		if (val == 1) {
			mas[v].is_black_left = 1;
			mas[v].is_black_right = 1;
			mas[v].value_sum = 1;
			mas[v].value_long = sons;
		} else {
			mas[v].is_black_left = 0;
			mas[v].is_black_right = 0;
			mas[v].value_sum = 0;
			mas[v].value_long = 0;
		}
		return;
	}
	int tmp = (tl + tr) >> 1;
	pushing(v);
	set((v << 1) + 1, tl, tmp, l, min(r,tmp),sons >> 1);
	set((v << 1) + 2, tmp+1, tr, max(l, tmp + 1), r, sons >> 1);
	if (mas[(v << 1) + 2].is_black_left && mas[(v << 1) + 1].is_black_right) 
		mas[v].value_sum = mas[(v << 1) + 2].value_sum + mas[(v << 1) + 1].value_sum - 1;
	else 
		mas[v].value_sum = mas[(v << 1) + 2].value_sum + mas[(v << 1) + 1].value_sum;
	mas[v].value_long = mas[(v << 1) + 2].value_long + mas[(v << 1) + 1].value_long;
	if (mas[(v << 1) + 1].is_black_left)
		mas[v].is_black_left = 1;
	else
		mas[v].is_black_left = 0;
	if (mas[(v << 1) + 2].is_black_right)
		mas[v].is_black_right = 1;
	else
		mas[v].is_black_right = 0;
}
 

int main() {
	ios_base::sync_with_stdio(false);
	ifstream fin("painter.in");
	ofstream fou("painter.out");
	fin >> n_el;
	fin >> star[0].color >> star[0].point >> star[0].trace;
	long long min_x = star[0].point, max_x = star[0].point + star[0].trace;
	for(long long i = 1; i < n_el; ++i)  {
		fin >> star[i].color >> star[i].point >> star[i].trace;
		if (star[i].point < min_x) 
			min_x = star[i].point;
		if (max_x < star[i].point + star[i].trace) 
			max_x = star[i].point + star[i].trace;
	}
	n = max_x - min_x + 1;
	real_hight = get_hight(n);
	int line_l = (1 << real_hight ) - 1;
	long long smesh = 1;
	if (min_x != 0 ) smesh = -min_x + 1;
	for(long long i = 0; i < n_el; ++i) {
		if (star[i].color == 'W') 
			val = 0;
		else 
			val = 1;
		set(0, 1, line_l+1, star[i].point + smesh, star[i].point + star[i].trace + smesh - 1, line_l+1);
		fou << mas[0].value_sum << ' ' << mas[0].value_long << '\n';
	}
	fin.close();
	fou.close();
	return 0;
}


/*
Answer

0 0
1 2
1 4
1 4
2 6
3 5
0 0

Task
7
W 2 3
B 2 2
B 4 2
B 3 2
B 7 2
W 3 1
W 0 10


*/


