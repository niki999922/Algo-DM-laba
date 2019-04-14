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
const ll MOD = 104857601;

ll n, k, tmp, k1, k2;
vector<ll> A, C, tmp_vec;


int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> k >> n;
    A.resize(2 * k, 0);
    C.resize(2 * k + 1, 0);
    n--;
    C[0] = 1;
    for (size_t i = 0; i < k; ++i) {
        cin >> A[i];
    }
    for (size_t i = 1; i < k + 1; ++i) {
        cin >> C[i];
        C[i] = MOD - C[i];
    }
    while (n >= k) {
        for (size_t i = k; i < k * 2; ++i) {
            tmp = 0;
            for (size_t j = 1; j < k + 1; ++j) {
                tmp = (tmp + (MOD - C[j]) * A[i - j]) % MOD;
            }
            A[i] = tmp;
        }
        tmp_vec.clear();
        tmp_vec.resize(k * 2 + 1, 0);
        for (size_t i = 0; i < k * 2 + 1; ++i) {
            tmp = 0;
            if ((i & 1)) continue;
            for (size_t j = 0; j < i + 1; ++j) {
                if ((j&1)) {
                    tmp = (tmp + (MOD - C[j]) * C[i - j]) % MOD;
                } else {
                    tmp = (tmp + C[j] * C[i - j]) % MOD;
                }
            }
            tmp_vec[i/2] = tmp;
        }
        C = tmp_vec;
        for (size_t i = 0; i < k; ++i) {
            A[i] = A[(i * 2) + (n&1)];
        }
        n = n / 2;
    }
    cout << A[n];
    return 0;
}