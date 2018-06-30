#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <set>
#include <map>
 
using namespace std;
 
int color[1000010], res[1000010];
vector<vector<int>> g;
set<int> s[1000010];
 
void add(set<int> &a, set<int> &b)
{
    if (a.size() < b.size()) a.swap(b);
    for (auto it : b) a.insert(it);
    b.clear();
}
 
void dfs(int v) {
    int to;
    s[v].insert(color[v]);
    for (auto it : g[v]) {
        dfs(it);
        add(s[v], s[it]);
    }
    res[v] = s[v].size();
}
 
int main() {
    int n, t1, t2;
    cin >> n;
    g.resize(n + 1);
    for (int i = 1; i <= n; ++i) {
        cin >> t1 >> t2;
        g[t1].push_back(i);
        color[i] = t2;
    }
    dfs(0);
    for (int i = 1; i <= n; i++) cout << res[i] << ' ';
    return 0;
}