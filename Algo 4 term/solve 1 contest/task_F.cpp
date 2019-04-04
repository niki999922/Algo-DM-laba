#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string>
#include <cmath>
#include <iomanip>


using namespace std;

typedef long long ll;
typedef unsigned char byte;
typedef unsigned int ui;

struct Edge {
    ui from, to;
    double time;
    Edge() {}
    Edge(ui from, ui to, double time) : from(from), to(to), time(time) {}
};

struct Vertex {
    ui x, y;
    ui speed;
    Vertex(ui x, ui y, ui speed) : x(x), y(y), speed(speed) {}
    Vertex() {}
};


ui n, tmp1, tmp2, tmp3;
vector<bool> used;
vector<ui> math, rmath;
vector<vector<ui>> graph;
vector<Vertex> objects;
vector<Edge> edges;


bool dfs_kun(ui v) {
    if (used[v]) return false;
    used[v] = true;
    for (ui i = 0; i < graph[v].size(); ++i) {
        ui to = graph[v][i];
        if (math[to] == -1 || dfs_kun(math[to])) {
            math[to] = v;
            return true;
        }
    }
    return false;
}

double countTime(ui x0, ui y0, ui x1, ui y1, ui speed) {
    return sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0)) / speed;
}

int main() {
    std::ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n;
    for(size_t i = 0; i < n; ++i) {
        cin >> tmp1 >> tmp2 >> tmp3;
        objects.emplace_back(Vertex(tmp1, tmp2, tmp3));
    }
    for (size_t i = 0; i < n; ++i) {
        cin >> tmp1 >> tmp2;
        for (size_t j = 0; j < n; j++) {
            edges.emplace_back(Edge(j, i, countTime(objects[j].x, objects[j].y, tmp1, tmp2, objects[j].speed)));
        }
    }
    sort(edges.begin(), edges.end(),[](const Edge& e1, const Edge& e2) {
        return e1.time < e2.time;
    });
    used.resize(n, 0);
    math.resize(n, -1);
    graph.resize(n);
    ui matched = 0;
    ui edgesCount = n - 1;
    for (ui i = 0; i < n - 1; ++i) {
            graph[edges[i].from].emplace_back(edges[i].to);
    }
    while (matched < n) {
        graph[edges[edgesCount].from].emplace_back(edges[edgesCount].to);
        ++edgesCount;
        matched = 0;
        math.assign(n, -1);
        for (ui i = 0; i < n; ++i) {
            used.assign(n, false);
            dfs_kun(i);
        }
        for (ui i = 0; i < n; i++) {
            if (math[i] != -1) {
                ++matched;
            }
        }
    }
    cout << fixed << setprecision(4) << edges[edgesCount - 1].time << '\n';
    return 0;
}