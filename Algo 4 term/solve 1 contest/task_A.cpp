#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <vector>
#include <queue>
#include <map>

#define ll long long

using namespace std;

const int INF = INT32_MAX / 3;

struct Edge {
    int flow;
    int max_flow;
    bool live;
    Edge(int m_f = 0) : flow(0), max_flow(m_f), live(0) {}
};



int n, m, tmp1, tmp2, tmp3;
tuple<int, int, int> tmp_p;
vector< vector<Edge> > edges;
queue<tuple<int, int, int>> q;
int f[100][100];
int f_ans[100][100];
vector<int> d;


bool bfs() {
    queue<int> q_bfs;
    q_bfs.push(0);
    d.clear();
    d.resize(n, -1);
    d[0] = 0;
    while (!q_bfs.empty()) {
        int v = q_bfs.front();
        q_bfs.pop();
        for(size_t i = 0; i < n; ++i) {
            if (!edges[v][i].live) continue;
            if (d[i] == -1 && edges[v][i].flow < edges[v][i].max_flow) {
                q_bfs.push(i);
                d[i] = d[v] + 1;
            }
        }
    }
    return d[n-1] != -1;
}

int dfs(int v, int flow) {
    if (flow == 0)  return 0;
    if (v == n - 1)  return flow;
    for(size_t i = 0; i < n; i++) {
        if (!edges[v][i].live || d[i] != d[v] + 1)  continue;
        int pushed = dfs(i, min(flow, edges[v][i].max_flow - edges[v][i].flow));
        if (pushed) {
            edges[v][i].flow += pushed;
            edges[i][v].flow -= pushed;
            return pushed;
        }
    }
    return 0;
}

int dinic() {
    int flow = 0;
    while(true) {
        if (!bfs())  break;
        while (int pushed = dfs(0, INF)) {
            flow += pushed;
        }
    }
    return flow;
}

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    edges.resize(n,vector<Edge>(n));
    for(size_t i = 0; i < m; i++) {
        cin >> tmp1 >> tmp2 >> tmp3;
        --tmp1;
        --tmp2;
        q.push(make_tuple(tmp1, tmp2, tmp3));
        if (tmp1 > tmp2) swap(tmp1, tmp2);
        f[tmp1][tmp2] += tmp3;
    }
    for (size_t i = 0; i < n; i++) {
        for (size_t j = i; j < n; j++) {
            if (f[i][j] != 0) {
                edges[i][j].max_flow = f[i][j];
                edges[j][i].max_flow = f[i][j];
                edges[i][j].live = true;
                edges[j][i].live = true;
            }
        }
    }
    cout << dinic() << '\n';
    while (!q.empty()) {
        tmp_p = q.front();
        q.pop();
        int from = get<0>(tmp_p);
        int to = get<1>(tmp_p);
        int fl = get<2>(tmp_p);
        if (fl >= abs(edges[from][to].flow)) {
            cout << edges[from][to].flow << '\n';
            edges[from][to].flow = 0;
            edges[to][from].flow = 0;
        } else {
            if (edges[from][to].flow > 0) {
                edges[from][to].flow -= fl;
                edges[to][from].flow += fl;
                cout << fl << '\n';
            } else {
                edges[from][to].flow += fl;
                edges[to][from].flow -= fl;
                cout << -fl << '\n';
            }
        }
    }
    return 0;
}