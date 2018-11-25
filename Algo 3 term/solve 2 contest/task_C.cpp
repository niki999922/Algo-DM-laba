#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


struct edge {
    long long a, b, cost;
};

long long n, m = 0;
vector<edge> e;
const long long INF = 100000000;
const long long inf = 10000;


int main() {
    std::ios::sync_with_stdio(false);
    cin >> n;
    for (long long i = 0; i < n; i++) {
        for (long long j = 0, w; j < n; j++) {
            cin >> w;
            if (w < inf) {
                edge t;
                t.a = i;
                t.b = j;
                t.cost = w;
                e.push_back(t);
                m++;
            }
        }
    }
    vector<long long> d(n), p(n, -1);
    long long x;
    for (long long i = 0; i < n; i++) {
        x = -1;
        for (long long j = 0; j < m; j++) {
            if (d[e[j].b] > d[e[j].a] + e[j].cost) {
                d[e[j].b] = max(-INF, d[e[j].a] + e[j].cost);
                p[e[j].b] = e[j].a;
                x = e[j].b;
            }
        }
    }
    if (x == -1) {
        cout << "NO";
    } else {
        long long y = x;
        for (long long i = 0; i < n; i++) {
            y = p[y];
        }
        vector<long long> path;
        for (long long cur = y; ; cur = p[cur]) {
            path.push_back(cur);
            if (cur == y && path.size() > 1) {
                break;
            }
        }
        reverse(path.begin(), path.end());
        cout << "YES\n";
        cout << (path.size() - 1) << '\n';
        for (size_t i = 1; i < path.size(); i++) {
            cout << (path[i] + 1) << ' ';
        }
    }
    return 0;
}