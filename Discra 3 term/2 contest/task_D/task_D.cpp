#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <cmath>

using namespace std;    

typedef unsigned char byte;

vector<vector<bool>> g(6, vector<bool>(6, 0));
string str;
size_t n, m, str_pos;

bool isK5() {
    for (size_t i = 1; i < 5; ++i)
        for (size_t j = 0; j < i; ++j) {
            if (!g[i][j]) return false;
        }
    return true;
}

bool isDoublePart(vector<byte> &parts) {
    for (size_t i = 0; i < 6; ++i) {
        if (parts[i] != 0) continue;
        for (size_t j = 0; j < 6; ++j) {
            if (parts[j] != 1) continue;
            if (!g[i][j]) return false;
        }
    }
    return true;
}

void delVertex(size_t u) {
    for (size_t k = u; k < 5; ++k) {
        for (size_t i = 0; i < 6; ++i) {
            g[k][i] = g[k + 1][i];
            g[i][k] = g[i][k + 1];
        }
    }
}

void retraction(size_t u, size_t v) {
    for (size_t i = 0; i < 6; ++i) {
        if (g[u][i]) {
            g[i][v] = g[v][i] = true;
        }
        g[u][i] = g[i][u] = false;
    }
    delVertex(u);
}

bool containsK33() {
    vector<byte> parts(6, 0);
    for (size_t i = 0; i < 4; ++i) {
        for (size_t j = i + 1; j < 5; ++j) {
            for (size_t k = j + 1; k < 6; ++k) {
                parts[i] = 1;
                parts[j] = parts[i];
                parts[k] = parts[j];
                if (isDoublePart(parts)) return true;
                parts.clear();
                parts.resize(6, 0);
            }
        }
    }
    return false;
}

bool containsK5() {
    vector<vector<bool>> copy(g);
    g.assign(copy.begin(), copy.end());
    for (size_t v = 0; v < 6; ++v) {
        delVertex(v);
        if (isK5()) return true;
        g.assign(copy.begin(), copy.end());
    }
    for (size_t u = 1; u < 6; ++u) {
        for (size_t v = 0; v < u; ++v) {
            if (g[u][v]) {
                retraction(u, v);
                if (isK5()) return true;
                g.assign(copy.begin(), copy.end());
            }
        }
    }
    g.assign(copy.begin(), copy.end());
    return false;
}

bool isPlanar() {
    if (n < 5) return true;
    if (n == 5) return !isK5();
    return !containsK5() && !containsK33();
}

int main() {
    std::ios::sync_with_stdio(false);
    freopen("planaritycheck.in", "r", stdin);
    freopen("planaritycheck.out", "w", stdout);
    cin >> m;
    char c;
    getline(std::cin, str);
    for (size_t i = 0; i < m; ++i) {
        getline(std::cin, str);
        n = static_cast<size_t>(ceil(sqrt(str.length()*2)));
        str_pos = 0;
        for (size_t i = 0; i < n; ++i) {
            for (size_t j = 0; j < i; ++j) {
                g[i][j] = g[j][i] = str.at(str_pos) == '1';
                ++str_pos;
            }
        }
        cout << ((isPlanar()) ? "YES\n" : "NO\n");
    }
}