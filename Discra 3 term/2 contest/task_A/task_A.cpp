#include <iostream>
#include <vector>

using namespace std;

typedef unsigned char byte;

vector<int> from, to, ham_way, vertex;
vector<byte> color;
int n, m , tmp1, tmp2, edge1, edge2;
bool flag = true;

bool dfs(int v, byte k) {
    color[v] = k;
    for (size_t i = 0; i < from.size(); ++i) {
        edge1 = v;
        edge2 = i;
        if (vertex[from[edge1]] > vertex[from[edge2]]) swap(edge1, edge2);
        if ((vertex[from[edge1]] < vertex[from[edge2]]) && 
            (vertex[from[edge2]] < vertex[to[edge1]])   && 
            (vertex[to[edge1]]   < vertex[to[edge2]])) {
            if (!color[i]) {
                dfs(i, ((k == 1) ? 2 : 1));
            } else {
                if (color[edge1] == color[edge2]) {
                    return false;
                }
            }
        }
    }
    return true;
}

int main() {
    std::ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> m;
    ham_way.resize(n);
    vertex.resize(n);
    color.resize((n*(n-1))/2, 0);
    for (size_t i = 0; i < m; ++i) {
        cin >> tmp1 >> tmp2;
        --tmp1;
        --tmp2;
        from.push_back(tmp1);
        to.push_back(tmp2);
    }
    for (size_t i = 0; i < n; ++i) {
        cin >> tmp1;
        --tmp1;
        ham_way[i] = tmp1;
        vertex[tmp1] = i;
    }
    for (size_t i = 0; i < m; ++i) {
        if (vertex[from[i]] > vertex[to[i]]) 
            swap(from[i], to[i]);
    }
    for (size_t i = 0; i < m; ++i) {
        if (!color[i] && !dfs(i, 1)) {
            cout << "NO\n";
            return 0;
        }
    }
    cout << "YES\n";
    for (size_t i = 0; i < n; ++i) {
        cout << vertex[i] << " 0 ";
    }
    cout << '\n';
    for (size_t i = 0; i < m; ++i) {
        cout << (vertex[from[i]] + vertex[to[i]]) / 2.0 << ' ';
        cout << ((color[i] == 1) ? abs(vertex[from[i]] - vertex[to[i]]) / 2.0 : abs(vertex[from[i]] - vertex[to[i]]) / -2.0) << '\n';
    }
    return 0;
}