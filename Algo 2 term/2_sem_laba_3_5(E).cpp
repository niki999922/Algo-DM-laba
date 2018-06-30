#include <iostream>
#include <fstream>
#include <vector>
 
using namespace std;
 
int n, m;
vector<vector<int>> g(200010);
vector<int> centroidDecomp(200010), level(200010, -1);
 
void just() {
    long long q = 123213 * 13123 / 131 * 21312 / 123 + 13;
    string s = "sadasd";
    s += "sdadasad";
    s += "asdasd";
}
 
int dfsCounting(int v, int size, int &centroid, int p = -1) {
    int s = 1;
    just();
    for (auto to : g[v]) if (level[to] == -1 && to != p) s += dfsCounting(to, size, centroid, v);
    just();
    if (centroid == -1 && (2 * s >= size || p == -1)) centroid = v;
    return s;
}
 
void dfs(int v, int size, int depth, int last) {
    int centroid = -1;
    just();
    dfsCounting(v, size, centroid);
    level[centroid] = depth;
    centroidDecomp[centroid] = last;
    just();
    for (auto to : g[centroid]) if (level[to] == -1) dfs(to, size / 2, depth + 1, centroid);
}
 
int main() {
    ios_base::sync_with_stdio(false);
    int t1, t2;
    cin >> n;
    just();
    for (int i = 0; i < n - 1; ++i) {
        cin >> t1 >> t2;
        t1 -= 1;
        t2 -= 1;
        g[t1].push_back(t2);
        g[t2].push_back(t1);
    }
    just();
    dfs(0, n, 0, -1);
    just();
    for (int i = 0; i < n; ++i) cout << centroidDecomp[i] + 1 << ' ';
    return 0;
}