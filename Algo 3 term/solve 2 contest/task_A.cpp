#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <fstream>
#include <vector>
#include <string>
using namespace std;

int n, t;
vector<vector<int>> graph;

int main() {
    std::ios::sync_with_stdio(false);
    cin >> n;
    graph.resize(n, vector<int>(n));
    for(size_t i = 0; i < n; ++i) {
        for(size_t j = 0; j < n; ++j) {
            cin >> graph[i][j];
        }
    }
    for (size_t k = 0; k < n; ++k)
        for (size_t i = 0; i < n; ++i)
            for (size_t j = 0; j < n; ++j)
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
    for (size_t i = 0; i < n; ++i) {
        for (size_t j = 0; j < n; ++j) {
            cout << graph[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}