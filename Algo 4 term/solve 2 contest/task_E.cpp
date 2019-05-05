#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <queue>
#include <deque>
#include <string>
#include <algorithm>
#include <map>
#include <set>

using namespace std;


typedef long long ll;
typedef unsigned long long ull;
typedef unsigned long ul;
typedef unsigned char byte;
typedef vector<ll> vll;

const long long INF = INT64_MAX - 1;
const ll MOD = 998244353;


class Edge {
public:
    ull from, to, rev;
    ll capacity, flow, cost;

    Edge(ull from, ull to, ll capacity, ll flow, ll cost, ull rev) : from(from), to(to), capacity(capacity), flow(flow), cost(cost), rev(rev) {}
    Edge() {}
};

ul n, m;
bool flag = true;
ll ans = 0, from, to, cost, capacity, current, flow, minFlow;
ll tmp, tmp1, tmp2, tmp3;
vector<Edge> edges;
vector<vector<ull>> graph;

vector<ll> d;
vector<ull> path;
priority_queue<pair<ll, ull>> q;

vector<ll> fis(n * 2 + 2, INF);


void init() {
    graph.resize(n * 2 + 2, vector<ull>());
    fis.resize(n * 2 + 2, INF);
}

void build() {
    for (size_t i = 1; i < n * 2 + 1; i += 2) {
        cin >> tmp1;
        edges.emplace_back(i, i + 1, n, 0, tmp1, 0);
        edges.emplace_back(i + 1, i, 0, 0, -tmp1, 0);
        edges[edges.size() - 1].rev = edges.size() - 2;
        edges[edges.size() - 2].rev = edges.size() - 1;
        graph[edges[edges.size() - 1].from].emplace_back(edges.size() - 1);
        graph[edges[edges.size() - 2].from].emplace_back(edges.size() - 2);
        edges.emplace_back(0, i, 1, 0, 0, 0);
        edges.emplace_back(i, 0, 0, 0, 0, 0);
        edges[edges.size() - 1].rev = edges.size() - 2;
        edges[edges.size() - 2].rev = edges.size() - 1;
        graph[edges[edges.size() - 1].from].emplace_back(edges.size() - 1);
        graph[edges[edges.size() - 2].from].emplace_back(edges.size() - 2);
        edges.emplace_back(i + 1, 2 * n + 1, 1, 0, 0, 0);
        edges.emplace_back(2 * n + 1, i + 1, 0, 0, 0, 0);
        edges[edges.size() - 1].rev = edges.size() - 2;
        edges[edges.size() - 2].rev = edges.size() - 1;
        graph[edges[edges.size() - 1].from].emplace_back(edges.size() - 1);
        graph[edges[edges.size() - 2].from].emplace_back(edges.size() - 2);
        edges.emplace_back(i + 1, i, n, 0, 0, 0);
        edges.emplace_back(i, i + 1, 0, 0, 0, 0);
        edges[edges.size() - 1].rev = edges.size() - 2;
        edges[edges.size() - 2].rev = edges.size() - 1;
        graph[edges[edges.size() - 1].from].emplace_back(edges.size() - 1);
        graph[edges[edges.size() - 2].from].emplace_back(edges.size() - 2);
    }
    for (size_t i = 0; i < m; ++i) {
        cin >> tmp1 >> tmp2 >> tmp3;
        tmp1 = tmp1 * 2 - 1;
        tmp2 = tmp2 * 2;
        edges.emplace_back(tmp1, tmp2, n, 0, tmp3, 0);
        edges.emplace_back(tmp2, tmp1, 0, 0, -tmp3, 0);
        edges[edges.size() - 1].rev = edges.size() - 2;
        edges[edges.size() - 2].rev = edges.size() - 1;
        graph[edges[edges.size() - 1].from].push_back(edges.size() - 1);
        graph[edges[edges.size() - 2].from].push_back(edges.size() - 2);
    }
}


void recover() {
    d.clear();
    d.resize(n * 2 + 2, INF);
    path.clear();
    path.resize(n * 2 + 2, INF);
}


int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    init();
    build();
    fis[0] = 0;
    while (flag) {
        flag = false;
        for (size_t i = 0; i < edges.size(); ++i) {
            from = edges[i].from;
            to = edges[i].to;
            cost = edges[i].cost;
            capacity = edges[i].capacity;
            if (fis[from] < INF && edges[i].flow < capacity && fis[to] > fis[from] + cost) {
                fis[to] = fis[from] + cost;
                flag = true;
            }
        }
    }
    while (true) {
        recover();
        d[0] = 0;
        q.push(make_pair(0, 0));
        while (!q.empty()) {
            current = q.top().second;
            q.pop();
            while (!q.empty() && q.top().first != -d[q.top().second]) {
                q.pop();
            }
            for (size_t i = 0; i < graph[current].size(); ++i) {
                auto edge = edges[graph[current][i]];
                to = edge.to;
                cost = edge.cost + fis[current] - fis[to];
                flow = edge.flow;
                capacity = edge.capacity;
                if (d[current] < INF && d[to] > cost + d[current] && flow < capacity) {
                    d[to] = cost + d[current];
                    path[to] = graph[current][i];
                    q.push(make_pair(-d[to], to));
                }
            }
        }
        if (d[n * 2 + 1] != INF) {
            current = n * 2 + 1;
            minFlow = INF;
            while (path[current] != INF) {
                minFlow = min(minFlow, edges[path[current]].capacity - edges[path[current]].flow);
                current = edges[path[current]].from;
            }
            current = n * 2 + 1;
            while (path[current] != INF) {
                edges[path[current]].flow += minFlow;
                edges[edges[path[current]].rev].flow -= minFlow;
                ans += minFlow * edges[path[current]].cost;
                current = edges[path[current]].from;
            }
            fis.assign(d.begin(), d.end());
        } else {        
            break;
        }
    }
    cout << ans;
    return 0;
}