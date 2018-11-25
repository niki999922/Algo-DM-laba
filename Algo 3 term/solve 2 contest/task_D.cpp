#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

#define ll long long

using namespace std;

const ll INF = INT64_MAX / 3;



struct edge {
    ll to;
    ll w;
    edge(ll b, ll c) {
        to = b;
        w = c;
    }
};

ll n, m, k_step, s;
vector<vector<edge>> graph;
vector<vector<ll>> d;


int main() {
    std::ios::sync_with_stdio(false);
    cin >> n >> m >> k_step >> s;
    --s;
    graph.resize(n);
    d.resize(k_step + 1, vector<ll>(n, INF));
    d[0][s] = 0;
    ll a, b;
    ll c;
    for (ll i = 0; i < m; ++i) {
        cin >> a >> b >> c;
        --a;
        --b;
        graph[a].push_back(edge(b, c));
    }
    for (ll k = 0; k < k_step; ++k) {
        for (ll v = 0; v < n; ++v) {
            for (ll j = 0; j < graph[v].size(); ++j) {
                if (d[k][v] == INF) continue;
                ll from = v;
                ll to = graph[v][j].to;
                ll cost = graph[v][j].w;
                d[k + 1][to] = min(d[k + 1][to], d[k][from] + cost);
            }
        }
    }
    for (ll i = 0; i < n; ++i) {   
        if (d[k_step][i] == INF) {
            cout << "-1\n";
        } else {
            cout << d[k_step][i] << '\n';
        }
    }
    return 0;
}