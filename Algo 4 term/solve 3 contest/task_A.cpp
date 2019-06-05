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

int n, a;
vector<bool> prime(N, false);

void pre_count() {
    for (size_t i = 2; i * i < N; ++i) {
        if (!prime[i]) {
            for (size_t j = i * i; j < N; j += i) {
                prime[j] = 1;
            }
        }
    }
}


int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    pre_count();
    cin >> n;
    for (size_t i = 0; i < n; ++i) {
        cin >> a;
        if (!prime[a]) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }
    return 0;
}