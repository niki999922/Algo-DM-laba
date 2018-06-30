#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>

using namespace std;

const int symbols = 25;
vector<int> term;
vector<int> fr;
vector<int> from_point[100001][30];
long long way[1001][101];

int main()
{
	ios_base::sync_with_stdio(false);
	freopen("problem4.in", "r", stdin);
	freopen("problem4.out", "w", stdout);
	int n, m, k, l, tmp1, tmp2;
	char c;
	cin >> n >> m >> k >> l;
	for (size_t i = 0; i < k; ++i) {
		cin >> tmp1;
		term.push_back(tmp1);
	}
	for (size_t i = 0; i < m; ++i) {
		cin >> tmp1 >> tmp2 >> c;
		from_point[tmp2][c - 'a'].push_back(tmp1);
	}
	way[0][1] = 1;
	for (size_t i = 1; i <= l ; ++i)
		for (size_t j = 1; j <= n; ++j)
			for (size_t p = 0; p <= symbols; ++p) {
				fr = from_point[j][p];
				for (int q = 0; q < (int)fr.size(); q++) {
					way[i][j] += way[i - 1][fr[q]];
				}
				way[i][j] = way[i][j] % 1000000007;
			}
	long long ans = 0;
	for (size_t i = 0; i < term.size(); ++i)
	{
		ans += way[l][term[i]];
		ans = ans % 1000000007;
	}
	cout << ans;
	return 0;
}