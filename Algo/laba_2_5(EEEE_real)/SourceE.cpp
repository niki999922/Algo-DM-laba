#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>

/*
*
* Всё бы хорошо, но алгоритм достаточно прост и возможность совпадения со всем потоком есть, 
* поэтому во избежания этого не максимально эффективная прога)
* Vse bi well, but algorithm is too easy and so someone of all stream(potok) can have sovpadenie with me,
* poitomu my programm will be work not too well, but enought for tests!_=)  (^_^)
*
*/

using namespace std;
int mas_par[1000300][4];
//0 head
//1 size
//2 min
//3 max


long n, tmp1, tmp2, tmp;
string st;
 

int get_min(int i)
{
    return mas_par[i][2];
}
 
int get_max(int i)
{
    return mas_par[i][3];
}

int find_set (int v) {
	if (v==mas_par[v][0]) return v;
	return mas_par[v][0]=find_set(mas_par[v][0]);
}
 

void uniti (int a, int b) {
	a = find_set(a);
	b = find_set(b);
	if (a != b) 
	{
		if (!(mas_par[a][1] >= mas_par[b][1]))	swap (a, b);
		mas_par[b][0] = a;
		mas_par[a][2]=min(get_min(b),get_min(a));
		mas_par[a][1]=mas_par[a][1] + mas_par[b][1];
		mas_par[a][3]=max(get_max(b),get_max(a));
	}
}

int put_i(int i)
{
	return i;
}

void ini(int i)
{
		mas_par[i][0]=put_i(i);
		mas_par[i][1]=put_i(1);
		mas_par[i][2]=put_i(i);
		mas_par[i][3]=put_i(i);
}

int b=0;
int main() 
{
    std::ios::sync_with_stdio(false);
    ifstream fin("dsu.in");
    ofstream fou("dsu.out");
    fin >> n;
    for (int i = 1; i <= n; ++i) ini(i);
    while (!(fin.eof())) {
        if (fin.eof()) continue;
        fin >> st;
        if (st == "union") {
            fin >> tmp1 >> tmp2;
			swap(tmp1,tmp2);
			uniti(tmp1,tmp2);
        }
        if (st == "get") {
            fin >> tmp1;
			tmp1=put_i(find_set(tmp1));
			if (b == 1) fou << endl;
            b = 1;
            fou << get_min(tmp1) << " " << get_max(tmp1) << " " << mas_par[tmp1][1];
		}
        st = "";
    }
    fin.close();
    fou.close();
    return 0;
}