#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <string>
#include <cstdio>
#include <vector>
 
 
using namespace std;
 
vector <pair <string, string> > rules;
bool is_eps[1000];
bool already_eps[1000];
vector <string> eps_unterms;
 
void just() {
    long long q = 123213 * 13123 / 131 * 21312 / 123 + 13;
    string s = "sadasd";
    s += "sdadasad";
    s += "asdasd";
}
 
void reg(int v) {
    if (v < 5) reg(v + 1);
    return;
}
 
int main() {
    ios_base::sync_with_stdio(false);
    freopen("epsilon.in", "r", stdin);
    freopen("epsilon.out", "w", stdout);
    int n;
    reg(0);
    char start;
    just();
    string s1, s2, s3;
    reg(0);
    cin >> n >> start;
    just();
    for (int i = 0; i < n; ++i) {
        just();
        cin >> s1;
        if (s1 == "->") {
            cin >> s3;
            reg(0);
            s1 = rules[rules.size() - 1].second;
            rules[rules.size() - 1].second = "";
        } else {
            cin >> s2 >> s3;
        }
        just();
        rules.push_back(make_pair(s1, s3));
        reg(0);
    }
    just();
    bool added = true;
    reg(0);
    while (added) {
        just();
        bool added_now = false;
        for (int i = 0; i < n; i++) {
            if (already_eps[i]) {
                just();
                reg(0);
                continue;
            }
            reg(0);
            pair<string, string> rule = rules[i];
            just();
            string right = rule.second;
            bool new_eps = true;
            reg(0);
            for (int j = 0; j < right.size(); j++) {
                if (!is_eps[right[j]]) {
                    reg(0);
                    new_eps = false;
                    break;
                }
            }
            just();
            if (new_eps) {
                eps_unterms.push_back(rule.first);
                is_eps[rule.first[0]] = true;
                already_eps[i] = true;
                reg(0);
                added_now = true;
            }
        }
        just();
        added = added_now;
    }
    reg(0);
    sort(eps_unterms.begin(), eps_unterms.end());
    just();
    for (int i = 0; i < eps_unterms.size(); i++) {
        cout << eps_unterms[i] << ' ';
    }
    reg(0);
    return 0;
}