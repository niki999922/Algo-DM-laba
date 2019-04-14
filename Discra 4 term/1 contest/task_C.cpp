#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long ll;
typedef unsigned char byte;
typedef unsigned long long ui;

const long long INF = INT32_MAX / (1 << 5);
const ll SUPER_LONG = LLONG_MAX / 2;
const ll MOD = 1e9 + 7;

ll k, m, tmp;
vector<ll> ans(2000), c, t(2000), d(2000);


int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> k >> m;
    for (size_t i = 0; i < k; ++i){
        cin >> tmp;
        c.emplace_back(tmp);
    }
    t[0] = 1;
    d[0] = 1;
    for (ll w = 1; w < m + 1; ++w) {
        tmp = 0;
        for (auto it : c) {
            if (w - it >= 0) {
                tmp = (tmp + t[w - it]) % MOD;
            }
        }
        d[w] = tmp;
        for (size_t i = 0; i < w + 1; ++i) {
            if (i + w < m) {
                if (i != w) {
                    t[i + w] = (t[i + w] + 2 * tmp * d[i]) % MOD;
                } else {
                    t[i + w] = (t[i + w] + 1 * tmp * d[i]) % MOD;
                }
            }
        }
    }
    for (size_t i = 0; i < m; ++i) {
        cout << d[i + 1] << ' ';
    }
    return 0;
}