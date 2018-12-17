#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string>
#include <set>
#include <cmath>

using namespace std;

typedef long long ll;
typedef unsigned char byte;
typedef unsigned int ui;


class Vertex {
public:
    ui num, w;
    
    Vertex() {}
    Vertex(ui num, ui w) : num(num), w(w) {}
};

ui n, m;
vector<bool> used;
vector<ui> weight;


vector<vector<ui>> variety;
vector<ui> masks;
vector<ui> allElemX;
set<ui> elem;

bool first = false;
bool second = true;
bool third = true;

ui getMask(const vector<ui>& v) {
    ui res = 0;
    for (ui varietySize : v) {
        res += (1 << varietySize);
    }
    return res;
}

bool isOne(const ui& mask,const ui& bit) {
    return (mask & (1 << bit)) > 0;
}

int main() {
    std::ios::sync_with_stdio(false);
    freopen("check.in", "r", stdin);
    freopen("check.out", "w", stdout);
    cin.tie(nullptr);  
    cin >> n >> m;
    variety.resize(m);
    masks.resize(1 << n, false);
    for(size_t i = 0; i < m; ++i) {
        ui k, pos = 0;
        cin >> k;
        variety[i].resize(k);
        for (size_t j = 0; j < k; ++j) {
            ui tmp;
            cin >> tmp;
            --tmp;
            pos += 1 << tmp;
            variety[i][j] = tmp;
            elem.insert(tmp);
        }
        masks[pos] = true;
        if (variety[i].empty()) first = true;
    }
    if (!first) {
        cout << "NO";
        return 0;
    }
    for(size_t i = 0; i < m; ++i) {
        ui varietySize = variety[i].size();
        for (size_t mask = 1; mask < (1 << varietySize) - 1; ++mask) {
            ui pos = 0;
            for(size_t j = 0; j < varietySize; ++j) {
                if (isOne(mask, j)) {
                    pos += (1 << variety[i][j]);
                }
            }
            if (!masks[pos]) {
                second = false;
                cout << "NO";
                return 0;
            }
        }
    }
    for (size_t i = 0; i < m; ++i) {
        for (size_t j = 0; j < m; ++j) {
            if (variety[i].size() > variety[j].size()) {
                ui maskA = getMask(variety[i]);
                ui maskB = getMask(variety[j]);
                for (size_t z = 0; z < n; ++z) {
                    if (isOne(maskB, z)) {
                        if (isOne(maskA, z)) {
                            maskA ^= (1 << z);
                        }
                    }
                }
                set<ui> els;
                for (size_t z = 0; z < n; ++z) {
                    if (isOne(maskA, z)) els.insert(z);
                }
                bool ok3 = false;
                for (ui tmp : els) {
                    if (masks[(maskB + (1 << tmp))]) {
                        ok3 = true;
                        break;
                    }
                }
                if (!ok3) {
                    third = false;
                    cout << "NO";
                    return 0;
                }
            }
        }
    }
    cout << "YES";
    return 0;
}