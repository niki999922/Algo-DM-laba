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



ui n, m, ans = 0, ansSize = 0;
vector<ui> weigth, masks;


void putMask(ui pos) {
    if (!masks[pos]) return;
    masks[pos] = false;
    if (pos == (1 << n) - 1) return;
    for (size_t i = 0; i < n; ++i) {
        if ((pos & (1 << i)) == 0) {
            putMask(pos + (1 << i));
        }
    }
}

bool isOne(const ui& mask, const ui& bit) {
    return (mask & (1 << bit)) > 0;
}

int main() {
    std::ios::sync_with_stdio(false);
    freopen("cycles.in", "r", stdin);
    freopen("cycles.out", "w", stdout);
    cin.tie(nullptr);  
    cin >> n >> m;
    weigth.resize(n);
    masks.resize(1 << n, true);
    for(size_t i = 0; i < n; ++i) {
        cin >> weigth[i];
    }
    for(size_t i = 0; i < m; ++i) {
        ui k, pos = 0;
        cin >> k;
        for(size_t j = 0; j < k; ++j) {
            int tmp;
            cin >> tmp;
            --tmp;
            pos += (1 << tmp);
        }
        putMask(pos);
    }
    for(size_t mask = 0; mask < (1 << n); ++mask) {
        if (masks[mask]) {
            ui sum = 0, sumSize = 0;
            for(size_t j = 0; j < n; ++j) {
                if (isOne(mask, j)) {
                    sum += weigth[j];
                    ++sumSize;
                }
            }
            if (sumSize > ansSize) {
                ans = 0;
                swap(ansSize,sumSize);
            }
            ans = max(ans, sum);
        }
    }
    cout << ans;
    return 0;
}