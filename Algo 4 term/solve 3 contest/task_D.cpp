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

ll a, b, n, m;

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> a >> b >> n >> m;
    if (n < m) {
        swap(a, b);
        swap(n, m);
    }
    for (size_t i = 0; i < m; ++i) {
        if ((i * n + a) % m == b) {
            cout << i * n + a;
        }
    }
    return 0;
}