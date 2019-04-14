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
const ll MOD = 998244353;

ll n, m, tmp, k1, k2;
vector<ll> P(1001), Q(1001), tmp_vec;


int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    for (size_t i = 0; i < n + 1; i++) {
        cin >> P[i];
    }
    for (size_t i = 0; i < m + 1; i++) {
        cin >> Q[i];
    }
    cout << max(n, m) << '\n';
    for (size_t i = 0; i < max(n, m) + 1; i++) {
        cout << ((P[i] + Q[i]) % MOD) << ' ';
    }
    cout << '\n';
    cout << n + m << '\n';
    for (size_t i = 0; i < n + m + 1; i++) {
        tmp = 0;
        for (size_t j = 0; j < i + 1; j++) {
            if (j < 1001) { 
                k1 = P[j]; 
            } else { 
                k1 = 0; 
            }
            if (i - j < 1001) {
                k2 = Q[i - j];
            } else {
                k2 = 0;
            }
            tmp = (tmp + k1 * k2) % MOD;
        }
        cout << tmp << ' ';
    }
    cout << '\n';
    for (size_t i = 0; i < 1000; i++) {
        tmp = 0;
        for (size_t j = 0; j < i; j++) {
            tmp = (tmp + tmp_vec[j] * Q[i-j]) % MOD;
        }
        tmp_vec.emplace_back((P[i] + MOD - tmp) % MOD);
        cout << tmp_vec[i] << ' ';
    }
    return 0;
}