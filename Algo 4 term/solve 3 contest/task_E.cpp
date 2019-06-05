#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <queue>
#include <deque>
#include <string>
#include <algorithm>
#include <map>
#include <set>
#include <sstream>
#include <cmath>

using namespace std;


typedef long long ll;
typedef unsigned long long ull;
typedef unsigned long ul;
typedef unsigned int ui;
typedef unsigned char byte;
typedef vector<int> vi;
typedef vector<ll> vll;

const int INF = INT32_MAX - 1;
const ll MOD = 998244353;
const ll N = 20000001;

ll tmpn, x = 1, y = 0, tmp, e, c, q, p, M;

ll multiply(ll a, ll b, ll n) {
    ll d = 0;
    for (size_t i = 64; i > 0; --i) {
        d = (d + d) % n;
        if ((b >> (i - 1)) & 1) {
            d = (d + a) % n;
        }
    }
    return d;
}

ll mod(ll a, ll b, ll n) {
    ll d = 1;
    for (size_t i = 64; i > 0; --i) {
        d = multiply(d, d, n);
        if ((b >> (i - 1)) & 1) {
            d = multiply(d, a, n);
        }
    }
    return d;
}

ll invar(ll a, ll n) {
    tmpn = n;
    while (tmpn) {
        tmp = x - a / tmpn * y;
        x = y;
        y = tmp;
        tmp = a % tmpn;
        a = tmpn;
        tmpn = tmp;
    }
    if (a != 1) {
        return 0;
    }
    return (x + n) % n;
}


int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    ll n, d;
    cin >> n >> e >> c;
    if (n & 1) {
        for (size_t i = 3; i * i <= n; i += 2) {
            if (!(n % i)) {
                q = n / i;
                p = i;
                break;
            }
        }
    } else {
        q = n >> 1;
        p = 2;
    }
    d = invar(e, (p - 1) * (q - 1));
    M = mod(c, d, n);
    cout << M;
    return 0;
}