#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <stack>

using namespace std;

typedef long long ll;
typedef unsigned char byte;
typedef unsigned long long ui;
typedef vector<ll> vll;

const long long INF = INT32_MAX / (1 << 5);
const ll MOD = 998244353;

ll n, k, tmp;
vector<ll> temp1, d;
vector<vector<ll>> temp2;

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> k >> n;
    temp2.resize(k, vector<ll>(k, 0));
    d.emplace_back(1);
    for (size_t i = 0; i < k; ++i) {
        temp2[i][0] = 1;
    }
    for (size_t i = 0; i < k; ++i) {
        for (size_t j = 1; j < i + 1; ++j) {
            temp2[i][j] = (temp2[i - 1][j - 1] + temp2[i - 1][j]) % MOD;
        }
    }
    for (size_t i = 0; i < (k + 1) / 2; ++i) {
        temp1.emplace_back((i % 2) ? temp2[k - 1 - i][i] : (MOD - temp2[k - 1 - i][i]));
    }
    for (size_t i = 1; i < k - 1; ++i) {
        tmp = 0;
        for (size_t j = 0; j < i; ++j) {
            tmp = (tmp + d[j] * d[i - 1 - j]) % MOD;
        }
        d.emplace_back(tmp);
    }
    for (size_t i = k - 1; i < n; ++i) {
        tmp = 0;
        for (size_t j = 1; j < (k + 1) / 2; ++j) {
            tmp = (tmp + temp1[j] * d[i - j]) % MOD;
        }
        d.emplace_back(tmp);
    }
    for (size_t i = 0; i < n; ++i) {
        cout << d[i] << '\n';
    }
    return 0;
}