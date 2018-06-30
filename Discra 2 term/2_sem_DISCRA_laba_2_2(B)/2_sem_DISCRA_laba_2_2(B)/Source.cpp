#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <vector>
#include <string>

using namespace std;

vector<int> term;
vector<int> from_point[10001][30];
bool way[10001][101]; 

int main() {
	ios_base::sync_with_stdio(false);
	freopen("problem2.in", "r", stdin);
	freopen("problem2.out", "w", stdout);
	string s;
	char c;
	int n, m, k, tmp1, tmp2;
	cin >> s >> n >> m >> k;
	for (size_t i = 0; i <= s.size(); ++i)
		for (int j = 1; j <= n; ++j)
			way[i][j] = false;
	way[0][1] = true;
	for (size_t i = 0; i < k; ++i) {
		cin >> tmp1;
		term.push_back(tmp1);
	}
	for (size_t i = 0; i < m; ++i) {
		cin >> tmp1 >> tmp2 >> c;
		from_point[tmp2][c - 'a'].push_back(tmp1);
	}
	for (size_t i = 1; i <= s.size(); ++i) {
		c = s[i - 1];
		for (size_t j = 1; j <= n; ++j) {
			bool can_go_here = false;
			vector<int> fr = from_point[j][c - 'a']; //all ways here
			for (size_t k = 0; k < fr.size(); ++k) {
				can_go_here = can_go_here | way[i - 1][fr[k]];
				if (can_go_here == true) break;
			}
			way[i][j] = can_go_here;
		}
	}
	for (size_t i = 0; i < k; i++) {
		if (way[s.size()][term[i]] == true){
			cout << "Accepts";
			return 0;
		}
	}
	cout << "Rejects";
	return 0;
}