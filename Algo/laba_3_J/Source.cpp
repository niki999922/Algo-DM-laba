#ifndef TEST
#include <iostream>
#include <vector>

using namespace std;
int n;
int mas[13][13];
int d[13][13][8192];
int X,Y;

inline void readmas()
{
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			cin>>mas[i][j];
		}
	}
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;++j)
		{		
			for(int z=0;z<(1<<n);++z)
			{
				d[i][j][z]=-1;
			}
		}
	}
}

inline long long del_from_bin(long long x,long long y)
{
	for(int i=0;i<n;i++)
	{
		if (i==y) {x=x-(1<<i);break;}
	}
	return x;
}

int go(int x,int y,int can_way)
{
	if (can_way==0)
	{
		d[x][y][can_way]=mas[x][y];
		return mas[x][y];
	}
	if (d[x][y][can_way]!=-1) return d[x][y][can_way];
	int mini=100000000;
	for(int i=0;i<n;i++)
	{
		if (can_way&(1<<i))
		{
			int t=del_from_bin(can_way,i);
			mini=min(mini,mas[x][i]+go(i,y,t));
		} 
	}
	d[x][y][can_way]=mini;
	return mini;
}

void emulation(int x,int y,int can_way,int mix)
{
	if (can_way==0)
	{
		cout<<y+1<<" ";
	}
	for(int i=0;i<n;i++)
	{
		if (can_way&(1<<i))
		{
			int t=del_from_bin(can_way,i);
			if (mix-mas[x][i]==d[i][y][t])
			{
				cout<<i+1<<" ";
				emulation(i,y,t,d[i][y][t]);
				break;
				//cout<<i+1<<" ";
			}
		} 
	}
}

int main()
{
	//freopen("input.txt","r",stdin);
	cin>>n;
	if (n==1) 
	{
		cout<<0<<endl<<1;
		return 0;
	}
	readmas();
	int q=100000000;
	int tmp=(1<<n)-1;
	for(int i=0;i<n-1;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			int tmp_1=del_from_bin(tmp,i);
			tmp_1=del_from_bin(tmp_1,j);
			int qt=go(i,j,tmp_1);
			if (qt<q)
			{
				q=qt;
				X=i;
				Y=j;
			}
		}
	}
	cout<<q<<endl;
	int tmp_1=del_from_bin(tmp,X);
	tmp_1=del_from_bin(tmp_1,Y);
	cout<<X+1<<" ";
	emulation(X,Y,tmp_1,q);
	return 0;
}
#endif

#ifdef TEST
#include <iostream>
#include <vector>

using namespace std;
int n;
int mas[13][13];
int d[13];
int sx;
int Minway=100000000;
vector<vector<int>> tru_way(13);

inline void readmas()
{
	cin>>n;
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			cin>>mas[i][j];
		}
	}
	for(int i=0;i<13;i++)
		d[i]=100000000;

}

void go(int x,int hw,int sum,vector<int> v_t,vector<int> www)
{
	if (hw==n)
	{
		if (sum< d[sx])
		{
			d[sx]=sum;
		} else return;
		tru_way[sx]=www;
		Minway=sum;
		return;
	}
	if (sum>Minway) return;
	for(int i=0;i<n;i++)
	{
		if (v_t[i]==1) continue;
		vector<int> vm=v_t;
		vector<int> wwwt=www;
		vm[i]=1;
		wwwt.push_back(i);
		go(i,hw+1,sum+mas[x][i],vm,wwwt);
	}

}

int main()
{
	//freopen("input.txt","r",stdin);
	readmas();
	int t_mas[13][13];
	for(int i=0;i<n;i++)
	{
		vector<int> www;
		www.push_back(i);
		vector<int> v(10);
		v[i]=1;
		sx=i;
		Minway=100000000;
		go(i,1,0,v,www);
	}
	int k=0;
	for(int i=1;i<n;i++)
		if (d[i]<d[k]) k=i;
	cout<<d[k]<<endl;
	for(int i=n-1;i>=0;i--)
	{
		cout<<tru_way[k][i]+1<<" ";
	}
	return 0;
}
#endif
