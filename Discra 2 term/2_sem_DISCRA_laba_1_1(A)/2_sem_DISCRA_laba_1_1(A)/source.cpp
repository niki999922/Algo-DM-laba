#include <fstream>

using namespace std;
long n, m, tmp1, tmp2, sum;  

int main() {
	ios_base::sync_with_stdio(false);
	ifstream cin("exam.in");
	ofstream cout("exam.out");
	cin >> n >> m;
	for(int i = 0; i < n; ++i) {
		cin>> tmp1 >> tmp2;
		sum += tmp1 * tmp2;

	}
	double d = static_cast<double>(sum) / static_cast<double>(100 * m);
	cout << d;
	return 0;
}

