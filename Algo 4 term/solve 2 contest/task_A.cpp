#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <deque>
#include <string>
#include <algorithm>
#include <map>
#include <set>

using namespace std;


typedef long long ll;
typedef unsigned long long ull;
typedef unsigned char byte;
typedef vector<ll> vll;

const long long INF = INT32_MAX / (1 << 5);
const ll MOD = 998244353;


class Edge {
public:
    ll from, to;
    ll capacity, flow, cost;
    ll rev;

    Edge(ll from, ll to, ll capacity, ll flow, ll cost, ll rev) : from(from), to(to), capacity(capacity), flow(flow), cost(cost), rev(rev) {}
    Edge() {}
};


long n, m;
ll ans = 0, v, tmp_to, current, minFlow, rev;
vector<vector<ll>> graph;
vector<Edge> edges;
vector<ll> d, path;
deque<ll> q;
vector<long> ind;


void init() {
    graph.resize(n, vector<ll>());
}

void recover() {
    d.clear();
    path.clear();
    ind.clear();
    d.resize(n, INF);
    path.resize(n, INF);
    ind.resize(n, 0);
}

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    freopen("mincost.in", "r", stdin);
    freopen("mincost.out", "w", stdout);
    cin >> n >> m;
    init();
    for (size_t i = 0; i < m; ++i) {
        ll tmp1, tmp2, tmp3, tmp4;
        cin >> tmp1 >> tmp2 >> tmp3 >> tmp4;
        --tmp1;
        --tmp2;
        edges.emplace_back(Edge(tmp1, tmp2, tmp3, 0, tmp4, 0));
        edges.emplace_back(Edge(tmp2, tmp1, 0, 0, -tmp4, 0));
        edges[edges.size() - 1].rev = edges.size() - 2;
        graph[edges[edges.size() - 1].from].push_back(edges.size() - 1);
        edges[edges.size() - 2].rev = edges.size() - 1;
        graph[edges[edges.size() - 2].from].push_back(edges.size() - 2);
    }

    while (true) {
        recover();
        d[0] = 0;
        q.push_back(0);
        while (!q.empty()) {
            v = q.front();
            q.pop_front();
            ind[v] = 1;
            for (size_t i = 0; i < graph[v].size(); ++i) {
                auto edge = edges[graph[v][i]];
                tmp_to = edge.to;
                if (d[v] < INF && d[tmp_to] > d[v] + edge.cost && edge.flow < edge.capacity) {
                    path[tmp_to] = graph[v][i];
                    d[tmp_to] = d[v] + edge.cost;
                    if (ind[tmp_to]) {
                        if (ind[tmp_to] == 1) {
                            q.push_front(tmp_to);
                        }
                    } else {
                        q.push_back(tmp_to);
                    }
                    ind[tmp_to] = 1;
                }
            }
        }
        if (d[n - 1] == INF) {
            break;
        } else {
            minFlow = INF;
            current = n - 1;
            while (path[current] != INF) {
                minFlow = min(minFlow, edges[path[current]].capacity - edges[path[current]].flow);
                current = edges[path[current]].from;
            }
            current = n - 1;
            while (path[current] != INF) {
                edges[path[current]].flow += minFlow;
                rev = edges[path[current]].rev;
                edges[rev].flow -= minFlow;
                ans += minFlow * edges[path[current]].cost;
                current = edges[path[current]].from;
            }
        }
    }
    cout << ans;
    return 0;
}