#include <iostream>
#include <vector>
#include <iomanip>
#include <math.h>
#include <algorithm>

using namespace std;

const long long INF = 999999999;

class Edge {
public:
    long long a, b, w;

    Edge() {}
    Edge(long long a, long long b, long long w) : a(a), b(b), w(w) {}

    bool operator<(const Edge& edges) const {
        return w < edges.w;
    }
};

vector<long long> dsu;
vector<Edge> edges;

long long get(long long v) {
    return (v == dsu[v]) ? v : (dsu[v] = get(dsu[v]));
}

void unite(long long a, long long b) {
    a = get(a);
    b = get(b);
    if (a == b) return;
    if (rand() % 2 == 1) swap(a, b);
    dsu[a] = b;
}

               
int main() {
    std::ios::sync_with_stdio(false);
    long long n, m;
    cin >> n >> m;
    edges.resize(m);
    dsu.resize(n);
    for (long long i = 0; i < n; ++i) dsu[i] = i;
    for (long long i = 0; i < m; ++i) {
        cin >> edges[i].a >> edges[i].b >> edges[i].w;
        --edges[i].a;
        --edges[i].b;
    }
    sort(edges.begin(), edges.end());
    long long ans = 0;
    for (long long i = 0; i < m; ++i)
        if (get(edges[i].a) != get(edges[i].b)) {
            unite(edges[i].a, edges[i].b);
            ans += edges[i].w;
        }
    cout << ans << '\n';
    return 0;
}



