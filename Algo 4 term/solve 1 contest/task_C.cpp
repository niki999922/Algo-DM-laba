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
    int flow;
    int max_flow;
    Edge() : flow(0), max_flow(0) {}
    Edge(int flow, int max_flow) : flow(flow), max_flow(max_flow) {}
};



int n, m, s, t, tmp1, tmp2, tmp3;
tuple<int, int, int> tmp_p;
vector< unordered_map<int, Edge> > edges;
queue<pair<int, int>> q;
vector<int> d;
vector<bool> used, usedCut;
set<pair<int, int>> cut, input;

bool bfs() {
    queue<int> q_bfs;
    q_bfs.push(s);
    d.clear();
    d.resize(n, -1);
    d[s] = 0;
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
    return d[t] != -1;
}

int dinic_dfs(int v, int flow) {
    if (flow == 0)  return 0;
    if (v == t)  return flow;
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
    if (v == t) {
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
        int tmp = ford_falks_dfs(s, INF);
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
        while (int pushed = dinic_dfs(s, INF)) {
            flow += pushed;
        }
    }
    return flow;
}

void getPath(int v) {
    cout << v + 1 << ' ';
    if (v == t) {
        return;
    }
    used[v] = true;
    for (auto vert : edges[v]) {
        if (!used[vert.first] && vert.second.flow > 0) {
            --edges[v][vert.first].flow;
            getPath(vert.first);
            return;
        }
    }
}

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m >> s >> t;
    s--;
    t--;
    edges.resize(n, unordered_map<int, Edge>());
    for(size_t i = 0; i < m; i++) {
        cin >> tmp1 >> tmp2;
        if (tmp1 == tmp2) continue;
        --tmp1;
        --tmp2;
        if (!edges[tmp1].count(tmp2)) {
            edges[tmp1][tmp2] = Edge(0, 1);
            if (!edges[tmp2].count(tmp1)) {
                edges[tmp2][tmp1] = Edge(0, 0);
            }
        } else {
            edges[tmp1][tmp2].max_flow += 1;
        }
    }
    int flow = falkinson();
    if (flow > 1) {
        cout << "YES\n";
        used.resize(n, false);
        getPath(s);
        cout << '\n';
        used.clear();    
        used.resize(n, false);
        getPath(s);
        cout << '\n';
    } else {
        cout << "NO\n";
    }
    return 0;
}