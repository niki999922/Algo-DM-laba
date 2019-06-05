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
typedef vector<ull> vi;
typedef vector<ll> vll;

const ull INF = INT32_MAX - 1;
const ll MOD = 998244353;
const ull TIME_MR = 5;

int N;
ll A;


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

ll getReverse(ll a, ll mod) {
    ll x, y;
    ll g = gcd(a, mod, x, y);
    if (g != 1) {
        return 0;
    } else {
        return x;
    }
}


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

char check(ll tmp, ll a) {
    ll u, t, y;
    for (size_t i = 1; ; ++i) {
        if (((a - 1) >> i) & 1) {
            t = i;
            u = (a - 1) >> i;
            break;
        }
    }
    ll x = mod(tmp, u, a);
    for (size_t i = 0; i < t; ++i) {
        y = mod(x, 2, a);
        if (y == 1 && x != 1 && x != a - 1) {
            return 1;
        }
        x = y;
    }
    if (x != 1) {
        return 1;
    }
    return 0;
}

bool MR(ll a) {
    ll tmp;
    for (size_t i = 0; i < TIME_MR; ++i) {
        tmp = (rand() % (a - 1)) + 1;
        if (check(tmp, a)) {
            return 0;
        }
    }
    return 1;
}

bool check_ch(ll a) {
    return (a == 1 || (a != 2 && !(a % 2)));
}

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> N;
    for (size_t i = 0; i < N; ++i) {
        cin >> A;
        if (check_ch(A)) {
            cout << "NO\n";
            continue;
        }
        if (A == 2 || MR(A)) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }
    return 0;
}
