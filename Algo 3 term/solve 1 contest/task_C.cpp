#include <iostream>
#include <vector>
#include <iomanip>
#include <algorithm>
#include <map>
#include <set>

using namespace std;


vector<vector<long long>> g;
vector<long long> used;
vector<long long> tin, tou;
set<long long> ans;

long long _time = 0;

void dfs(long long v, long long p = -1) {
    used[v] = true;
    tin[v] = tou[v] = _time++;
    long long children = 0;
    for (long long i = 0; i < g[v].size(); ++i) {
        long long to = g[v][i];
        if (used[to]) {
            if (to == p) continue;
            tou[v] = min(tou[v], tin[to]);
        }
        else {
            dfs(to, v);
            tou[v] = min(tou[v], tou[to]);
            if (tou[to] >= tin[v] && p != -1)
                ans.insert(v);
            ++children;
        }
    }
    if (p == -1 && children > 1)
        ans.insert(v);
}



int main() {
    std::ios::sync_with_stdio(false);
    long long n, m, a, b;
    cin >> n >> m;
    g.resize(n);
    tin.resize(n);
    tou.resize(n);  
    used.resize(n, 0);
    for (long long i = 0; i < m; ++i) {
        cin >> a >> b;
        g[a - 1].push_back(b - 1);
        g[b - 1].push_back(a - 1);
    }
    for (int i = 0; i < n; i++)
        if (!used[i]) {
            _time = 0;
            dfs(i);
    }
    cout << ans.size() << "\n";
    for (auto it : ans) {
        cout << (it + 1) << ' ';
    }
    return 0;
}



