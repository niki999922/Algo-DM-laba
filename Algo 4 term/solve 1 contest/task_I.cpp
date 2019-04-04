#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <map>

using namespace std;


typedef long long ll;
typedef unsigned char byte;
typedef unsigned int ui;

const int INF = INT32_MAX / 3;
const ll SUPER_LONG = LLONG_MAX / 2;

int n, tmp;
char c;
vector<map<int, int>> g, ost;
vector<vector<char> > table;
vector<bool> used;

int dfs(int v, int flow) {
    if (v == n + 1) {
        return flow;
    }
    used[v] = true;
    for(auto val : ost[v]) {
        if (!used[val.first] && g[v][val.first] > val.second) {
            int add = dfs(val.first, min(flow, g[v][val.first] - val.second));
            if (add > 0) {
                ost[v][val.first] += add;
                ost[val.first][v] -= add;
                return add;
            }
        }
    }
    return 0;
}

void init() {
    g.resize(n + 2, map<int, int>());
    used.resize(n + 2, false);
    ost.resize(n + 2, map<int, int>());
    table.resize(n, vector<char>(n));
}

void getFlow() {
    int flow = 0;
    while (true) {
        used.clear();
        used.resize(n + 2, false);
        int res = dfs(0, INF);
        if (!res) {
            break;
        }
        flow += res;
    }
}

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n;
    init();
    for (size_t i = 0; i < n; ++i) {
        ost[0][i + 1] = ost[i + 1][0] = ost[i + 1][n + 1] = ost[n + 1][i + 1] = 0;
        g[0][i + 1] = g[i + 1][0] = g[i + 1][n + 1] = g[n + 1][i + 1] = 0;
        for (size_t j = 0; j < n; ++j) {
            cin >> table[i][j];
            switch (table[i][j]) {
            case '.':
                if (j > i) {
                    g[0][i + 1] += 3;
                    g[i + 1][j + 1] = 3;
                    g[j + 1][i + 1] = 0;
                    ost[i + 1][j + 1] = ost[j + 1][i + 1] = 0;
                }
                break;
            case 'W':
                --g[i + 1][n + 1];
            case 'w':
                --g[i + 1][n + 1];
            case 'l':
                --g[i + 1][n + 1];
            }
        }
    }
    int k;
    for (size_t i = 0; i < n; ++i) {
        cin >> tmp;
        g[i + 1][n + 1] += tmp;
    }
    getFlow();
    for (size_t i = 0; i < n; ++i) {
        for (size_t j = 0; j < n; ++j) {
            if (table[i][j] == '.') {
                if (ost[i + 1][j + 1] == 0) {
                    table[i][j] = 'W';
                    table[j][i] = 'L';
                } else if (ost[i + 1][j + 1] == 1) {
                    table[i][j] = 'w';
                    table[j][i] = 'l';
                } else if(ost[i + 1][j + 1] == 2) {
                    table[i][j] = 'l';
                    table[j][i] = 'w';
                } else if (ost[i + 1][j + 1] == 3) {
                    table[i][j] = 'L';
                    table[j][i] = 'W';
                }
            }
            cout << table[i][j];
        }
        cout << '\n';
    }
    return 0;
}