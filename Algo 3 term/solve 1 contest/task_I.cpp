#include <iostream>
#include <vector>
#include <iomanip>


using namespace std;

const int INF = 999999999;
               
class Point {
public:
    long x, y;
    Point() {}
    Point(int x, int y) : x(x), y(y) {}
};

int main() {
    std::ios::sync_with_stdio(false);
    int n, a, b, min_pos, mn, w;
    double ans = 0;
    cin >> n;
    vector<Point> p(n);
    vector<int> d(n, INF);
    vector<bool> used(n, false);
    for (int i = 0; i < n; ++i) {
        cin >> a >> b;
        p[i] = Point(a, b);
    }
    d[0] = 0;
    while (true) {
        min_pos = -1;
        mn = INF;
        for (int i = 0; i < n; ++i) {
            if (!used[i] && d[i] < mn) {
                mn = d[i];
                min_pos = i;
            }
        }
        if (min_pos == -1) break;
        ans += sqrt(mn);
        used[min_pos] = true;
        for (int i = 0; i < n; ++i) {
            w = (p[min_pos].x - p[i].x) * (p[min_pos].x - p[i].x) + (p[min_pos].y - p[i].y) * (p[min_pos].y - p[i].y);
            if (d[i] > w)
                d[i] = w;
        }
    }
    cout << std::setprecision(15) << ans;
    return 0;
}



