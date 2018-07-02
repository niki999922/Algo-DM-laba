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
 

 
int main() {
    ios_base::sync_with_stdio(false);
    freopen("epsilon.in", "r", stdin);
    freopen("epsilon.out", "w", stdout);
    int n;
    char start;
    string s1, s2, s3;
    cin >> n >> start;
    for (int i = 0; i < n; ++i) {
        cin >> s1;
        if (s1 == "->") {
            cin >> s3;
            s1 = rules[rules.size() - 1].second;
            rules[rules.size() - 1].second = "";
        } else {
            cin >> s2 >> s3;
        }
        rules.push_back(make_pair(s1, s3));
    }
    bool added = true;
    while (added) {
        bool added_now = false;
        for (int i = 0; i < n; i++) {
            if (already_eps[i]) {
                continue;
            }
            pair<string, string> rule = rules[i];
            string right = rule.second;
            bool new_eps = true;
            for (int j = 0; j < right.size(); j++) {
                if (!is_eps[right[j]]) {
                    new_eps = false;
                    break;
                }
            }
            if (new_eps) {
                eps_unterms.push_back(rule.first);
                is_eps[rule.first[0]] = true;
                already_eps[i] = true;
                added_now = true;
            }
        }
        added = added_now;
    }
    sort(eps_unterms.begin(), eps_unterms.end());
    for (int i = 0; i < eps_unterms.size(); i++) {
        cout << eps_unterms[i] << ' ';
    }
    return 0;
}
