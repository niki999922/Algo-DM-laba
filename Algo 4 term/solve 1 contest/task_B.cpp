#include <iostream>
#include <vector>
#include <queue>
#include <map>
#include <unordered_map>
#include <set>

#define ll long long

using namespace std;

const int INF = INT32_MAX / 3;

struct Edge {
    int vertex;
    int flow;
    int max_flow;
    bool live;
    Edge(int m_f = 0) : vertex(0), flow(0), max_flow(m_f), live(0) {}
    Edge(int vertex, int flow, int max_flow, bool live) : vertex(vertex), flow(flow), max_flow(max_flow), live(live) {}
    Edge(int flow, int max_flow, bool live) : vertex(-1), flow(flow), max_flow(max_flow), live(live) {}
};



int n, m, tmp1, tmp2, tmp3;
tuple<int, int, int> tmp_p;
vector< unordered_map<int, Edge> > edges;
queue<pair<int, int>> q;
vector<int> d;
vector<bool> used, usedCut;
set<pair<int, int>> cut, input;

bool bfs() {
    queue<int> q_bfs;
    q_bfs.push(0);
    d.clear();
    d.resize(n, -1);
    d[0] = 0;
    while (!q_bfs.empty()) {
        int v = q_bfs.front();
        q_bfs.pop();
        for(auto vert : edges[v]) {
            if (d[vert.first] == -1 && vert.second.flow < vert.second.max_flow) {
                q_bfs.push(vert.first);
                d[vert.first] = d[v] + 1;
            }
        }
    }
    return d[n-1] != -1;
}

int dinic_dfs(int v, int flow) {
    if (flow == 0)  return 0;
    if (v == n - 1)  return flow;
    for (auto vert : edges[v]) {
        if (d[vert.first] != d[v] + 1)  continue;
        int pushed = dinic_dfs(vert.first, min(flow, vert.second.max_flow - vert.second.flow));
        if (pushed) {
            edges[v][vert.first].flow += pushed;
            edges[vert.first][v].flow -= pushed;
            return pushed;
        }
    }
    return 0;
}

void just_dfs(unsigned int v, int flow) {
    if (v == n - 1) {
        return;
    }
    used[v] = true;
    for (auto vert : edges[v]) {
        if (!used[vert.first] && vert.second.max_flow > vert.second.flow) {
            just_dfs(vert.first, 0);
        }
    }
}

void findCut(int v) {
    usedCut[v] = true;
    for (auto vert : edges[v]) {
        if (used[vert.first] && !usedCut[vert.first]) {
            findCut(vert.first);
        } else {
            if (!used[vert.first]) {
                cut.insert(make_pair(v, vert.first));
                cut.insert(make_pair(vert.first, v));
            }
        }
    }
}

int ford_falks_dfs(int v, int flow) {
    if (v == n - 1) {
        return flow;
    }
    used[v] = true;
    for (auto vert : edges[v]) {
        if (!used[vert.first] && vert.second.max_flow > vert.second.flow) {
            int pushed = ford_falks_dfs(vert.first, min(flow, vert.second.max_flow - vert.second.flow));
            if (pushed > 0) {
                edges[v][vert.first].flow += pushed;
                edges[vert.first][v].flow -= pushed;
                return pushed;
            }
        }
    }
    return 0;
}

int falkinson() {
    int flow = 0;
    while (true) {
        used.clear();
        used.resize(n, false);
        int tmp = ford_falks_dfs(0, INF);
        flow += tmp;
        if (!tmp) {
            break;
        }
    }
    return flow;
}

int dinic() {
    int flow = 0;
    while(true) {
        if (!bfs())  break;
        while (int pushed = dinic_dfs(0, INF)) {
            flow += pushed;
        }
    }
    return flow;
}

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    edges.resize(n, unordered_map<int, Edge>());
    for(size_t i = 0; i < m; i++) {
       cin >> tmp1 >> tmp2 >> tmp3;
        --tmp1;
        --tmp2;
        q.push(make_pair(tmp1, tmp2));
        edges[tmp1][tmp2] = Edge(0, tmp3, true);
        edges[tmp2][tmp1] = Edge(0, tmp3, true);
    }
    int flow = falkinson();
    used.clear();
    used.resize(n, false);
    usedCut.resize(n, false);
    just_dfs(0, 0);
    findCut(0);
    cout << cut.size()/2 << ' ' << flow << '\n';
    int t = 0;
    while (!q.empty()) {
        t++;
        auto tmp = q.front();
        q.pop();
        if (cut.count(tmp)) {
            cout << t << ' ';
        }
    }
    return 0;
}