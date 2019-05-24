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
const ll N = 1000;

int n, num;
vector<ui> simpleNumber;
vector<bool> prime(N + 1, true);

void getSimple() {
    for (auto it = simpleNumber.begin(); it != simpleNumber.end() && (*it)*(*it) <= num; ++it) {
        while (!(num % (*it))) {
            num /= (*it);
            cout << (*it) << ' ';
        }
    }
    if (num != 1) {
        cout << num << ' ';
    }
    cout << '\n';
    return;
}

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    prime[0] = prime[1] = false;
    for (int i = 2; i <= N; ++i) {
        if (prime[i]) {
            if (i * 1ll * i <= N) {
                for (int j = i * i; j <= N; j += i)
                    prime[j] = false;
            }
            simpleNumber.emplace_back(i);
        }
    }
    cin >> n;
    for (size_t i = 0; i < n; ++i) {
        cin >> num;
        getSimple();
    }
    return 0;
}