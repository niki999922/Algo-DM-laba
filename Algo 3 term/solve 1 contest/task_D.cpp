#include <iostream>
#include <vector>
#include <iomanip>
#include <math.h>
#include <set>
#include <map>
#include <algorithm>

using namespace std;

const long long INF = 999999999;

vector<pair<set<int>, set<int>>> comp;

vector<vector<pair<int,int>>> g;
vector<int> tin, tou;
set<int> bridges;
int _time = 0;

vector<bool> used;
vector<int> order, color;
int to, a, b, id1, id2;


void dfs2(int v, int c) {
    used[v] = true;
    color[v] = c;
    for (size_t i = 0; i < g[v].size(); i++) {
        to = g[v][i].first;
        if (!used[to] && !bridges.count(g[v][i].second))
            dfs2(to, c);
    }
}


void dfs(int v, int p = -1) {
    used[v] = 1;
    _time++;
    tin[v] = _time;
    tou[v] = _time;
    for (long long i = 0; i < g[v].size(); ++i) {
        int to = g[v][i].first;
        if (used[to]) {
            if (to != p) {
                tou[v] = min(tou[v], tin[to]);
            }
        } else {
            dfs(to, v);
            tou[v] = min(tou[v], tou[to]);
            if (tin[v] < tou[to]) {                
                bridges.insert(g[v][i].second);
            }
        }
    }
}


int main() {
    std::ios::sync_with_stdio(false);
    int n, m, v;
    cin >> n >> m;
    g.resize(n);
    color.resize(n, 0);
    for (int i = 0; i < m; ++i) {
        cin >> a >> b;
        g[a - 1].push_back(make_pair(b - 1, i + 1));
        g[b - 1].push_back(make_pair(a - 1, i + 1));
    }
    used.resize(n, false);
    tin.resize(n);
    tou.resize(n);
    for (int i = 0; i < n; ++i)
        if (!used[i])
            dfs(i);
    used.clear();
    used.resize(n, false); 
    int cnt = 0;
    for (int i = 0; i < n; ++i)
        if (!used[i])
            dfs2(i, cnt++);
    cout << cnt << '\n';
    for (int i = 0; i < n; ++i)
        cout << color[i] + 1 << ' ';
    return 0;
}