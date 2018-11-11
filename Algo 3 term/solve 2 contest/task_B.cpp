#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <fstream>
#include <vector>
#include <set>
#include <string>

using namespace std;

const int INF = 1000000000;
#define ll long long

struct Edge {
    ll to, w;
    Edge(int to, int w) : to(to), w(w) {}
    Edge():to(0), w(0) {}
};

int n, m;
size_t min_num;
vector<vector<Edge>> graph;
vector<ll> d;
set<pair<ll,ll>> s;

int main() {
    std::ios::sync_with_stdio(false);
    cin >> n >> m;
    graph.resize(n);
    d.resize(n, INF);
    ll a, b, c;
    for(size_t i = 0; i < m; ++i) {
        cin >> a >> b >> c;
        graph[a - 1].push_back(Edge(b - 1, c));
        graph[b - 1].push_back(Edge(a - 1, c));
    }
    d[0] = 0;
    s.insert(make_pair(d[0], 0));
    while(!s.empty()) {
        min_num = s.begin()->second;
        s.erase(s.begin());
        for(size_t i = 0; i < graph[min_num].size(); ++i) {
            ll to = graph[min_num][i].to;
            ll len = graph[min_num][i].w;
            if (d[min_num] + len < d[to]) {
                s.erase(make_pair(d[to], to));
                d[to] = d[min_num] + len;
                s.insert(make_pair(d[to], to));
            }
        }
    }
    for(size_t i = 0; i < n; ++i)
        cout << d[i] << ' ';
    return 0;
}