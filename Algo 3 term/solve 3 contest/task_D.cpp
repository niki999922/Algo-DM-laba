#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string>
#include <set>
#include <cmath>
#include <string>
#include <cstring>
#include <queue>

using namespace std;

typedef long long ll;
typedef unsigned char byte;
typedef unsigned int ui;
typedef unsigned __int64 ui64;


vector<int> z_function(string s) {
    int n = (int)s.length();
    vector<int> z(n);
    for (int i = 1, l = 0, r = 0; i < n; ++i) {
        if (i <= r)
            z[i] = min(r - i + 1, z[i - l]);
        while (i + z[i] < n && s[z[i]] == s[i + z[i]])
            ++z[i];
        if (i + z[i] - 1 > r)
            l = i, r = i + z[i] - 1;
    }
    return z;
}


int main() {
    std::ios::sync_with_stdio(false);
    cin.tie(nullptr);
    string str, str1, str2; 
    cin >> str1;
    cin >> str2;
    str = str1 + '#' + str2;
    vector<int> ans;
    vector<int> res = z_function(str);
    for (size_t i = 0; i < str2.size(); i++) {
        if (res[str1.size() + 1 + i] == str1.size()) {
            ans.push_back(i + 1);
        }
    }
    cout << ans.size() << '\n';
    for (auto it : ans) {
        cout << it << ' ';
    }
    return 0;
}