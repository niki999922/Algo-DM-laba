#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <string>

using namespace std;

bool term[200000];
int to[200000][30];

int main()
{
	ios_base::sync_with_stdio(false);
	freopen("problem1.in", "r", stdin);
	freopen("problem1.out", "w", stdout);
	string s;
	cin >> s;
	int n, m, k, tmp1, tmp2, current = 1;
	char c;
	cin >> n >> m >> k;
	for (int i = 0; i < n; i++) {
		term[i + 1] = false;
		for (int j = 0; j < 28; ++j) to[i + 1][j] = 0;
	}
	for (int i = 0; i < k; i++) {
		cin >> tmp1;
		term[tmp1] = true;
	}
	for (int i = 0; i < m; i++) {
		cin >> tmp1 >> tmp2 >> c;
		to[tmp1][c - 'a'] = tmp2;
	}
	for (size_t i = 0; i < s.size(); i++) {
		if (to[current][s[i] - 'a'] == 0) {
			cout << "Rejects" << '\n';
			return 0;
		} else
			current = to[current][s[i] - 'a'];
	}
	cout << ((term[current]) ? "Accepts" : "Rejects") << endl; 
	return 0;
}