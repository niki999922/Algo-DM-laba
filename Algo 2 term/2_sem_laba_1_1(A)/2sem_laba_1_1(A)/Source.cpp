#include <iostream>
#include <fstream>

using namespace std;

const long long p16 = 1 << 16;
const long long p30 = 1 << 30;

long long mas_pref[10000001],mas_a[10000000],mas_c[10000000];

int main()
{
	ios_base::sync_with_stdio(false);
	ifstream cin("sum0.in");
	ofstream cout("sum0.out");
	long long x,y,n;
	cin>>n>>x>>y>>mas_a[0];
	for(long long i=1;i<n;++i)
	{
		mas_a[i]=(x*mas_a[i-1] + y) % p16;
		mas_pref[i]=mas_pref[i-1]+mas_a[i-1];
	}
	mas_pref[n]=mas_pref[n-1]+mas_a[n-1];
	long long m,z,t,last;
	cin>>m>>z>>t>>last;
	mas_c[0]=last%n;
	for(long long i=1;i<2*m;++i)
	{
		last=(z*last+t)%p30;
		if (last<0)
		{
			last+=p30;
		}
		mas_c[i]=last%n;
		if (mas_c[i]<0)
		{
			mas_c[i]+=n;
		}
	}
	long long sum=0;
	for(long long i=0;i<2*m;i+=2)
	{
		sum+=mas_pref[max(mas_c[i],mas_c[i+1])+1] - mas_pref[min(mas_c[i],mas_c[i+1])];
	}
	cout<<sum<<endl;
	return 0;
}
