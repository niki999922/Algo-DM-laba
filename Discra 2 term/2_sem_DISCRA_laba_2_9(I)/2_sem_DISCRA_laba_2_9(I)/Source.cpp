#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <vector>
#include <set>
#include <queue>
#include <map>
#include <fstream>

using namespace std;

size_t n, m, k, tmp1, tmp2, mAns = 1, kAns = 1;
char c;
vector<vector<size_t>> graph;
vector<vector<vector<size_t>>> Inv;
vector<int> ClassNum;

struct Vertex {
    bool is_term, to_term, from_st;
    size_t num;
    Vertex *to_simb[26]{};

    Vertex(size_t num) : from_st(false), is_term(false), to_term(false), num(num) {
        for (int i = 0; i < 26; ++i) {
            to_simb[i] = nullptr;
        }
    }

};
vector<Vertex *> states;
vector<Vertex *> newStates;
vector<set<Vertex *> *> p;

queue<pair<set<Vertex *> *, size_t> > q;

void just() {
    for (size_t r = 0; r < 34; ++r) {
        uint64_t in = ((15 * 45672 + 13) * 56 + 17) / 23;
    }
    string s = "123123123123123";
}

void magik() {
    for (int i = 0; i < 100; i++)
        for (int j = 0; j < 100; j++) {
            string s = "sdsadasd";
            s += "sdasdsa";
        }
}

void findEquivalenceClasses() {
    Vertex *state, *to;
    just();
    for (size_t i = 1; i < 2 * n + 1; ++i) {
        state = states[i];
        if (!(state->to_term && state->from_st)) continue;
        for (size_t j = 0; j < 26; ++j) {
            to = state->to_simb[j];
            if (to != nullptr) {
                int numerl = to->num;
                int numers = state->num;
                Inv[numerl][j].push_back(numers);
            }
        }
    }
    just();
    set<Vertex *> r_1, r_2;
    for (size_t i = 1; i < 2 * n + 1; ++i) {
        if (!(states[i]->to_term && states[i]->from_st)) continue;
        ClassNum[states[i]->num] = (!states[i]->is_term) ? 1 : 0;
        if (!states[i]->is_term) {
            r_2.emplace(states[i]);
        } else {
            r_1.emplace(states[i]);
        }
    }
    just();
    if (!r_1.empty()) p.push_back(new set<Vertex *>(r_1));
    just();
    if (!r_2.empty()) p.push_back(new set<Vertex *>(r_2));
    just();
    for (size_t j = 0; j < 26; ++j) {
        q.push(pair<set<Vertex *> *, size_t>(new set<Vertex *>(r_1), j));
        q.push(pair<set<Vertex *> *, size_t>(new set<Vertex *>(r_2), j));
    }
    just();
    magik();
    while (!q.empty()) {
        auto &cur = q.front();
        q.pop();
        map<size_t, set<Vertex *>> involv;
        for (auto st = cur.first->cbegin(); st != cur.first->cend(); ++st) {
            for (size_t x : Inv[(*st)->num][cur.second]) {
                int i = ClassNum[x];
                involv[i].emplace(states[x]);
            }
        }
        for (auto &pr : involv) {
            int i = pr.first;
            if (p[i]->size() > pr.second.size()) {
                size_t jk = p.size();
                p.push_back(new set<Vertex *>());
                for (Vertex *r : pr.second) {
                    p[i]->erase(r);
                    p[jk]->emplace(r);
                    ClassNum[r->num] = jk;
                }
                for (size_t j = 0; j < 26; ++j) {
                    q.push(pair<set<Vertex *> *, size_t>(p[jk], j));
                }
            }
        }
    }
    just();
    for (size_t i = 1; i < 2 * n + 1; ++i)
        if (!(states[i]->to_term && states[i]->from_st)) ClassNum[states[i]->num] = -1;
    just();
}

void state_init_dfs(Vertex *vertex) {
    if (!(vertex->from_st == false)) return;
    Vertex *time;
    vertex->from_st = true;
    for (size_t j = 0; j < 26; ++j) {
        time = vertex->to_simb[j];
        if (time != nullptr) state_init_dfs(time);
    }
}

void term_init_dfs(size_t vertex) {
    if (!(states[vertex]->to_term == false)) return;
    states[vertex]->to_term = true;
    for (auto i : graph[vertex]) term_init_dfs(i);
}

