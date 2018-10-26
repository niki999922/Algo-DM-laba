#include <iostream>
#include <vector>
#include <iomanip>
#include <math.h>
#include <set>
#include <map>
#include <string>
#include <algorithm>

using namespace std;

vector<vector<int>> g, gr;
vector<bool> used;
vector<int> order, color; 
map<string, int> name_num;
map<int, string> val_name;

void dfs(int v) {
    used[v] = true;
    for (size_t i = 0; i < g[v].size(); ++i) {
        int to = g[v][i];
        if (!used[to])
            dfs(to);
    }
    order.push_back(v);
}

void dfs2(int v, int cnt) {
    used[v] = true;
    color[v] = cnt;
    for (size_t i = 0; i < gr[v].size(); ++i) {
        int to = gr[v][i];
        if (!used[to])
            dfs2(to, cnt);
    }
}


int main() {
    std::ios::sync_with_stdio(false);
    int n, m;
    cin >> n >> m;
    string str;
    for (size_t i = 0; i < n; ++i) {
        cin >> str;
        name_num.insert(pair<string, int>(str, i));
        val_name.insert(pair<int, string>(i, str));
    }
    n *= 2;
    g.resize(n);
    gr.resize(n);
    color.resize(n);
    string str1, str2;
    for (int i = 0; i < m; ++i) {
        int num1 = 0, num2 = 0;
        cin >> str1 >> str2 >> str2;
        if (str1[0] == '-') {
            num1 = n / 2;
        }
        if (str2[0] == '-') {
            num2 = n / 2;
        }
        str1 = str1.substr(1);
        str2 = str2.substr(1);
        num1 += name_num.at(str1);
        num2 += name_num.at(str2);
        g[num1].push_back(num2);
        g[(num2 + n / 2) % n].push_back((num1 + n / 2) % n);
        gr[num2].push_back(num1);
        gr[(num1 + n / 2) % n].push_back((num2 + n / 2) % n);
    }
    used.resize(n, false);
    for (int i = 0; i < n; ++i) {
        if (!used[i]) dfs(i);
    }
    reverse(order.begin(), order.end());
    int cnt = 0;
    used.clear();
    used.resize(n, false);
    for (int i = 0; i < n; ++i) {
        int  v = order[i];
        if (!used[v]) {
            dfs2(v, cnt++);
        }
    }
    for (size_t i = 0; i < n / 2; ++i) {
        if (color[i] == color[i + n/2]) {
            cout << "-1\n";
            return 0;
        }
    }
    vector<string> s;
    for (size_t i = 0; i < n / 2; ++i) {
        if (color[i] > color[n / 2 + i]) s.push_back(val_name.at(i));
    }
    cout << s.size() << '\n';
    for (size_t i = 0; i < s.size(); ++i) {
        cout << s[i] << ' ';
    }
    return 0;
}