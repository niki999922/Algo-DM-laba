#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <string>

using namespace std;

int n_1, n_2, m_1, m_2, k_1, k_2;
int to_1[200000][30], to_2[200000][30];
bool is_term_1[200000], is_term_2[200000];
bool used_1[200000], used_2[200000];
string ans = "YES";

void dfs(int v1, int v2) {
    used_1[v1] = true;
    used_2[v2] = true;
    if (is_term_1[v1] != is_term_2[v2]) {
        ans = "NO";
        return;
    }
    for (int i = 0; i < 26; ++i) {
        if (to_1[v1][i] != 0 && to_2[v2][i] != 0) {
            if (!used_1[to_1[v1][i]] && !used_2[to_2[v2][i]]) {
                dfs(to_1[v1][i], to_2[v2][i]);
            } else if (!used_1[to_1[v1][i]] || !used_2[to_2[v2][i]]) {
                ans = "NO";
                return;
            }
        } else {
            if (to_1[v1][i] != 0 || to_2[v2][i] != 0) {
                ans = "NO";
                return;
            }
        }   
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    freopen("isomorphism.in", "r", stdin);
    freopen("isomorphism.out", "w", stdout);
    int a, tmp1, tmp2; 
    char c;
    cin >> n_1 >> m_1 >> k_1;
    for (int i = 0; i < k_1; ++i) {    
        cin >> tmp1;
        is_term_1[tmp1] = true;
    }
    for (int i = 0; i < m_1; ++i) {
        cin >> tmp1 >> tmp2 >> c;
        to_1[tmp1][c - 'a'] = tmp2;
    }
    cin >> n_2 >> m_2 >> k_2;
    if (n_1 != n_2 || m_1 != m_2 || k_1 != k_2) {
        cout << "NO";
        return 0;
    }
    for (int i = 0; i < k_2; i++) {
        int a;
        cin >> tmp1;
        is_term_2[tmp1] = true;
    }
    for (int i = 0; i < m_2; i++) {
        cin >> tmp1 >> tmp2 >> c;
        to_2[tmp1][c - 'a'] = tmp2;
    }
    dfs(1, 1);
    cout << ans;
    return 0;
}