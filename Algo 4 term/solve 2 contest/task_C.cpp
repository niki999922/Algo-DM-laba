#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <queue>
#include <deque>
#include <string>
#include <algorithm>
#include <map>
#include <set>

using namespace std;


typedef long long ll;
typedef unsigned long long ull;
typedef unsigned long ul;
typedef unsigned char byte;
typedef vector<int> vi;
typedef vector<ll> vll;

const int INF = INT32_MAX - 1;
const ll MOD = 998244353;


int n, k, p, ans = INF, tmp1, tmp2, r_tmp;
ll n_tmp, m_tmp, cost, marked_row, mark_col, current_col, dt, res, min_cost;
vector<vi> cst, edges;
vector<vector<vi>> dp;
vll rows, cols, marked, mins, links;
vector<bool> used;

void recover1() {
    rows.clear();
    rows.resize(n_tmp);
    cols.clear();
    cols.resize(m_tmp);
    marked.clear();
    marked.resize(m_tmp, -1);
}

void recover2(int ind) {
    marked_row = ind;
    mark_col = -1;
    mins.clear();
    mins.resize(m_tmp, INF);
    used.clear();
    used.resize(m_tmp, false);
    links.clear();
    links.resize(m_tmp, -1);
}

void set1(int ind) {
    rows[ind] += dt;
    used[current_col] = true;
    cost += dt;
    mark_col = current_col;
    marked_row = marked[current_col];
}

void init1(vector<vll> &matrix) {
    n_tmp = matrix.size();
    m_tmp = matrix[0].size();
    cost = 0;
}

long long hungarian(vector<vll> &matrix) {
    if (!matrix.size()) {
        return 0;
    }
    init1(matrix);
    recover1();
    for (size_t row = 0; row < n_tmp; ++row) {
        recover2(row);
        while (marked_row != -1) {
            dt = INF;
            current_col = -1;
            for (size_t col = 0; col < m_tmp; ++col) {
                if (!used[col]) {
                    if (matrix[marked_row][col] - rows[marked_row] - cols[col] < mins[col]) {
                        mins[col] = matrix[marked_row][col] - rows[marked_row] - cols[col];
                        links[col] = mark_col;
                    }
                    if (mins[col] < dt) {
                        current_col = col;
                        dt = mins[col];
                    }
                }
            }
            for (size_t col = 0; col < m_tmp; ++col) {
                if (!used[col]) {
                    mins[col] -= dt;
                } else {
                    rows[marked[col]] += dt;
                    cols[col] -= dt;
                }
            }
            set1(row);
        }
        while (true) {
            if (links[current_col] == -1) {
                break;
            }
            marked[current_col] = marked[links[current_col]];
            current_col = links[current_col];
        }
        marked[current_col] = row;
    }
    return cost;
}

int dp_calc(const int &v, const int &col, const int &par,const int &par_col) {
        if (dp[v][col][par_col] != -1) {
        return dp[v][col][par_col];
    }
    vector<vll> costs;
    vll tmp(k);
    for (size_t i = 0; i < edges[v].size(); ++i) {
        if (edges[v][i] != par) {
            for (size_t j = 0; j < k; ++j) {
                tmp[j] = dp_calc(edges[v][i], j, v, col) + cst[edges[v][i]][j];
            }
            costs.emplace_back(tmp);
        }
    }
    res = p;
    for (size_t i = 0; i < costs.size(); ++i) {
        min_cost = INF;
        for (size_t j = 0; j < k; ++j) {
            min_cost = min(costs[i][j], min_cost);
        }
        res += min_cost;
    }
    if (par != n) {
        r_tmp = 1;
    } else {
        r_tmp = 0;
    }
    if (costs.size() + r_tmp <= k) {
        if (par_col != k) {
            for (size_t i = 0; i < costs.size(); ++i) {
                costs[i][par_col] = INF;
            }
        }
        res = min(res, hungarian(costs));
    }
    dp[v][col][par_col] = res;
    return res;
}

void init() {
    edges.resize(n, vector<int>());
    cst.resize(n, vector<int>(k));
    dp.resize(n, vector< vector<int> >(k + 1, vector<int>(k + 1, -1)));
}

void build() {
    for (size_t i = 0; i < n; ++i) {
        for (size_t j = 0; j < k; ++j) {
            cin >> cst[i][j];
        }
    }
    for (size_t i = 0; i < n - 1; ++i) {
        cin >> tmp1 >> tmp2;
        --tmp1;
        --tmp2;
        edges[tmp1].emplace_back(tmp2);
        edges[tmp2].emplace_back(tmp1);
    }
}

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> k >> p;
    init();
    build();
    for (size_t i = 0; i < k; ++i) {
        ans = std::min(ans, cst[0][i] + dp_calc(0, i, n, k));
    }
    cout << ans;
    return 0;
}