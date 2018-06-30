#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <vector>
#include <map>
#include <queue>

using namespace std;

vector<int> term;
vector<int> from[100001][30];
vector<int> to[100001][30];
vector<int> fr;
long long way[1001][100001];
bool is_term[101];

int NFA_to_DFA() {
	queue<pair<vector<int>, int>> p;
    map<vector <int>, int> qd;
    vector<int> start, cur;
    int current_number;
    bool ter;
    pair<vector<int>, int> tmp;
    start.push_back(1);
    p.push(pair<vector<int>, int>(start, 1));
    qd.insert(pair<vector<int>, int>(start, 1));
    int n = 1;
	if (is_term[1]) term.push_back(1);
	while (p.size() > 0) {
        tmp = p.front();
        p.pop();
        cur = tmp.first;
		current_number = tmp.second;
		for (int i = 0; i <= 25; ++i) {
			vector<int> qcur;
			bool also_in_qcur[1001] = {};
			ter = false;
			for (int j = 0; j < cur.size(); ++j)
				for (int k = 0; k < to[cur[j]][i].size(); ++k) {
					if (!also_in_qcur[to[cur[j]][i][k]]) {
                        also_in_qcur[to[cur[j]][i][k]] = true;
						qcur.push_back(to[cur[j]][i][k]);
					}
                    if (is_term[to[cur[j]][i][k]]) ter = true;
			    }
			if (qcur.size() == 0) continue;
			if (qd.find(qcur) == qd.end()) {
				p.push(pair<vector<int>, int>(qcur, n + 1));
				qd.insert(pair<vector<int>, int>(qcur, n + 1));
				from[n + 1][i].push_back(current_number);
				if (ter) term.push_back(n + 1);
				++n;
			} else {
				from[qd.find(qcur)->second][i].push_back(current_number);
			}
		}
	}
	return n;
}

int main() {
    ios_base::sync_with_stdio(false);
    freopen("problem5.in", "r", stdin);
	freopen("problem5.out", "w", stdout);
	int n, m, k, l, tmp1, tmp2;
    int64_t ans = 0;
    char c;
    cin >> n >> m >> k >> l;
	for (size_t i = 0; i < k; ++i) {
		cin >> tmp1;
		is_term[tmp1] = true;
	}
	for (size_t i = 0; i < m; ++i) {
		cin >> tmp1 >> tmp2 >> c;
		to[tmp1][c - 'a'].push_back(tmp2);
	}
	n = NFA_to_DFA();
	way[0][1] = 1;
	for (size_t i = 1; i <= l; ++i)
		for (size_t j = 1; j <= n; ++j)
			for (size_t p = 0; p <= 25; ++p) {
				fr = from[j][p];
				for (int q = 0; q < fr.size(); ++q) way[i][j] += way[i - 1][fr[q]];
                way[i][j] = way[i][j] % 1000000007;
			}
	for (size_t i = 0; i < term.size(); ++i) {
		ans += way[l][term[i]];
		ans = ans % 1000000007;
	}
	cout << ans;
	return 0;
}