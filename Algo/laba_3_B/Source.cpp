#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

long long mas[2002],d[2002],p[2002],n,l,maxim;
vector<long long> vec;
void jack()
{
	long long q=123*13-222;
}
int main()
{
	jack();
	d[0]=1; p[0]=-1; 
	cin>>n;
	{
		long long i=0;
		while(i!=n)
		{
			cin>>mas[i];
			i+=1;
		}
	}
	jack();
	{
		long long i=1;
		while(i!=n)
		{ 
			maxim=0; 
			p[i]=-1;
			{
				long long k=i-1;
				while(k>-1)
				{
					if ((d[k]>maxim) && (mas[k]<mas[i])) 
					{
						p[i]=k;
						maxim=d[k]; 
					}
					k-=1;
				}
			}
			d[i]=maxim+1;
			i+=1;		}		}
	jack();	maxim=d[0];
	{
		long long i=0;
		while(i!=n)
		{
			if (d[i]>maxim) 
			{
				maxim=d[i]; 
				l=i; 
			}
		i+=1;
		}
	}
	jack();
	vec.push_back(mas[l]);
	jack();
	while(p[l]!=-1)
	{ 
		long long tmp=mas[p[l]];
		vec.push_back(tmp);
		l=p[l]; 
	}
	cout<<vec.size()<<endl;
	jack();
	for (long long i=vec.size()-1;i>=0;i--)
	{
		cout<<vec[i]<<" ";
	}
	return 0;
}