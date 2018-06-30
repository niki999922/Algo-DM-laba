#include <iostream>
#include <fstream>
#include <cmath>

using namespace std;
int m, n, k;
double d1, d2, tmp;

int main() {
	d1 = d2 = 0;
	ios_base::sync_with_stdio(false);
	ifstream fin("shooter.in");
	ofstream fou("shooter.out");
	fou.precision(15);
	fin>> n >> m >> k;
	for(int i = 0; i < n; ++i) {
		fin >> tmp;
		if ( i == k - 1) {
			d1 = pow(1 - tmp, m);
		}
		d2 += pow(1 - tmp, m);
	}
	fou << d1 / d2;
	fin.close();
	fou.close();
	return 0;
}