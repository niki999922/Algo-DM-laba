#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string>
#include <cmath>

using namespace std;

typedef long long ll;
typedef unsigned char byte;
typedef unsigned int ui;

class Task {
public:
    ui first;
    ui second;
    Task() {}
    Task(ui f, ui s) : first(f), second(s) {}
};

ui n, pos;
vector<Task> tasks;
vector<ui> rankd, num, parent;

int get(int x) {
    if (x == parent[x]) return x;
    return parent[x] = get(parent[x]);
}

int get_num(int x) {
    return num[get(x)];
}

void unionDSU(int x, int y) {
    x = get(x);
    y = get(y);
    if (x == y) {
        return;
    }
    num[y] = num[x];
    if (rankd[x] < rankd[y]) {
        swap(x, y);
    }
    if (rankd[x] == rankd[y]) {
        rankd[x]++;
    }
    parent[y] = x;
}

bool cmp(const Task &a, const Task &b) {
    return (a.second > b.second) || (a.second == b.second && a.first < b.first);
}

   
int main() {
    std::ios::sync_with_stdio(false);
    freopen("schedule.in", "r", stdin);
    freopen("schedule.out", "w", stdout);
    cin.tie(0);
    cin >> n;
    tasks.resize(n);
    rankd.resize(n + 1, 0);
    num.resize(n + 1);
    parent.resize(n + 1);
    for (size_t i = 0; i < n + 1; ++i) {
        num[i] = i;
        parent[i] = i;
    }
    for (size_t i = 0; i < n; ++i) {
        cin >> tasks[i].first >> tasks[i].second;
        tasks[i].first = min(tasks[i].first, n);
    }
    sort(tasks.begin(), tasks.end(), cmp);
    ll result = 0;
    for (size_t i = 0; i < n; ++i) {
        pos = get_num(tasks[i].first);
        if (pos > 0) {
            unionDSU(pos - 1, pos);
        } else {
            result += static_cast<ll>(tasks[i].second);
        }
    }
    cout << result;
    return 0;
}