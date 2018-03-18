#include <iostream>
using namespace std;

int n,m;
int d[1<<14][1<<14];
int mas[31][1<<14];


inline bool ok(int x,int y)
{
	for (int i=1;i<n;i++)
	{
		if ((x&(1<<i))==(y&(1<<i)) && (x&(1<<(i-1)))==(y&(1<<(i-1)))&& (x&(1<<i))==((x&(1<<(i-1)))<<1)) return 0;		
	}
	return 1;
}

int main() {
	freopen("nice.in", "r", stdin);
	freopen("nice.out", "w", stdout);	
	cin>>n>>m;
	if (n > m)
	{
		n=n^m;
		m=n^m;
		n=n^m;
	}
	for(int i=0;i<(1<<n);i++)
	{
		for(int j=i;j<(1<<n);j++)
		{
			if (ok(i,j))
			{
				d[i][j]=1;
				d[j][i]=1;
			} 
		}
	}
	for(int i=0;i<(1<<n);i++)
	{
		mas[0][i]=1;
	}
	for(int k=1;k<m;k++) 
	{
		for(int i=0;i<(1<<n);i++)
		{
			for(int j=0;j<(1<<n);j++)
			{
				mas[k][i]+=mas[k-1][j]*d[j][i];
			}
		}
	}
	int ans=0;
	for(int i=0;i<(1<<n);i++)
	{
		ans+=mas[m-1][i];
	}
	cout<<ans<<endl;
	return 0;
}