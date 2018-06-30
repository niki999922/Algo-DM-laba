#include <fstream>
#include <vector>
 
using namespace std;
int n, flag = 1;
long double previus = 0;
 
int main()
{
    ifstream fin("markchain.in");
    ofstream fou("markchain.out");
    fin >> n;
    float temp;
    vector< vector<long double> > matrica;
    matrica.resize(n);
    for (int i = 0; i < n; ++i) {
        matrica[i].resize(n);
        for (int j = 0; j < n; ++j)
            fin >> matrica[i][j];
    }
    matrica;
    for (int counter = 0; counter < 15; ++counter) {
		vector< vector<long double> > rez(n, vector<long double>(n, 0));
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                for (int z = 0; z < n; ++z)
                    rez[i][j] += matrica[i][z] * matrica[z][j];
            }
        matrica = rez;
    }   
	
    for (int i = 0; i < n; ++i) {
		long double answer = 0;
		for (int j = 0; j < n; ++j)
			answer += matrica[j][i];
		answer /= n;
		fou << answer << '\n';
	}
    fin.close();
    fou.close();
    return 0;
}