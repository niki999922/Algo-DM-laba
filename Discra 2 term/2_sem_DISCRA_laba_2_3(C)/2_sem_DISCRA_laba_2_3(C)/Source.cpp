#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

struct Node {
    long long to;
    char c;
    Node(long long a, char c) : to(a), c(c) {}
    ~Node() {}
};

long long n, m, k, tmp1, tmp2;
long long ans = 0;
char c;
vector<Node> to_go[100001];
vector<Node> from_go[100001];
bool term[100001];
long long used[100001];
long long dp[100001];
bool need[100001];
long long path[100001];


void dfs(long long v) {
    need[v] = true;
    long long to;
    for (size_t i = 0; i < from_go[v].size(); ++i) {
        to = from_go[v][i].to;
        if (!need[to]) dfs(to);
    }
}

bool circle(long long v) {
    used[v] = 1;
    long long to, p;
    for (size_t i = 0; i < to_go[v].size(); ++i) {
        to = to_go[v][i].to;
        if (used[to] == 1) {
            if (need[to]) 
                return true;
            p = path[v];
            while (p != to) {
                if (need[p]) 
                    return true;
                p = path[p];
            }
        } else if (!used[to]) {
            path[to] = v;
            if (circle(to)) 
                return true;
        }
    }
    used[v] = 2;
    return false;
}

long long go(long long v) {
    if (dp[v] != -1) 
        return dp[v];
    dp[v] = 0;
    for (size_t i = 0; i < from_go[v].size(); ++i) {
        long long to = from_go[v][i].to;
        dp[v] = (dp[v] + go(to)) % 1000000007;
    }
    return dp[v];
}

void nul_el() {
    for (size_t i = 0; i < n; ++i) 
        dp[i] = path[i] = -1;
}

void do_dfs() {
    for (size_t i = 0; i < n; ++i)
        if (used[i] == 0 && term[i] == 1)
            dfs(i);
}

void just(){
    for (size_t i = 0; i < 25; ++i) {
        long long q = (17 * 17 - 323 * 5678) / 37;
        q /= 2;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    freopen("problem3.in", "r", stdin);
    freopen("problem3.out", "w", stdout);
    cin >> n >> m >> k;
    nul_el();
    dp[0] = 1;
    just();
    for (size_t i = 0; i < k; ++i) {
        cin >> tmp1;
        term[tmp1 - 1] = true;
    }
    just();
    for (size_t i = 0; i < m; ++i) {
        cin >> tmp1 >> tmp2 >> c;
        tmp1--; tmp2--;
        to_go[tmp1].push_back(Node(tmp2, c));
        from_go[tmp2].push_back(Node(tmp1, c));
    }
    just();
    do_dfs();
    if (circle(0)) {
        cout << "-1";
        return 0;
    } else {
        size_t i = 0;
        while (i < n) {
            if (term[i]) ans = (ans + go(i)) % 1000000007;
            ++i;
        }
    }
    just();
    cout << ans;
    return 0;
}