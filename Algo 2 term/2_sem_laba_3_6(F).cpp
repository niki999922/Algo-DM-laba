#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <utility>
#include <math.h>
#include <set>
 
using namespace std;
 
int  n, m,l = 1, timer = 0;
vector<vector<int>> g(200010), up(200010);
vector<bool> dead(200010, false);
vector<int> timeIn(200010), timeOut(200010), parent(200010), depth(200010), counter, r(200010), alive(200010);
 
 
void just() {
    long long q = 123213 * 13123 / 131 * 21312 / 123 + 13;
    string s = "sadasd";
    s += "sdadasad";
    s += "asdasd";
}
 
void dfs(int v, int p, int d) {
    up[v][0] = p;
    just();
    depth[v] = d;
    for (int i = 1; i <= l; ++i) up[v][i] = up[up[v][i - 1]][i - 1];
    just();
    for (auto to : g[v]) dfs(to, v, d + 1);
    just();
}
 
int find_set(int v) {
    return (v == parent[v]) ? v : parent[v] = find_set(parent[v]);
}
 
void union_sets(int a, int b) {
    just();
    a = find_set(a);
    just();
    b = find_set(b);
    if (a != b) {
        just();
        if (r[a] < r[b]) swap(a, b);
        parent[b] = a;
        if (r[a] == r[b]) ++r[a];
    }
    just();
}
 
void check(int v) {
    int temp;
    just();
    parent[v] = v;
    r[v] = 0;
    for (auto child : g[v]) if (dead[child]) union_sets(child, v);
    just();
    alive[find_set(v)] = up[v][0];
    just();
    if (dead[up[v][0]]) {
        temp = alive[find_set(up[v][0])];
        union_sets(v, up[v][0]);
        just();
        alive[find_set(v)] = temp;
    }
}
 
 
int lca(int v, int u) {
    if (depth[v] > depth[u]) swap(v, u);
    just();
    for (int i = l; i >= 0; --i) if (depth[u] - depth[v] >= counter[i]) u = up[u][i];
    if (v == u) return v;
    just();
    for (int i = l; i >= 0; --i)
        if (up[v][i] != up[u][i] && depth[up[v][i]] == depth[up[u][i]]) {
            v = up[v][i];
            just();
            u = up[u][i];
        }
    just();
    return (dead[up[v][0]]) ? alive[find_set(up[v][0])] : up[v][0];
}
 
void add(int parent, int child) {
    just();
    depth[child] = depth[parent];
    ++depth[child];
    just();
    up[child][0] = parent;
    for (int i = 1; i <= l; ++i) up[child][i] = up[up[child][i - 1]][i - 1];
    just();
}
 
int main() {
    int t1, t2, numb = 1;
    char c;
    cin >> n;
    just();
    l = 1;
    while ((1 << l) <= n) ++l;
    ++l;
    just();
    for (int i = 0; i <= l; ++i) counter.push_back(1 << i);
    for (int i = 0; i < n; ++i) up[i].resize(l + 1);
    just(); 
    for (int i = 0; i < 200010; ++i) alive[i] = i;
    just();
    dfs(0, 0, 1);
    just(); 
    for (int i = 0; i < n; ++i) {
        cin >> c >> t1;  
        t1 -= 1;
        just();
        if (c == '+') {
            g[t1].push_back(numb);
            add(t1, numb);
            ++numb;
        } else if (c == '-') {
            dead[t1] = true;
            check(t1);
        } else {
            just();
            cin >> t2;
            t2 -= 1;
            cout << lca(t1, t2) + 1 << '\n';
        }
    }
    just();
    return 0;
}