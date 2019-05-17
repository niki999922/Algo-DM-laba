#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <queue>
#include <deque>
#include <string>
#include <algorithm>
#include <map>
#include <set>
#include <cmath>

using namespace std;


typedef long long ll;
typedef unsigned long long ull;
typedef unsigned long ul;
typedef unsigned char byte;
typedef vector<int> vi;
typedef vector<ll> vll;

const int INF = INT32_MAX - 1;
const ll MOD = 998244353;

int n, num;

bool isPrime(int num) {
    for (size_t j = 2; j <= sqrt(num); ++j) {
        if (num % j == 0) {
            return false;
        }
    }
    return true;
}

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n;
    for (size_t i = 0; i < n; ++i) {
        cin >> num;
        if (isPrime(num)) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }
    return 0;
}
