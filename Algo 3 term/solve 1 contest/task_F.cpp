#include <iostream>
#include <vector>
#include <iomanip>
#include <math.h>
#include <set>
#include <algorithm>

using namespace std;

const long long INF = 999999999;

vector<pair<set<int>, set<int>>> comp;

vector<vector<int>> g, gr;
vector<bool> used;
vector<int> order, color;
int to, a, b, ans = 0;


class Edge {
public:
    int x, y;
    Edge() {}
    Edge(int x, int y) : x(x), y(y) {}

};


set<pair<int, int>> edges;

void dfs(int v) {
    used[v] = true;
    for (size_t i = 0; i < g[v].size(); ++i) {
        to = g[v][i];
        if (!used[to])
            dfs(to);
    }
    order.push_back(v);
}

void dfs2(int v, int cnt) {
    used[v] = true;
    color[v] = cnt;
    for (size_t i = 0; i < gr[v].size(); ++i) {
        to = gr[v][i];
        if (!used[to])
            dfs2(to, cnt);
    }
}

void dfs3(int v, int p) {
    if (color[v] == color[p] && used[v]) return;
    if (color[v] != color[p]) {
        if (edges.find(make_pair(v, p)) == edges.end() && edges.find(make_pair(p, v)) == edges.end()) edges.insert(make_pair(v, p));
        if (used[v]) return;
    }
    used[v] = true;
    for (size_t i = 0; i < g[v].size(); ++i) {
        to = g[v][i];
        dfs3(to, v);
    }
}

int main() {
    std::ios::sync_with_stdio(false);
    int n, m, v;
    cin >> n >> m;
    g.resize(n);
    gr.resize(n);
    color.resize(n);
    for (int i = 0; i < m; ++i) {
        cin >> a >> b;
        g[a - 1].push_back(b - 1);
        gr[b - 1].push_back(a - 1);
    }
    used.resize(n, false);
    for (int i = 0; i < n; ++i) {
        if (!used[i]) dfs(i);
    }
    reverse(order.begin(), order.end());
    int cnt = 0;
    used.clear();
    used.resize(n, false);
    for (int i = 0; i < n; ++i) {
        v = order[i];
        if (!used[v]) {
            dfs2(v, cnt++);
        }
    }
    
    vector<vector<bool>> g_edge(cnt,vector<bool>(cnt,false));
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < g[i].size(); ++j) {
            to = g[i][j];
            if (color[i] != color[to])
                g_edge[color[i]][color[to]] = true;
        }
    }
    
    for (int i = 0; i < cnt; ++i) {
        for (int j = 0; j < cnt; ++j) {
            if (i == j) continue;
            if (g_edge[i][j]) ++ans;
        }
    }



    cout << ans << '\n';
    return 0;
}



