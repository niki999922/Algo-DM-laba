#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <fstream>
#include <string>
#include <algorithm>
#include <map>
#include <windows.h>

const int SIZE_TAPE = 100000;

using std::cout;
using std::cerr;
using std::endl;
using std::vector;
using std::string;
using std::pair;

class Condition {
public:
    const string name, cond;

    Condition(string name, string cond) : name(name), cond(cond) {}
};

bool operator< (const Condition& _Left, const Condition& _Right) noexcept {
    return (_Left.name < _Right.name) || (_Left.name == _Right.name && _Left.cond < _Right.cond);
}

class Condition_action {
public:
    string name;
    vector<pair<char, char>> vec_act;

    Condition_action(string name, vector<pair<char, char>> vec_act) : name(name), vec_act(vec_act) {}
};

size_t n;
int delay_time = 1000;
bool flag = true;
bool full = false;
long long steps = 0;
vector<vector<char>> tapes;
vector<size_t> tape_positions;
vector<pair<size_t, size_t>> tape_gran;
std::map<Condition, Condition_action> conditions;
std::ifstream input, file_task;


void write_input() {
    string str_tmp;
    input >> str_tmp;
    for(size_t i = 0; i < str_tmp.size(); ++i) {
        tapes[0][tape_positions[0]] = str_tmp[i];
        ++tape_positions[0];
    }
    tape_positions[0] = SIZE_TAPE / 2;
    tape_gran[0].second= SIZE_TAPE / 2 + str_tmp.size() + 1;
}

void parse_MT() {
    string str, name, condition, name2;
    getline(file_task, str);
    while (!file_task.eof()) {
        getline(file_task, str);
        if (str.find("->") == string::npos) continue;
        condition = "";
        vector<pair<char, char>> vp;
        name = str.substr(0, str.find(' '));
        str  = str.substr(str.find(' ') + 1);
        for (size_t i = 0; i < n; ++i) {
            condition += str.substr(0, str.find(' '));
            str = str.substr(str.find(' ') + 1);
        }
        str = str.substr(str.find("->") + 3);
        name2 = str.substr(0, str.find(' '));
        str = str.substr(str.find(' ') + 1);
        for (size_t i = 0; i < n - 1; ++i) {
            vp.emplace_back(std::make_pair(str[0], str[2]));
            str = str.substr(4);
        }
        vp.emplace_back(std::make_pair(str[0], str[2]));
        conditions.insert(std::make_pair(Condition(name, condition), Condition_action(name2, vp)));
    }
}

void print_cur_cond(const string &cur_cond, const string &state) {
    if (!full) system("cls");
    cout << "Current condition : " << cur_cond;
    for (size_t i = 0; i < n; ++i) {
        cout << ' ' << state[i];
    }
    cout << '\n';
    for (size_t i = 0; i < n; ++i) {
        for (size_t j = tape_gran[i].first; j < tape_gran[i].second; ++j) {
            if (j == tape_positions[i]) {
                cout << "<" << tapes[i][j] << "> ";
            } else {
                cout << tapes[i][j] << ' ';
            }
        }
        cout << '\n';
    }
    cout << endl;
    Sleep(delay_time);
}

void print_cur_cond(const string &cur_cond) {
    if (!full) system("cls");
    cout << "Current condition : " << cur_cond << '\n';
    for (size_t i = 0; i < n; ++i) {
        for (size_t j = tape_gran[i].first; j < tape_gran[i].second; ++j) {
            if (j == tape_positions[i]) {
                cout << "<" << tapes[i][j] << "> ";
            } else {
                cout << tapes[i][j] << ' ';
            }
        }
        cout << '\n';
    }
    cout << endl;
}

void run() {
    string cond = "S";
    string ac = "AC";
    string rj = "RJ";
    string blank = "_";
    string tmp = "";
    try {
        while (cond != ac) {
            ++steps;
            tmp = "";
            for (size_t i = 0; i < n; ++i) {
                tmp += tapes[i][tape_positions[i]];
            }
            if (flag) print_cur_cond(cond, tmp);
            Condition_action what_do = conditions.at(Condition(cond, tmp));
            cond = what_do.name;
            for (size_t i = 0; i < n; ++i) {
                tapes[i][tape_positions[i]] = what_do.vec_act[i].first;
                if (what_do.vec_act[i].second == '>') {
                    ++tape_positions[i];
                    if (tape_gran[i].second == tape_positions[i]) {
                        tape_gran[i].second = tape_positions[i] + 1;
                    }
                }
                if (what_do.vec_act[i].second == '<') {
                    --tape_positions[i];
                    if (tape_gran[i].first > tape_positions[i]) {
                        tape_gran[i].first = tape_positions[i];
                    }
                }
            }
        }
    } catch (...) {
        cerr << "Have not find rule for going" << endl;
    }
    print_cur_cond(cond);
}

bool init() {
    file_task >> n;
    if (n == 0) {
        cerr << "First argument is number of tape or it is incorrect file with MT" << endl;
        return 0;
    }
    tapes.resize(n, vector<char>(SIZE_TAPE, '_'));
    tape_positions.resize(n, SIZE_TAPE / 2);
    tape_gran.resize(n, std::make_pair(SIZE_TAPE / 2, SIZE_TAPE / 2 + 1));
    return 1;
}

int main(int argc, char* argv[]) {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    if (argc > 1) {
        if (argc < 3) {
            cerr << "Not enough argumetns" << endl;
            return 1;
        }
        input.open(argv[1]);
        file_task.open(argv[2]);
        if (argc >= 4) {
            delay_time = std::stoi(argv[3]);
        }
        if (argc >= 5) {
            if (std::stoi(argv[4]) == 0) flag = false; 
        }
        if (argc >= 6) {
            if (std::stoi(argv[5])) full = true;
        }
    } else {
        input.open("input.txt");
        file_task.open("MT.txt");
    }
    if (!init()) return 1;
    write_input();
    parse_MT();
    run();
    cout << "Total steps: " << steps << endl;
    return 0;
}