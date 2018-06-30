#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
 
using namespace std;
 
char start;
vector< pair<int, int>> to_a[1010];
string s;
 
bool check(int pos, int v) {
    if (pos == s.size()) return (v == -1);
    if (v == -1) return false;
    int c = s[pos] - 'a';
    for (auto to : to_a[v])
        if (to.first == c)
            if (check(pos + 1, to.second)) return true;
    return false;
}
 
 
int main() {
    ios_base::sync_with_stdio(false);
    freopen("automaton.in", "r", stdin);
    freopen("automaton.out", "w", stdout);
    int n, m, from, to, term;
    char c;
    string s1, s2;
    cin >> n >> c;
    start = c - 'A';
    for (int i = 0; i < n; ++i) {
        cin >> s1 >> s2 >> s2;
        to = -1;
        from = s1[0] - 'A';
        term = s2[0] - 'a';
        if (s2.size() > 1) {
            to = s2[1] - 'A';
        }
        to_a[from].push_back(make_pair(term, to));
    }
    cin >> m;
    for (int i = 0; i < m; ++i) {
        cin >> s;
        if (check(0, start)) cout << "yes" << '\n'; else cout << "no" << '\n';
    }
    return 0;
}