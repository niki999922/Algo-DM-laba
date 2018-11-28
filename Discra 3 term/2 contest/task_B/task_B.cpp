#include <iostream>
#include <cmath>
#include <algorithm>
#include <map>
#include <functional>
#include <vector>

using namespace std;

typedef unsigned int ui;

const double EPS = 1e-8;

struct Vertex {
    double x, y;

    Vertex(double a, double b) {
        this->x = a;
        this->y = b;
    }

    bool operator<(const Vertex &v) const {
        return (x < v.x - EPS) || (abs(x - v.x) < EPS && y < v.y - EPS);
    }
};

struct Line {
    double x1, y1, x2, y2;

    Vertex operator+(const Line &line) const {
        double tmp_a0 = line.x1 * line.y2 - line.y1 * line.x2;
        double tmp_b = (x1 - x2) * (line.y1 - line.y2) - (y1 - y2) * (line.x1 - line.x2);
        double tmp_a = x1 * y2 - y1 * x2;
        return Vertex((tmp_a * (line.x1 - line.x2) - tmp_a0 * (x1 - x2)) / tmp_b, (tmp_a * (line.y1 - line.y2) - tmp_a0 * (y1 - y2)) / tmp_b);
    }
};


ui n, amount = 0;

size_t id_size;
vector<Line> lines;
vector<Vertex> vertexesm;
vector<vector<ui>> edges;
map<Vertex, ui> id;
vector<vector<bool>> used;
vector<double> answer;

void addVer(Vertex x, vector< vector<ui> > &v, map<Vertex, ui> &id_num, vector<Vertex> &vertexes) {
    if (!id_num.count(x)) {
        id_num[x] = vertexes.size();
        vertexes.push_back(x);
        v.push_back(vector<ui>());
    }
}

function<bool(ui, ui)> cmpAngle(ui center, vector<Vertex> &vertexes) {
    return [&vertexes, center](ui a, ui b)->bool {
        return atan2(vertexes[a].y - vertexes[center].y, vertexes[a].x - vertexes[center].x) <
            atan2(vertexes[b].y - vertexes[center].y, vertexes[b].x - vertexes[center].x);
    };
}

int main() {
    std::ios::sync_with_stdio(false);
    cin.tie(0); 
    cin >> n;
    lines.resize(n);
    for (size_t i = 0; i < n; ++i) {
        double x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        lines[i].x1 = x1;
        lines[i].y1 = y1;
        lines[i].x2 = x2;
        lines[i].y2 = y2;
    }
    for (size_t i = 0; i < n; ++i) {
        vector<Vertex> temp;
        for (size_t j = 0; j < n; ++j) {
            Vertex v(lines[i] + lines[j]);
            if (isfinite(v.x)) {
                addVer(v, edges, id, vertexesm);
                temp.push_back(v);
            }
        }
        stable_sort(temp.begin(), temp.end());
        if (!temp.empty()) {
            ui tmp1, tmp2;
            size_t t_size = temp.size() - 1;
            for (size_t j = 0; j < t_size; ++j) {
                tmp2 = id[temp[j + 1]];
                tmp1 = id[temp[j]];
                if (tmp1 != tmp2) {
                    edges[tmp2].push_back(tmp1);
                    edges[tmp1].push_back(tmp2);
                }
            }
        }
    }
    for (size_t i = 0; i < edges.size(); ++i) {
        stable_sort(edges[i].begin(), edges[i].end(), cmpAngle(i, vertexesm));
    }
    id_size = id.size();
    used.resize(id_size);
    for (size_t i = 0; i < id_size; ++i) {
        used[i].resize(edges[i].size(), false);
    }
    for (size_t i = 0; i < edges.size(); ++i) {
        for (size_t j = 0; j < edges[i].size(); ++j) {
            if (!used[i][j]) {
                used[i][j] = true;
                double square = 0;
                vector<ui> face;
                ui cur = edges[i][j];
                ui prev = i;
                while (true) {
                    face.push_back(cur);
                    auto next = upper_bound(edges[cur].begin(), edges[cur].end(), prev, cmpAngle(cur, vertexesm));
                    if (next == edges[cur].end()) {
                        next = edges[cur].begin();
                    }
                    if (used[cur][next - edges[cur].begin()]) {
                        break;
                    }
                    used[cur][next - edges[cur].begin()] = true;
                    prev = cur;
                    cur = *next;
                }
                face.push_back(face[0]);
                for (size_t k = 0; k < face.size() - 1; ++k) {
                    square += (vertexesm[face[k]].x * vertexesm[face[k + 1]].y - vertexesm[face[k]].y * vertexesm[face[k + 1]].x);
                }
                answer.push_back(square / -2.0);
            }
        }
    }
    for (size_t i = 0; i < answer.size(); ++i) {
        if (answer[i] <= EPS) {
            ++amount;
        }
    }
    cout << amount << '\n';
    stable_sort(answer.begin(), answer.end());
    cout.precision(15);
    for (size_t i = answer.size() - amount; i < answer.size(); ++i) {
        cout << answer[i] << '\n';
    }
    return 0;
}