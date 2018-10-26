#include <iostream>
#include <fstream>
#include <vector>
#include <iomanip>
#include <math.h>
#include <set>
#include <map>
#include <string>
#include <algorithm>

using namespace std;

vector<vector<pair<int, int>>> g, gr;
vector<bool> used;
int n, ans = 0;

vector<int> order, color;

void dfs(int v, int max_w) {
    used[v] = true;
    for (size_t i = 0; i < g[v].size(); ++i) {
        int to = g[v][i].first;
        if (!used[to] && g[v][i].second <= max_w)
            dfs(to, max_w);
    }
    order.push_back(v);
}

void dfs2(int v, int cnt, int max_w) {
    used[v] = true; 
    color[v] = cnt;
    for (size_t i = 0; i < gr[v].size(); ++i) {
        int to = gr[v][i].first;
        if (!used[to] && gr[v][i].second <= max_w)
            dfs2(to, cnt, max_w);
    }
}


int main() {
    std::ios::sync_with_stdio(false);
    ifstream cin("avia.in");
    ofstream cout("avia.out");
    cin >> n;
    g.resize(n);
    gr.resize(n);
    used.resize(n, 0);
    int w;
    int mr = 0;
    for (size_t i = 0; i < n; ++i) {
        for (size_t j = 0; j < n; ++j) {
            cin >> w;
            if (mr < w) mr = w;
            g[i].push_back(make_pair(j, w));
            gr[j].push_back(make_pair(i, w));
        }
    }
    int l = -1;
    int r = mr + 1;
    while (l < r - 1) {
        int m = (l + r) / 2;
        ans = 0;
        used.clear();
        used.resize(n, false);
        color.clear();
        color.resize(n);
        order.clear();
        for (int i = 0; i < n; ++i) {
            if (!used[i]) dfs(i, m);
        }
        reverse(order.begin(), order.end());
        int cnt = 1;
        used.clear();
        used.resize(n, false);
        for (int i = 0; i < n; ++i) {
            int  v = order[i];
            if (!used[v]) {
                dfs2(v, cnt, m);
                cnt++;
            }
        }
        for (int i = 0; i < color.size(); ++i)
            ans += color[i];
        if (ans != n) {
            l = m;
        }
        else {
            r = m;
        }
    }
    cout << r << '\n';
    return 0;
}