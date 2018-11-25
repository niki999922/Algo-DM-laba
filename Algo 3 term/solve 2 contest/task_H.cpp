#include <iostream>
#include <vector>
#include <functional> 
#include <queue>


using namespace std;


typedef long long ll;

const int N = 200004;
vector<pair<int, int>> adj[N];

int n, m;
int c[N];

ll get_obj() {
    priority_queue<pair<ll, int>, vector<pair<ll, int>>, greater<pair<ll, int>>> pq;
    for (int i = 0; i < n; i++) pq.push(make_pair(c[i], i));
    while (!pq.empty()) {
        pair<ll, int> p = pq.top();
        pq.pop();
        for (auto next : adj[p.second]) {
            if (c[next.second] > c[p.second] + c[next.first]) {
                c[next.second] = c[p.second] + c[next.first];
                pq.push(make_pair(c[next.second], next.second));
            }
        }
    }
    return c[0];
}

int main() {
    ios::sync_with_stdio(0);
    freopen("dwarf.in", "r", stdin);
    freopen("dwarf.out", "w", stdout);
    cin >> n >> m;
    for (int i = 0; i < n; ++i)
        cin >> c[i];
    int a, x, y;
    for (int i = 0; i < m; i++) {
        cin >> a >> x >> y;
        a--, x--, y--;
        adj[x].push_back(make_pair(y, a));
        adj[y].push_back(make_pair(x, a));
    }
    ll ans = get_obj();
    cout << ans << endl;
    return 0;
}