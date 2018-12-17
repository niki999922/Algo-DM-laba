#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string>
#include <cmath>

using namespace std;

typedef long long ll;
typedef unsigned char byte;
typedef unsigned int ui;


class Vertex {
public:
    ui num, w;
    
    Vertex() {}
    Vertex(ui num, ui w) : num(num), w(w) {}
};

ui n;
vector<bool> used;
vector<int> math, rmath;
vector<vector<ui>> graph;
vector<Vertex> vertexes;


bool dfs_kun(ui v) {
    if (used[v]) return false;
    used[v] = true;
    for(size_t i = 0; i < graph[v].size(); ++i) {
        ui to = graph[v][i];
        if (math[to] == -1 || dfs_kun(math[to])) {
            math[to] = v;
            return true;
        }
    }
    return false;
}


int main() {
    std::ios::sync_with_stdio(false);
    freopen("matching.in", "r", stdin);
    freopen("matching.out", "w", stdout);
    cin.tie(nullptr);
    cin >> n;
    used.resize(n, 0);
    vertexes.resize(n);
    for(size_t i = 0; i < n; ++i) {
        cin >> vertexes[i].w;
        vertexes[i].num = i;
    }
    stable_sort(vertexes.begin(), vertexes.end(), [](const Vertex& v1, const Vertex& v2) {
        return v1.w > v2.w;
    });
    ui k, ver;
    graph.resize(n);
    for (size_t i = 0; i < n; ++i) {
        cin >> k;
        for (size_t j = 0; j < k; ++j) {
            cin >> ver;
            graph[i].push_back(ver - 1  );
        }
    }
    math.resize(n, -1);
    rmath.resize(n, -1);
    for(size_t i = 0; i < n; ++i) {
        used.assign(n, false);
        dfs_kun(vertexes[i].num);
    }
    for (size_t i = 0; i < n; i++) {
        if (math[i] != -1) rmath[math[i]] = i;
    }
    for (size_t i = 0; i < n; i++) {
        cout << rmath[i] + 1 << ' ';
    }
    return 0;
}