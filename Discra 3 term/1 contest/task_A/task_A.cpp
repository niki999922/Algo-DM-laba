#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <fstream>
#include <vector>
#include <string>
using namespace std;

int n;
vector<vector<int>> graph;
vector<int> queue(16000000);
size_t left_q, right_q;

void findHamiltonCycle() {
    int cur = 0; //for fast exit
    left_q = 0;  //left_q inclusive
    right_q = n; //right_q non-inclusive
    for (size_t i = 0; i < n; ++i) {
        queue[i] = i;
    }
    for (size_t i = 0; i < n * (n - 1); ++i) {
        if (!graph[queue[left_q]][queue[left_q + 1]]) {
            cur = 0;
            size_t to = left_q + 2;
            size_t j = 0;
            while (!graph[queue[left_q]][queue[to]] || !graph[queue[left_q + 1]][queue[to + 1]]) {
                ++to;
            }
            while (left_q + 1 + j < to - j) {
                queue[left_q + 1 + j] = queue[left_q + 1 + j] ^ queue[to - j];
                queue[to - j]       = queue[left_q + 1 + j] ^ queue[to - j];
                queue[left_q + 1 + j] = queue[left_q + 1 + j] ^ queue[to - j];
                ++j;
            }
        } else {
            ++cur;
            if (cur > n) {
                break;
            }
        }
        queue[right_q] = queue[left_q];
        ++right_q;
        ++left_q;
    }
}

int main() {
    std::ios::sync_with_stdio(false);
    freopen("fullham.in", "r", stdin);
    freopen("fullham.out", "w", stdout);
    string s;
    cin >> n;
    graph.resize(n, vector<int>(n));
    for (size_t i = 1; i < n; ++i) {
        cin >> s;
        for (size_t j = 0; j < i; ++j) {
            graph[i][j] = static_cast<int>(s[j] - '0');
            graph[j][i] = static_cast<int>(s[j] - '0');
        }
    }
    findHamiltonCycle();
    for (size_t i = 0; i < n; ++i) {
        cout << queue[left_q + i] + 1 << ' ';
    }
    return 0;
}