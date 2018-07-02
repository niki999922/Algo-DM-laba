#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <queue>
#include <unordered_set>
#include <set>
#include <map>

using namespace std;

int n, m, k, tmp1, tmp2, to[50001][26], new_to[50001][26], comp[50001], new_k = 0, new_m = 0, new_n = 0, classs[50001];
char c;
bool term[50001], new_term[50001], used[50001];
pair<int, int> cur;
vector<int> autr[50001][26];
queue<pair<int, int>> q;
vector<unordered_set<int>> pre, post;
unordered_set<int> t, nt;

void do_initial() {
    for (size_t i = 0; i < 50001; ++i)
        comp[i] = -1;
}

void dfs(int v) {
    used[v] = true;
    int s;
    for (size_t i = 0; i < 26; ++i) 
        if (!used[to[v][i]]) {
            s = to[v][i];
            dfs(s);
        }
    
}

void build_auto() {
    int i0, i1;
    for (const unordered_set<int>& x : pre) {
        if (x.find(0) != x.end()) {
            for (int y : x) comp[y] = 0;
        }
        if (comp[1] == -1 && x.find(1) != x.end()) {
            ++new_n;
            for (int y : x) comp[y] = 1;
        }
    }
    for (const unordered_set<int>& x : pre) {
        if (x.size() == 0) continue;
        int i = *x.begin();
        if (!used[i]) continue;
        if (comp[i] != -1) continue;
        ++new_n;
        comp[i] = new_n;
        for (int y : x) comp[y] = new_n;
    }
    for (size_t i = 0; i < n; ++i) {
        i0 = comp[i];
        if (term[i] && !new_term[i0] && i0 != -1) {
            ++new_k;
            new_term[i0] = true;
        }
    }
    if (!(new_term[0] == 0)) --new_k;
    for (size_t i = 0; i < n; ++i) 
        for (size_t j = 0; j < 26; ++j) {
            i0 = comp[i];
            if (i0 > 0 && comp[to[i][j]] > 0 && new_to[i0][j] == 0) {
                ++new_m;
                new_to[i0][j] = comp[to[i][j]];
            }
        }
}

void find_class() {
    int qr;
    dfs(1);
    for (size_t i = 0; i < n; ++i) {
        classs[i] = (term[i]) ? 0 : 1;
        if (term[i]) t.insert(i); else nt.insert(i);
    }
    pre.push_back(nt);
    pre.push_back(t);
    post.push_back(t);
    post.push_back(nt);
    for (size_t i = 0; i < 26; ++i) {
        q.push(pair<int, int>(0, i));
        q.push(pair<int, int>(1, i));
    }
    while (!q.empty()) {
        map<int, vector<int>> inv;
        cur = q.front();
        q.pop();
        for (int q : post[cur.first])
            for (int r : autr[q][cur.second])
                inv[classs[r]].push_back(r);
        for (pair<int, vector<int>> x : inv)
            if (x.second.size() > 0) {
                if (inv[x.first].size() < pre[x.first].size()) {
                    unordered_set<int> tmp;
                    pre.push_back(tmp);
                    int j = pre.size() - 1;
                    for (int r : inv[x.first]) {
                        pre[x.first].erase(r);
                        pre[j].insert(r);
                    }
                    if (pre[j].size() > pre[x.first].size()) {
                        swap(pre[x.first], pre[j]);
                    }
                    for (int r : pre[j]) {
                        classs[r] = j;
                    }
                    post.push_back(pre[j]);
                    for (int i = 0; i < 26; ++i) {
                        qr = post.size() - 1;
                        q.push(make_pair(qr, i));
                    }
                }
            }
    }
}

void put_term(int x) {
    term[x] = true;
}

void put_to(int x, int y, char c) {
    char r = c - 'a';
    to[x][r] = y;
}

void put_autr(int x, int y, int z) {
    autr[x][y].push_back(z);
}

int main() {
    ios_base::sync_with_stdio(false);
    freopen("fastminimization.in", "r", stdin);
    freopen("fastminimization.out", "w", stdout);
    do_initial();
    cin >> n >> m >> k;
    ++n;
    for (size_t i = 0; i < k; ++i) {
        cin >> tmp1;
        put_term(tmp1);
    }
    for (size_t i = 0; i < m; ++i) {
        cin >> tmp1 >> tmp2 >> c;
        put_to(tmp1, tmp2, c);
    }
    for (size_t i = 0; i < n; ++i)
        for (size_t j = 0; j < 26; ++j)
            put_autr(to[i][j], j, i);
    find_class();
    build_auto();
    cout << new_n << ' ' << new_m << ' ' << new_k << '\n';
    for (size_t i = 1; i < n; ++i) {
        if (new_term[i]) cout << i << ' ';
    }
    cout << '\n';
    for (size_t i = 1; i < new_n; ++i)
        for (size_t j = 0; j < 26; ++j)
            if (!(new_to[i][j] == 0)) cout << i << " " << new_to[i][j] << " " << static_cast<char>('a' + j) << '\n';
    return 0;
}
