#include <iostream>
#include <vector>

using namespace std;

vector <vector<long>> graph;
vector <bool> used;
vector <int> ans;
vector <int> color;

bool beCicle = 0; 

void dfs(int v) {
    if (used[v]) return;
    used[v] = 1;
    for (size_t i = 0; i < graph[v].size(); ++i) {
        dfs(graph[v][i]);
    }
    ans.push_back(v + 1);
}

void cyclic(int v) {
    color[v] = 1;
    for (size_t i = 0; i < graph[v].size(); ++i) {
        if (beCicle) break;
        long to = graph[v][i];
        if (color[to] == 0) cyclic(to);
        else if (color[to] == 1) { 
            beCicle = true; 
            break;
        }
    }
    color[v] = 2;
}

int main() {
    std::ios::sync_with_stdio(false);
    long n, m, a, b;
    cin >> n >> m;
    graph.resize(n);
    used.resize(n);
    color.resize(n);
    for (long i = 0; i < m; ++i) {
        cin >> a >> b;
        graph[a - 1].push_back(b - 1);
    }
    for (long i = 0; i < n; ++i) {
        if (color[i] != 2) cyclic(i);
        if (beCicle) {
            cout << "-1";
            return 0;
        }
    }
    for (long i = 0; i < n; ++i) {
        dfs(i);
    }
    for (long i = n - 1; i >= 0; --i) {
        cout << ans[i] << " ";
    }
    return 0;
}