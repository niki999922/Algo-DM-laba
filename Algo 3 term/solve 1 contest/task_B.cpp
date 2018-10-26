#include <iostream>
#include <vector>
#include <iomanip>
#include <algorithm>
#include <map>

using namespace std;

vector<vector<int>> g;
vector<int> used;
vector<long long> tin, tou, ans;
vector<pair<int, int>> bridge;
map<pair<int, int>, long long> input_data;

long long _time = 0;


void dfs(int v, int p) {
    used[v] = 1;
    _time++;
    tin[v] = _time;
    tou[v] = _time;
    for (long long i = 0; i < g[v].size(); ++i) {
        int to = g[v][i];
        if (used[to]) {
            if (to != p) {
                tou[v] = min(tou[v], tin[to]);
            }
        } else {
            dfs(to, v);
            tou[v] = min(tou[v], tou[to]);
            if (tin[v] < tou[to]) {
                map<pair<int, int>, long long>::iterator it = input_data.find(make_pair(to + 1, v + 1));
                if (it == input_data.end())  it = input_data.find(make_pair(v + 1, to + 1));
                ans.push_back(it->second);
                
            }
        }
    }
}

int main() {
    std::ios::sync_with_stdio(false);
    long long n, m, a ,b;
    cin >> n >> m;
    g.resize(n);
    ans.reserve(n);
    tin.resize(n);
    tou.resize(n);
    used.resize(n, 0);
    for (long long i = 0; i < m; ++i) {
        cin >> a >> b;
        input_data.insert(pair<pair<int, int>, long long>(pair<int,int>(a, b), i + 1));
        g[a - 1].push_back(b - 1);
        g[b - 1].push_back(a - 1);
    }
    for (int i = 0; i < n; ++i) {
        if (!used[i])
            dfs(i, i);
    }
    sort(ans.begin(), ans.end());
    cout << ans.size() << '\n';
    for(long long i = 0; i < ans.size(); ++i) { 
        cout << ans[i] << '\n';
    }
    return 0;
}



