#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;


typedef long long ll;
typedef unsigned char byte;
typedef unsigned int ui;

const int INF = INT32_MAX / (1 << 5);
const ll SUPER_LONG = LLONG_MAX / 2;

struct Edge {
    int flow;
    int max_flow;
    Edge() : flow(0), max_flow(0) {}
    Edge(int flow, int max_flow) : flow(flow), max_flow(max_flow) {}
};

struct Vertex {
    ui x, y;
    ui speed;
    Vertex(ui x, ui y, ui speed) : x(x), y(y), speed(speed) {}
    Vertex() {}
};



int n, m, a, b, d, from, to, x, y;
char c;
vector<unordered_map<int, Edge> > edges;
vector<vector<char>> karta;
vector<bool> used, usedCut;
vector<pair<int, int>> cut;


void findCut(int v) {
    usedCut[v] = true;
    for (auto vert : edges[v]) {
        if (used[vert.first] && !usedCut[vert.first]) {
            findCut(vert.first);
        } else {
            if (!used[vert.first]) {
                cut.emplace_back(make_pair(v, vert.first));
            }
        }
    }
}


int ford_falks_dfs(int v, int flow) {
    if (v == b) {
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
        used.resize(n*m*2, false);
        int tmp = ford_falks_dfs(a, INT32_MAX - 1);
        flow += tmp;
        if (!tmp) {
            break;
        }
    }
    return flow;
}

void init() {
    edges.resize(n * m * 2, unordered_map<int, Edge>());
    karta.resize(n, vector<char>(m));
    usedCut.resize(n*m * 2, false);
}

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    init();
    for (size_t i = 0; i < n; ++i) {
        for (size_t j = 0; j < m; ++j) {
            cin >> c;
            karta[i][j] = c;
            switch (c) {
            case '-':
                d = INF;
                break;
            case 'A':
                d = INF;
                a = i * m + j;
                break;
            case 'B':
                d = INF;
                b = i * m + j;
                break;
            case '.':
                d = 1;
                break;
            case '#':
                d = 0;
                break;
            }
            from = n * m + i * m + j;
            if (i != n - 1) {
                to = (i + 1) * m + j;
                edges[from][to].max_flow = INF;
                edges[to][from].max_flow = 0;
                edges[from][to].flow = 0;
                edges[to][from].flow = 0;
            }
            if (j != m - 1) {
                to = i * m + j + 1;
                edges[from][to].max_flow = INF;
                edges[to][from].max_flow = 0;
                edges[from][to].flow = 0;
                edges[to][from].flow = 0;
            }
            if (i != 0) {
                to = (i - 1) * m + j;
                edges[from][to].max_flow = INF;
                edges[to][from].max_flow = 0;
                edges[from][to].flow = 0;
                edges[to][from].flow = 0;
            }
            if (j != 0) {
                to = i * m + j - 1;
                edges[from][to].max_flow = INF;
                edges[to][from].max_flow = 0;
                edges[from][to].flow = 0;
                edges[to][from].flow = 0;
            }
            from = i * m + j;
            to = n * m + from;
            edges[from][to].max_flow = d;
            edges[to][from].max_flow = 0;
            edges[from][to].flow = 0;
            edges[to][from].flow = 0;
        }
    }
    int res = falkinson();    
    if (res >= INF) {
        cout << "-1";
        return 0;
    }
    if (res > 0) {
        used.clear();
        used.resize(n*m * 2, false);
        ford_falks_dfs(a, 0);
        findCut(a);
    }
    cout << res << '\n';
    int x, y;
    for (size_t i = 0; i < cut.size(); ++i) {
        x = cut[i].first % m;
        y = cut[i].first / m;
        if (edges[cut[i].first][cut[i].second].max_flow == 1) {
            karta[y][x] = '+';
        }
    }
    for (size_t i = 0; i < n; ++i) {
        for (size_t j = 0; j < m; ++j) {
            cout << karta[i][j];
        }
        cout << '\n';
    }
    return 0;
}