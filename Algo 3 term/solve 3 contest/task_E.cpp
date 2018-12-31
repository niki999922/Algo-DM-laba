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


vector<int> z_function(string str) {
    int n = (int)str.length();
    vector<int> z(n);
    for (int i = 1, l = 0, r = 0; i < n; ++i) {
        if (i <= r)
            z[i] = min(r - i + 1, z[i - l]);
        while (i + z[i] < n && str[z[i]] == str[i + z[i]])
            ++z[i];
        if (i + z[i] - 1 > r)
            l = i, r = i + z[i] - 1;
    }
    return z;
}


int main() {
    std::ios::sync_with_stdio(false);
    cin.tie(nullptr);
    vector<ui> z;
    ui l = 0, r = 0;
    string str;
    cin >> str;
    z.resize(str.length());
    str += '$';
    for (size_t i = 1; i < str.length() - 1; ++i) {
        if (i < r) {
            z[i] = min(z[i - l], r - i);
        }
        while (str[z[i]] == str[i + z[i]]) {
            ++z[i];
        }
        if (i + z[i] > r) {
            l = i;
            r = i + z[i];
        }
        if (z[i] + i + 1 == str.length()) {
            cout << i;
            break;
        }
        if (i >= (str.length() - 1) / 2) {
            cout << str.length() - 1;
            break;
        }
    }
    return 0;
}