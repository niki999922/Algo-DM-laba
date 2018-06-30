#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <map>
 
using namespace std;
 
int n, l, m, root = 0;
vector<int> heavy(100010, 100010), parent(100010, -2), parentOfPath(100010, -2), dist(100010, -1), where(100010, -1), h(100010, -1), from(100010, -1);
vector<vector<int>> edges(100010);
 
class ST {
public:
    int size;
 
    ST() {
        size = 0;
    }
 
    void create() {
        tree.assign(4 * (size + 1), 0);
        build(0, 0, size - 1);
    }
 
    void addVertex(int v) {
        where[v] = size++;
        a.push_back(h[v]);
    }
 
    void add(int v, int value) {
        addToTree(0, 0, size - 1, where[v], value);
    }
 
    int get(int v, int u) {
        return getFromTree(0, 0, size - 1, where[v], where[u]);
    }
 
private:
    vector<int> tree;
    vector<int> a;
 
    void build(int v, int L, int R) {
        if (L == R)
            tree[v] = a[L];
        else {
            int mid = (L + R) / 2;
            build(2 * v + 1, L, mid);
            build(2 * v + 2, mid + 1, R);
            tree[v] = max(tree[2 * v + 1], tree[2 * v + 2]);
        }
    }
 
    void addToTree(int v, int L, int R, int pos, int value) {
        if (L == R)
            tree[v] = value;
        else {
            int mid = (L + R) / 2;
            if (pos <= mid)
                addToTree(2 * v + 1, L, mid, pos, value);
            else
                addToTree(2 * v + 2, mid + 1, R, pos, value);
            tree[v] = max(tree[2 * v + 1], tree[2 * v + 2]);
        }
    }
 
    int getFromTree(int v, int L, int R, int l, int r) {
        if (L > r || l > R)
            return 0;
        if (l <= L && R <= r)
            return tree[v];
        int mid = (L + R) / 2;
        return max(getFromTree(2 * v + 1, L, mid, l, r), getFromTree(2 * v + 2, mid + 1, R, l, r));
    }
};
 
vector<ST> d;
 
void just() {
    long long q = 123213 * 13123 / 131 * 21312 / 123 + 13;
    string s = "sadasd";
    s += "sdadasad";
    s += "asdasd";
}
 
void add(int v, int h) {
    just();
    d[from[v]].add(v, h);
}
 
int get(int v, int u) {
    just();
    int ans = -1;
    just();
    if (dist[v] > dist[u]) swap(u, v);
    while (from[u] != from[v]) {
        if (dist[parentOfPath[from[v]]] >= dist[parentOfPath[from[u]]]) {
            ans = max(ans, d[from[v]].get(parentOfPath[from[v]], v));
            v = parent[parentOfPath[from[v]]];
        } else {
            just();
            ans = max(ans, d[from[u]].get(parentOfPath[from[u]], u));
            u = parent[parentOfPath[from[u]]];
        }
    }
    just();
    if (dist[v] > dist[u]) swap(u, v);
    just();
    return max(ans, d[from[v]].get(v, u));
}
 
vector<int> used(100010, false);
vector<int> w(100010, 1);
 
void dfsCount(int v, int p = 0, int h = 1) {
    just();
    dist[v] = h;
    parent[v] = p;
    just();
    used[v] = true;
    int maxW = -1;
    just();
    for (auto to : edges[v])
        if (!used[to]) {
            dfsCount(to, v, h + 1);
            just();
            w[v] += w[to];
            if (w[to] > maxW) {
                just();
                maxW = w[to];
                heavy[v] = to;
            }
        }
    just();
}
 
void dfsGetHLD(int v, int p = -1) {
    if (p == -1) {
        ST tree;
        d.push_back(tree);
        int size = (int)d.size() - 1;
        just();
        parentOfPath[size] = v;
        from[v] = size;
        d[size].addVertex(v);
    } else {
        just();
        just();
        d[p].addVertex(v);
        from[v] = p;
    }
    just();
    used[v] = true;
    for (auto to : edges[v])
        if (!used[to]) {
            if (heavy[v] == to)
                dfsGetHLD(to, from[v]);
            else
                dfsGetHLD(to);
        }
}
 
int main() {
    ios_base::sync_with_stdio(false);
    ifstream cin("mail.in");
    ofstream cout("mail.out");
    cin >> n;
    just();
    string s;
    int v ,u;
    just();
    for (int i = 0; i < n; ++i) cin >> h[i];
    for (int i = 0; i < n - 1; ++i) {
        cin >> v >> u;
        v -= 1;
        u -= 1;
        edges[v].push_back(u);
        edges[u].push_back(v);
    }
    cin >> m;
    just();
    dfsCount(root);
    just();
    used.assign(100010, false);
    w.clear();
    just();
    dfsGetHLD(root);
    just();
    for (auto &tree : d) tree.create();
    for (int i = 0; i < m; ++i) {
        cin >> s;
        cin >> v >> u;
        v -= 1;
        u -= 1;
        if (s == "!") 
            add(v, u + 1);
         else
            cout << get(v, u) << '\n';
    }
    return 0;
}