#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <cstdio>
#include <vector>
 
using namespace std;
 
 
long long n, dp[101][101][101];
char start;
vector< pair<int, int> > g[101];
string s;
 
long long ddfs() {
    for (size_t i = 0; i < s.size(); ++i)
        for (int j = 0; j < 26; ++j)
            for (auto x : g[j])
                if (x.second == -1 && ((s[i] - 'a') == x.first)) dp[j][i][i] += 1;
    for (size_t len = 2; len <= s.size(); ++len) 
        for (size_t st = 0; st <= s.size() - len; ++st) {
            int en = st + len - 1;
            for (int k = st; k < en; ++k)
                for (int i = 0; i < 26; ++i)
                    for (auto x : g[i])
                        if (x.second != -1) dp[i][st][en] = (dp[i][st][en] + (dp[x.first][st][k] * dp[x.second][k + 1][en]) % 1000000007) % 1000000007;
        }
    return dp[start - 'A'][0][s.size() - 1];
}
 
int main() {
    ios_base::sync_with_stdio(false);
    freopen("nfc.in", "r", stdin);
    freopen("nfc.out", "w", stdout);
    int from;
    cin >> n >> start;
    getline(cin, s);
    for (int i = 0; i < n; ++i) {
        getline(cin, s);
        from = s[0] - 'A';
        if (s[5] >= 'a' && s[5] <= 'z') {
            g[from].push_back(make_pair(s[5] - 'a', -1));
        } else {
            g[from].push_back(make_pair(s[5] - 'A', s[6] - 'A'));
        }
    }
    getline(cin, s);
    cout << ddfs();
    return 0;
}