#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <fstream>
#include <vector>
#include <string>
using namespace std;

int n;
vector<int> v;
string s;


bool comp(int a, int b) {
    cout << "1 " << b << " " << a << endl;
    cin >> s;
    return (s == "YES") ? false : true;
}

int main() {
    std::ios::sync_with_stdio(false);
    cin >> n;
    v.resize(n);
    for (size_t i = 0; i < n; ++i)
        v[i] = i + 1;
    stable_sort(v.begin(), v.end(), comp);
    cout << "0 ";
    for (size_t i = 0; i < n; ++i) {
        cout << v[i] << ' ';
    }
    cout.flush();
    return 0;
}