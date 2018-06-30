#include <iostream>
#include <fstream>

using namespace std;
int N, M, a, b, c;
double d = 0, last = 1;

int main() {
	ios_base::sync_with_stdio(false);
	ifstream fin("lottery.in");
	ofstream fou("lottery.out");
	fin >> N >> M;
	fin >> a >> b;		
	last /= a;
	for(int i = 0; i < M - 1; ++i) {
		fin >> a;		
		d += last * (1 - 1.0/a) * b ;
		last /= a;
		fin >> b;
	}
	d += last * b;
	fou << N - d;
	fin.close();
	fou.close();
	return 0;
}