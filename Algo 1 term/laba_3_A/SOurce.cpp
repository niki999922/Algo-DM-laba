#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N,K;
int mas[10001],d[10001],p[10001];
vector<int> vec;

void help_d()
{
	for (int i=2;i<=N;++i){
		int num_max = i - 1;
		for(int j=max(1,i-K);j<i;++j)
			if (d[j]>d[num_max]) {
				num_max=j;
			}
		d[i] = d[num_max]+mas[i]; 
		p[i] = num_max;
	}
}

void help_way()
{
	int tmp=N;
	vec.push_back(tmp);
	while (tmp>1)
	{
	tmp=p[tmp];
	vec.push_back(tmp);
	}
}
int main()
{
    freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
	cin>>N>>K;
	for(int i=2;i<N;i++) cin>>mas[i];
	help_d();
	cout<<d[N]<<endl;
	help_way();
	cout<<vec.size()-1<<endl;
	for(int i=vec.size()-1;i>=0;i-=1) cout<<vec[i]<<" ";
	return 0;
}