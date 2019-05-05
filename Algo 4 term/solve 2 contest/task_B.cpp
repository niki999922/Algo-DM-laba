#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <deque>
#include <string>
#include <algorithm>
#include <map>
#include <set>

using namespace std;


typedef long long ll;
typedef unsigned long long ull;
typedef unsigned char byte;
typedef vector<ll> vll;

const long long INF = INT32_MAX / (1 << 5);
const ll MOD = 998244353;


class Edge {
public:
    ll from, to;
    ll capacity, flow, cost;
    ll rev;

    Edge(ll from, ll to, ll capacity, ll flow, ll cost, ll rev) : from(from), to(to), capacity(capacity), flow(flow), cost(cost), rev(rev) {}
    Edge() {}
};


long n;
ll ans = 0, mark_row, mark_col, current_col, dt, current;
vector<vector<ll>> matrix;
vector<ll> row, col, marked, mins, links;
vector<bool> used;


void init() {
    matrix.resize(n, vector<ll>(n));
    row.resize(n);
    col.resize(n);
    marked.resize(n, -1);
}

void recover() {
    mins.clear();
    mins.resize(n, INF);
    used.clear();
    used.resize(n, false);
    links.clear();
    links.resize(n, -1);
}

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    freopen("assignment.in", "r", stdin);
    freopen("assignment.out", "w", stdout);
    cin >> n;
    init();
    for (size_t i = 0; i < n; ++i) {
        for (size_t j = 0; j < n; ++j) {
            cin >> matrix[i][j];
        }
    }
    for (size_t ir = 0; ir < n; ++ir) {
        recover();
        mark_row = ir;
        mark_col = -1;
        while (mark_row != -1) {
            dt = INF;
            current_col = -1;
            for (size_t jc = 0; jc < n; ++jc) {
                if (!used[jc]) {
                    current = matrix[mark_row][jc] - row[mark_row] - col[jc];
                    if (current < mins[jc]) {
                        links[jc] = mark_col;
                        mins[jc] = current;
                    }
                    if (mins[jc] < dt) {
                        current_col = jc;
                        dt = mins[jc];
                    }
                }
            }
            for (size_t jc = 0; jc < n; ++jc) {        
                if (!used[jc]) {
                    mins[jc] -= dt;
                } else {
                    row[marked[jc]] += dt;
                    col[jc] -= dt;
                }
            }
            used[current_col] = true;
            row[ir] += dt;
            ans += dt;
            mark_col = current_col;
            mark_row = marked[mark_col];
        }
        while (true) {
            if (links[current_col] == -1) {
                break;
            }
            marked[current_col] = marked[links[current_col]];
            current_col = links[current_col];
        }
        marked[current_col] = ir;
    }
    cout << ans << '\n';
    for (size_t i = 0; i < n; ++i) {
        if (marked[i] != -1) {
            cout << marked[i] + 1 << ' ' << i + 1 << '\n';
        }
    }
    return 0;
}