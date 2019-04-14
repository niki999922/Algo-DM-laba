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

ll n, m, tmp;
vector<ll> P;

ll gcd(ll a, ll b, ll &x, ll &y) {
    if (a == 0) {
        x = 0;
        y = 1;
        return b;
    }
    ll x1, y1;
    ll d = gcd(b%a, a, x1, y1);
    x = y1 - (b / a) * x1;
    y = x1;
    return d;
}

ll getReverse(ll a) {
    ll x, y;
    ll g = gcd(a, MOD, x, y);
    if (g != 1) {
        return 0;
    }
    else {
        return x;
    }
}

vector<ll> AMultiplyP(vector<ll> &A) {
    vector<ll> vec_step(A.size() + n);
    for (size_t i = 0; i < A.size(); ++i) {
        for (size_t j = 0; j < n + 1; ++j) {
            vec_step[i + j] = (vec_step[i + j] + (A[i] * P[j]) % MOD) % MOD;
        }
    }
    return vec_step;
}

void countSqrt() {
    vector<ll> temp(10001, 0), A_tmp(P);
    temp[0] = 1;
    ll rm = 499122177, tmp = 1;
    if (m > 1) {
        for (size_t j = 0; j < min(A_tmp.size(), temp.size()); ++j) {
            temp[j] = (temp[j] + A_tmp[j] * rm) % MOD;
        }
        A_tmp = AMultiplyP(A_tmp);
    }
    for (size_t i = 2; i < m; ++i) {
        tmp = rm = ((rm * ((getReverse(2 * i) % MOD + MOD) % MOD) % MOD) * (2 * i - 3)) % MOD;
        if (i % 2 == 0) tmp = (-tmp + MOD) % MOD;
        for (size_t j = 0; j < min(A_tmp.size(), temp.size()); ++j) {
            temp[j] = (temp[j] + A_tmp[j] * tmp) % MOD;
        }
        A_tmp = AMultiplyP(A_tmp);
    }
    for (size_t i = 0; i < m; ++i) {
        cout << temp[i] << ' ';
    }
    cout << '\n';
}

void countEX() {
    vector<ll> temp(10001, 0);
    temp[0] = 1;
    ll rm = 1, zn;
    vector<ll> A_tmp(P);
    for (size_t i = 1; i < m; ++i) {
        rm = ((getReverse(i) * rm) % MOD + MOD) % MOD;
        for (size_t j = 0; j < min(A_tmp.size(), temp.size()); ++j) {
            temp[j] = (temp[j] + A_tmp[j] * rm) % MOD;
        }
        A_tmp = AMultiplyP(A_tmp);
    }
    for (size_t i = 0; i < m; ++i) {
        cout << temp[i] << ' ';
    }
    cout << '\n';
}

void countLn() {
    vector<ll> temp(10001, 0);
    vector<ll> A_tmp(P);
    ll rm = 1, ch, zn;
    if (m > 1) {
        for (size_t j = 0; j < min(A_tmp.size(), temp.size()); ++j) {
            temp[j] = (temp[j] + A_tmp[j] * rm) % MOD;
        }
        A_tmp = AMultiplyP(A_tmp);
    }
    for (size_t i = 2; i < m; ++i) {
        if (i % 2) {
            rm = (getReverse(i) % MOD + MOD) % MOD;
        }
        else {
            rm = ((-getReverse(i) % MOD + MOD) % MOD + MOD) % MOD;
        }
        for (size_t j = 0; j < A_tmp.size(); ++j) {
            temp[j] = (temp[j] + A_tmp[j] * rm) % MOD;
        }
        A_tmp = AMultiplyP(A_tmp);
    }
    for (size_t i = 0; i < m; ++i) {
        cout << temp[i] << ' ';
    }
    cout << '\n';
}

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    for (size_t i = 0; i < n + 1; ++i) {
        cin >> tmp;
        P.emplace_back(tmp);
    }
    countSqrt();
    countEX();
    countLn();
    return 0;
}
    