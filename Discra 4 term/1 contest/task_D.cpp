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
const ll SUPER_LONG = LLONG_MAX / 2;
const ll MOD = 1e9 + 7;
const unsigned int N = 7;

stack<vector<ll>> s;
string input;

ll getSoch(ll n, ll k) {
    ll c = 1;
    for (ll i = n - k + 1; i < n + 1; ++i) {
        c = c * i;
    }
    for (ll i = 1; i < k + 1; ++i) {
        c = c / i;
    }
    return c;
}

vector<ll> getPair(vector<ll> &A, vector<ll> &B) {
    vector<ll> vec(N);
    for (size_t w = 0; w < N; ++w) {
        for (size_t i = 0; i < w + 1; ++i) {
            vec[w] += A[i] * B[w - i];
        }
    }
    return vec;
}

vector<ll> getSeq(vector<ll> &A) {
    vector<ll> vec(N);
    vec[0] = 1;
    for (size_t w = 1; w < N; ++w) {
        for (size_t i = 1; i < w + 1; ++i) {
            vec[w] += A[i] * vec[w - i];
        }
    }
    return vec;
}

vector<ll> getMulSet(vector<ll> &A) {
    vector<vector<ll>> tmp(N, vector<ll>(N, 0));
    for (size_t i = 0; i < N; ++i) {
        tmp[0][i] = 1;
    }
    for (size_t i = 1; i < N; ++i) {
        for (size_t j = 1; j < N; ++j) {
            if (A[j] > 0) {
                for (size_t k = 0; k < (i / j) + 1; ++k) {
                    tmp[i][j] += getSoch(A[j] + k - 1, k) * tmp[i - k * j][j - 1];
                }
            } else {
                tmp[i][j] = tmp[i][j - 1];
            }
        }
    }
    vector<ll> vec(N);
    for (size_t w = 0; w < N; ++w) {
        vec[w] = tmp[w][w];
    }
    return vec;
}



//s.top();
//s.pop();

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    getline(cin, input);    
    for (int ind = input.length() - 1; ind >= 0; --ind) {
        switch (input[ind]) {
        case 'B': {
            s.push(vector<ll>({ 0, 1, 0, 0, 0, 0, 0 }));
            break;
        }
        case 'L': {
            auto t = s.top();
            s.pop();
            s.push(getSeq(t));
            break;
        }
        case 'S': {
            auto t = s.top();
            s.pop();
            s.push(getMulSet(t));
            break;
        }
        case 'P': {
            auto t1 = s.top();
            s.pop();
            auto t2 = s.top();
            s.pop();
            s.push(getPair(t1, t2));
            break;
        }
        default:
            break;
        }
    }
    auto ans = s.top();
    for (auto it : ans) {
        cout << it << ' ';
    }
    return 0;
}