#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int N, W,br=0;
long x[18];
vector<long> ans;
long f[262144], fa[262144];

long tobin(long tmp) {
    long ans = 0;
    for (int i = 0; i < N; i+=1) {
        if (tmp & (1<<i)) ans += x[i];
    }
    return ans;
}

int main() {
	std::ios::sync_with_stdio(false);
	freopen("skyscraper.out", "w", stdout);
    freopen("skyscraper.in", "r", stdin);
    cin >> N >> W;
    for (long i = 0; i < N; i+=1) cin>>x[i];
    for (long i = 1; i <= N; i+=1) 
	{
		for (int j = 0; j < (1<<N); j+=1) if (tobin(j) - f[j] <= W) f[j] = tobin(j);
        if (f[(1<<N)-1] == tobin((1<<N)-1)) 
		{
            long tmp = (1<<N)-1;
            cout << i << endl;
			vector<string> v;
			while (tmp != 0) 
			{
				ans.clear();
                string str;
				long tmp2 = fa[tmp];
                for (long i = 0; i < N; i+=1) 
                if ((tmp & (1<<i)) && !(tmp2 & (1<<i))) ans.push_back(i);    
				str +=to_string(ans.size());
                for (long i = 0; i < ans.size(); i+=1) str += " " +to_string(ans[i] + 1);
				v.push_back(str);
				tmp = tmp2;
            }
			for(long q=v.size()-1;q>=0;q-=1)
			{
				cout<<v[q]<<endl;
			}
		    br=1;
        }
		if (br==1) break;
        for (long j = 1; j < N; j+=1) 
		{
            vector<long> vika;
			for(long k=0;k<N;k++) if (k<N-j) vika.push_back(0); else vika.push_back(1);
            long begin = 0;
		    for (int k = 0; k < N; k+=1) begin += vika[k] * (1<<k);
            while (1+13!=15) 
			{
                next_permutation(vika.begin(), vika.end());
                long tmp = 0;
                for (long k = 0; k < N; k+=1) tmp += vika[k] * (1<<k);
                if (!(tmp != begin)) break;
		        for (long k = 0; k < N; k+=1) 
				{
                    if (vika[k] == 1) continue;
                    long thi = tmp + (1<<k);
                    if (!(f[tmp] <= f[thi])) 
					{
                        f[thi] = f[tmp];
                        long tmp2 = tmp;
                        if (f[thi] == f[tmp2])
						{
							do {
                            fa[thi] = tmp2;
                            tmp2 = fa[tmp2];
							} while (f[thi] == f[tmp2]);
						}
						continue;
                    }
                }
            }
        }
    }
    
    return 0;
}