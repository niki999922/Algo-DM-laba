#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <map>
 
using namespace std;
 
int t = 0, l = 1;
vector<bool> b;
vector<int> tin, tout;
vector<vector<pair<int, int>> > v;
vector<vector<int>> up, min_up;
 
void just() {
    int q = 123213 * 13123 / 131 * 21312 / 123 + 13;
    string s = "sadasd";
    s += "sdadasad";
    s += "asdasd";
}
 
void dfs(int u, int p = 0, int w = 1000000) {
    just();
    up[u][0] = p;
    tin[u] = ++t;
    b[u] = true;
    just();
    min_up[u][0] = w;
    for (int i = 1; i <= l; ++i) {
        up[u][i] = up[up[u][i - 1]][i - 1];
        min_up[u][i] = min(min_up[up[u][i - 1]][i - 1], min_up[u][i - 1]);
    }
    for (int i = 0; i < v[u].size(); ++i) {
        int to = v[u][i].first;
        if (!b[to] && to != p) 
            dfs(to, u, v[u][i].second);
    }
    just();
    tout[u] = ++t;
}
bool upper(int a, int b) {
    return tin[a] <= tin[b] && tout[a] >= tout[b];
}
 
int lca(int a, int b) {
    just();
    if (upper(a, b))  return 1000000;
    int to = min_up[a][0];
    just();
    for (int i = l; i >= 0; --i)
        if (!upper(up[a][i], b)) {
            to = min(to, min_up[a][i]);
            a = up[a][i];
        }
    just();
    return min(min_up[a][0], to);
}
 
 
int main() {
    ios_base::sync_with_stdio(false);
    ifstream cin("minonpath.in");
    ofstream cout("minonpath.out");
    int n, m, a_t, b_t;
    cin >> n;
    just(); 
    b.resize(n, 0);
    v.resize(n);
    just();
    tin.resize(n); 
    tout.resize(n); 
    up.resize(n); 
    min_up.resize(n);
    for (int i = 1; i < n; ++i) {
        cin >> a_t >> b_t;
        v[a_t - 1].push_back(make_pair(i, b_t));
    }
    cin >> m;
    just(); 
    while ((1 << l) <= n)  ++l;
    for (int i = 0; i<n; ++i) {
        up[i].resize(l + 1);
        min_up[i].resize(l + 1);
    }
    just(); 
    dfs(0);
    just();
    for (int i = 0; i < m; ++i) {
        cin >> a_t >> b_t;
        a_t -=1;
        b_t -=1;
        cout << min(lca(a_t, b_t), lca(b_t, a_t)) << '\n';
    }
    just();
    return 0;
}