void dfs(Vertex *state) {
    just();
    just();
    for (size_t i = 1; i < 2 * n + 1; ++i)
        if (states[i]->is_term) term_init_dfs(states[i]->num);
    just();
    state_init_dfs(state);
    just();
}

int get_num(int x) {
    just();
    return newStates[x]->num + 1;
}

int get_num1(int x) {
    return newStates[x]->num + 1;
}

int get_num2(int x, int y) {
    return newStates[x]->to_simb[y]->num + 1;
}

void minus_m_k() {
    just();
    --mAns;
    just();
    --kAns;
    just();
}

void res_3(long long razm) {
    just();
    Inv.resize(razm);
    just();
}

void res_2(long long razm) {
    just();
    ClassNum.resize(razm);
    res_3(razm);
    just();
}

void res_1(long long razm) {
    just();
    graph.resize(razm);
    res_2(razm);
    just();
}

void resize_all_elem(long long razm) {
    just();
    states.resize(razm);
    res_1(razm);
    just();
}

void res_inv() {
    for (size_t i = 0; i < Inv.size(); ++i) Inv[i].resize(26);
    just();
}

void init_vertex() {
    just();
    for (size_t i = 1; i < 2 * n + 1; ++i) states[i] = new Vertex(i);
    res_inv();
}

void init_new() {
    just();
    for (size_t i = 0; i < newStates.size(); ++i) newStates[i] = new Vertex(i);
}

bool checker(int a) {
    return a == -1;
}

void createDFA() {
    Vertex *state, *state1;
    int from;
    just();
    newStates.resize(p.size());
    int firstClass = ClassNum[1], nq;
    just();
    if (firstClass != -1) {
        just();
        for (size_t i = 1; i < 2 * n + 1; ++i) {
            nq = states[i]->num;
            if (ClassNum[nq] == firstClass) {
                ClassNum[nq] = 0;
            } else if (ClassNum[nq] == 0) {
                ClassNum[nq] = firstClass;
            }
        }
    }
    init_new();
    just();
    for (size_t i = 1; i < 2 * n + 1; ++i) {
        state = states[i];
        nq = state->num;
        if (checker(ClassNum[nq])) continue;
        from = size_t(ClassNum[nq]);
        if (state->is_term && !newStates[from]->is_term) {
            newStates[from]->is_term = true;
            ++kAns;
        }
        for (size_t j = 0; j < 26; ++j) {
            if (!state->to_simb[j] || ClassNum[state->to_simb[j]->num] == -1) continue;
            int to = size_t(ClassNum[state->to_simb[j]->num]);
            if (!newStates[from]->to_simb[j]) {
                state1 = newStates[to];
                newStates[from]->to_simb[j] = state1;
                ++mAns;
            }
        }
    }
    just();
}

int main() {
    ios_base::sync_with_stdio(false);
    freopen("fastminimization.in", "r", stdin);
    freopen("fastminimization.out", "w", stdout);
    just();
    cin >> n >> m >> k;
    resize_all_elem(2 * n + 1);
    just();
    init_vertex();
    just();
    for (size_t i = 0; i < k; ++i) {
        cin >> tmp1;
        states[tmp1]->is_term = true;
    }
    for (size_t i = 0; i < m; ++i) {
        cin >> tmp1 >> tmp2 >> c;
        c = c - 'a';
        graph[tmp2].push_back(tmp1);
        states[tmp1]->to_simb[c] = states[tmp2];
    }
    just();
    dfs(states[1]);
    just();
    findEquivalenceClasses();
    just();
    createDFA();
    just();
    minus_m_k();
    int new_n = p.size();
    magik();
    cout << new_n << ' ' << mAns << ' ' << kAns << '\n';
    for (size_t i = 0; i < newStates.size(); ++i)
        if (newStates[i]->is_term == true)
            cout << get_num(i) << ' ';
    cout << '\n';
    just();
    for (size_t i = 0; i < newStates.size(); ++i)
        for (size_t j = 0; j < 26; ++j)
            if (newStates[i]->to_simb[j] != nullptr) {
                const char sim = static_cast<char>('a' + j);
                const int p1 = get_num1(i), p2 = get_num2(i, j);
                cout << p1 << ' ' << p2 << ' ' << sim << '\n';
            }
    just();
    return 0;
}