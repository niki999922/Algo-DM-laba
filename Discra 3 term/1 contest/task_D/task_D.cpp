#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <fstream>
#include <vector>
#include <string>
using namespace std;

int n, t;
vector<int> ans;
vector<vector<int>> graph;
string s;

void bin_search(int v) {
    int l = 0, r = ans.size() - 1, m;
    while (l <= r) {
        m = (l + r) / 2;
        if (graph[ans[m]][v]) l = m + 1; else r = m - 1;
    }
    ans.insert(ans.begin() + m + ((graph[ans[m]][v]) ? 1 : 0), v);
}


int main() {
    std::ios::sync_with_stdio(false);
    freopen("guyaury.in", "r", stdin);
    freopen("guyaury.out", "w", stdout);
    string s;
    cin >> n;
    graph.resize(n, vector<int>(n));
    for(size_t i = 1; i < n; ++i) {
        cin >> s;
        for (size_t j = 0; j < i; ++j) {
            t = static_cast<int>(s[j] - '0');
            if (t == 1) {
                graph[i][j] = 1;
            } else {
                graph[j][i] = 1;
            }
        }
    }
    ans.push_back(0);
    for(size_t i = 1; i < n; ++i) 
        bin_search(i);
    int last = 2;
    int k = 2;
    while(k < n) {
        if (graph[ans[k]][ans[0]]) last = k;
        ++k;
    }
    ++last;
    while (last < n ) {
        int to = -1;
        int counter = 0;
        while (to == -1) {
            int local_last = last + counter;
            for (size_t i = 0; i < last; ++i) {
                if (graph[ans[local_last]][ans[i]]) {
                    to = i;
                    break;
                }
            }
            ++counter;
        }
        if (counter == 1) {
            ans.insert(ans.begin() + to, ans[last]);
            ans.erase(ans.begin() + last + 1);
            ++last;
        } else {
            ans.insert(ans.begin() + to, ans.begin() + last, ans.begin() + last + counter);
            ans.erase(ans.begin() + last + counter, ans.begin() + last + counter + counter);
            last += counter;
        }
    }
    for(size_t i = 0; i < n; ++i) 
        cout << ans[i] + 1 << ' ';
    return 0;
}