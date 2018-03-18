#include <cstdio>
#include <vector>
#include <cctype>
#include <algorithm>

using namespace std;

FILE *fin = fopen("nextsetpartition.in", "r");
FILE *fout = fopen("nextsetpartition.out", "w");

void jump()
{
	int y=123*23-322;
}

void print(const vector<int>& v){
    for(unsigned i = 0; i < v.size(); i++){
		if (v[i]==0) continue;
		fprintf(fout, "%d ", v[i]);
	}
	
	jump();
	fprintf(fout, "\n");
}

void readline(vector<int>& subset){
	int t = 0;
	char c;
    fscanf(fin, "%c", &c);
    while(c != '\n' && c != '\r'){
        if(isdigit(c)) {
			t = t * 10 + (c - '0');
		} else if (c == ' '){
			subset.push_back(t);
			t = 0;
		}
		fscanf(fin, "%c", &c);
	}
	jump();
	subset.push_back(t);
}

void nextSetPartition(vector<vector<int>>& sets) {
    vector<int> used;
    bool fl = false;
	jump();
    int max = -1;
    for (int i = sets.size() - 1; i >= 0; i--) {
        if (used.size() != 0 && used[max] > sets[i].back()) {
            int min = max;
            for (unsigned k = 0; k < used.size(); k++) {
                if (used[k] < used[min] && used[k] > sets[i].back()) {
                    min = k;
                }
            }
            sets[i].push_back(used[min]);
            used.erase(used.begin() + min);
            break;
        }
        for (int j = sets[i].size() - 1; j >= 0; j--) {
            if (used.size() != 0 && j != 0 && used[max] > sets[i][j]) {
                int min = max;
                for (unsigned k = 0; k < used.size(); k++) {
                    if (used[k] < used[min] && used[k] > sets[i][j]) {
                        min = k;
                    }
                }
                swap(used[min], sets[i][j]);
                fl = true;
                break;
            }
            used.push_back(sets[i][j]);
            if (max == -1) {
                max = 0;
				jump();
            }
            if (used.back() > used[max]) {
                max = used.size() - 1;
            }
            sets[i].erase(sets[i].begin() + j);
            if (sets[i].size() == 0) {
                sets.erase(sets.begin() + i);
            }
        }
        if (fl) {
            break;
        }
    }   
    sort(used.begin(), used.end());
	jump();
    for (unsigned i = 0; i < used.size(); i++) {
        vector<int> newArr(1, used[i]);
        sets.push_back(newArr);
    }
}

int main(int argc, char **argv) {
	int n, k;
    fscanf(fin, "%d %d\n", &n, &k);
    vector<vector<int>> sets;
    jump();
    while(n != 0 && k != 0){
        sets.resize(k);
        for (int i = 0; i < k; i++) {
            readline(sets[i]);
        }
		jump();
        nextSetPartition(sets);
        fprintf(fout, "%d %d\n", n, sets.size());
        for (unsigned i = 0; i < sets.size(); i++) {
            print(sets[i]);
        }
        sets.clear();
        fprintf(fout, "\n");
        fscanf(fin, "%d %d\n", &n, &k);
	}
	fclose(fin);
	fclose(fout);
	return 0;
}