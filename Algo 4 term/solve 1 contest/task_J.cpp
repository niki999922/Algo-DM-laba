#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <queue>

using namespace std;

const long long SUPER_LONG = LLONG_MAX / 2;

struct Object {
    int x1, y1, x2, y2;

    Object(int & x1, int & y1, int & x2, int & y2) :
        x1(x1), y1(y1), x2(x2), y2(y2) {
    }

    int d(Object & other) {
        return max(0,max(x1 - other.x2,max(y1 - other.y2,max(other.y1 - y2,other.x1 - x2))));
    }
};

unsigned int n, w;
int x1, x2, y1, y2, cur;
vector<Object> things;
vector<vector<long long int>> graph;
vector<long long int> d(n + 2, SUPER_LONG);
priority_queue< pair<long long int, long long int> > q;


void init() {
    graph.resize(n + 2, vector<long long int>(n + 2));
    graph[0][n + 1] = graph[n + 1][0] = w;
    d.resize(n + 2, SUPER_LONG);
    d[0] = 0;
    q.push(make_pair(0, 0));
}

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> w;
    init();
    for (size_t i = 0; i < n; ++i) {
        cin >> x1 >> y1 >> x2 >> y2;
        things.emplace_back(Object(x1, y1, x2, y2));
        graph[i + 1][0] = graph[0][i + 1] = w - y2;
        graph[i + 1][n + 1] = graph[n + 1][i + 1] = y1;
        for (size_t j = 0; j < i; ++j) {
            graph[i + 1][j + 1] = graph[j + 1][i + 1] = things[i].d(things[j]);
        }
    }
    while (!q.empty()) {
        cur = q.top().second;
        q.pop();
        while (!q.empty() && q.top().first != -d[q.top().second]) {
            q.pop();
        }
        for (size_t i = 0; i < n + 2; ++i) {
            if (i == cur) continue;
            if (d[i] > graph[cur][i] + d[cur]) {
                d[i] = graph[cur][i] + d[cur];
                q.push(make_pair(-d[i], i));
            }
        }
    }
    cout << d[n + 1];
    return 0;
}