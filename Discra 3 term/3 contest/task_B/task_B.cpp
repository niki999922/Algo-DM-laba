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


class Edge {
public:
    ui num, from, to;
    ll w;
    Edge() = default;
    Edge(ui num, ui from, ui to, ll w) : num(num), from(from), to(to), w(w) {}
};

class Task {
public:
    ui first;
    ui second;
    Task() {}
    Task(ui f, ui s) : first(f), second(s) {}
};

ui n, m;
ll s, result = 0;
vector<Edge> edges;
vector<Edge> tmpEdges;
vector<Edge> answer;
vector<Task> tasks;
vector<ui> rang, parent;

int get(int x) {
    if (x == parent[x]) return x;
    return parent[x] = get(parent[x]);
}

void unionDSU(int x, int y) {
    x = get(x);
    y = get(y);
    if (x == y) {
        return;
    }
    if (rang[x] < rang[y]) {
        swap(x, y);
    }
    if (rang[x] == rang[y]) {
        ++rang[x];
    }
    parent[y] = x;
}

bool cmp(const Task &a, const Task &b) {
    return (a.second > b.second) || (a.second == b.second && a.first < b.first);
}

   
int main() {
    std::ios::sync_with_stdio(false);
    freopen("destroy.in", "r", stdin);
    freopen("destroy.out", "w", stdout);
    cin.tie(nullptr);
    cin >> n >> m >> s; 
    rang.resize(n, 0);
    parent.resize(n);
    for (size_t i = 0; i < n; ++i) {
        parent[i] = i;
    }
    for(size_t i = 0; i < m; ++i) {
        ui  from, to;
        ll w;
        cin >> from >> to >> w;
        edges.push_back({i + 1, from - 1, to - 1, w});
    }
    stable_sort(edges.begin(), edges.end(), [](const Edge& edge1, const Edge& edge2) {
        return edge1.w > edge2.w;
    });
    for(size_t i = 0; i < m; ++i) {
        if (get(edges[i].from) != get(edges[i].to)) {
            unionDSU(edges[i].from, edges[i].to);
        } else {
            tmpEdges.push_back(edges[i]);
        }
    }
    reverse(tmpEdges.begin(), tmpEdges.end());
    for(size_t i = 0; i < tmpEdges.size(); ++i) {
        if (result + tmpEdges[i].w <= s) {
            result += tmpEdges[i].w;
            answer.push_back(tmpEdges[i]);
        }
    }
    cout << answer.size() << '\n';
    stable_sort(answer.begin(), answer.end(), [](const Edge& edge1, const Edge& edge2) {
        return edge1.num < edge2.num;
    });
    for(size_t i = 0; i < answer.size(); ++i) {
        cout << answer[i].num << ' ';
    }
    return 0;
}