#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <queue>

using namespace std;

int n, new_n, m, new_m, k, new_k;
bool is_term[1001], new_is_term[1001];
int to[1001][30], new_to[1001][30];
int tmp1, tmp2;
char c;
vector <int> reversed[1001][30];
bool used[1001];
bool marked[1001][1001];
queue<pair<int, int>> q;
pair <int, int> p;

void dfs(int v) {
    used[v] = true;
    for (size_t j = 0; j < 26; ++j) {
        if (!used[to[v][j]]) {
            dfs(to[v][j]);
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    freopen("minimization.in", "r", stdin);
    freopen("minimization.out", "w", stdout);
    cin >> n >> m >> k;
    for (size_t i = 0; i < k; ++i) {
        cin >> tmp1;
        is_term[tmp1] = true;
    }
    for (size_t i = 0; i < m; ++i) {
        cin >> tmp1 >> tmp2 >> c;
        to[tmp1][c - 'a'] = tmp2;
        reversed[tmp2][c - 'a'].push_back(tmp1);
    }
    dfs(1);
    for (size_t i = 0; i <= n; ++i) {
        for (size_t j = 0; j <= n; ++j) {
            if (!marked[i][j] && is_term[i] != is_term[j]) {
                marked[i][j] = marked[j][i] = true;
                q.push(pair<int, int>(i, j));
            }
        }
    }
    while (!q.empty()) {
        p = q.front();
        q.pop();
        for (size_t c = 0; c < 26; ++c) 
            for (size_t i = 0; i < reversed[p.first][c].size(); ++i) 
                for (size_t j = 0; j < reversed[p.second][c].size(); ++j) 
                    if (!marked[reversed[p.first][c][i]][reversed[p.second][c][j]]) {
                        marked[reversed[p.first][c][i]][reversed[p.second][c][j]] = marked[reversed[p.second][c][j]][reversed[p.first][c][i]] = true;
                        q.push(pair<int, int>(reversed[p.first][c][i], reversed[p.second][c][j]));
                    }
    }
    int component[1001];
    for (size_t i = 0; i <= n; ++i) component[i] = -1;
    for (size_t i = 0; i <= n; ++i) if (!marked[0][i]) component[i] = 0;
    int componentsCount = 0;
    for (size_t i = 1; i <= n; ++i) {
        if (!used[i]) continue;
        if (component[i] == -1) {
            ++componentsCount;
            component[i] = componentsCount;
            for (size_t j = i + 1; j <= n; j++) if (!marked[i][j]) component[j] = componentsCount;
        }
    }
    new_n = componentsCount;
    new_m = new_k = 0;
    for (size_t i = 1; i <= n; ++i)
        for (size_t c = 0; c < 26; ++c)
            if (to[i][c] != 0 && component[to[i][c]] != 0)
                new_to[component[i]][c] = component[to[i][c]];
    for (size_t i = 1; i <= new_n; ++i) 
        for (size_t j = 0; j < 26; ++j) 
            if (new_to[i][j]) ++new_m;   
    for (size_t i = 1; i <= n; ++i) if (is_term[i]) new_is_term[component[i]] = true;
    for (size_t i = 1; i <= new_n; ++i) if (new_is_term[i]) ++new_k;
    cout << new_n << ' ' << new_m << ' ' << new_k << '\n';
    for (size_t i = 1; i <= new_n; ++i) if (new_is_term[i]) cout << i << ' ';
    cout << '\n';
    for (size_t i = 1; i <= new_n; ++i)
        for (size_t j = 0; j < 26; ++j)
            if (new_to[i][j]) cout << i << ' ' << new_to[i][j] << ' ' << static_cast<char>('a' + j) << '\n';
    return 0;
}