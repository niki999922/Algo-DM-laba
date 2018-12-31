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


vector<int> prefix_function(string s) {
    int n = (int)s.length();
    vector<int> pi(n);
    for (int i = 1; i < n; ++i) {
        int j = pi[i - 1];
        while (j > 0 && s[i] != s[j])
            j = pi[j - 1];
        if (s[i] == s[j])  ++j;
        pi[i] = j;
    }
    return pi;
}

int main() {
    std::ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> str;
    vector<int> res = prefix_function(str);
    for (auto it : res) {
        cout << it << ' ';
    }
    return 0;
}