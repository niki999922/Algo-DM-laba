#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int n,mas[101],d[101][101];
int k1,k2;
vector<int> vec;
//vector<pair<vector<int>,int>> roadmi;
vector<int> puti[100];

inline void rec_do(int i,int j,int sum,vector<int> tmp_v)
{
	int tmp=d[i][j];
	if (d[i][j]<sum)
	{
		return;
	}
	if (d[i][j]>sum) 
	{
		d[i][j]=sum;
	}
	if (j==n)
	{
		if (tmp>sum) puti[i]=tmp_v;
		return;
	}
	vector<int> v_t=tmp_v;
	if (mas[j+1]==0)
	{
		v_t.push_back(0);
		rec_do(i,j+1,sum,v_t);
		return;
	}
	if (i!=0) 
	{
		v_t.push_back(-1);	
		rec_do(i-1,j+1,d[i][j],v_t);
		if (mas[j+1]>100)
		{
			tmp_v.push_back(1);
			rec_do(i+1,j+1,d[i][j]+mas[j+1],tmp_v);
		} else {	
			tmp_v.push_back(0);
			rec_do(i,j+1,d[i][j]+mas[j+1],tmp_v);
		}
	} else {
		if (mas[j+1]>100)
		{
			v_t.push_back(1);
			rec_do(i+1,j+1,d[i][j]+mas[j+1],v_t);
		} else {
			v_t.push_back(0);
			rec_do(i,j+1,d[i][j]+mas[j+1],v_t);
		}
	}
}

int main()
{
	freopen("nice.in", "r", stdin);
   	//freopen("nice.out", "w", stdout);
	cin>>n;
	if (n==0)
	{
	
		cout<<'0'<<endl<<'0'<<" "<<'0'<<endl;
		return 0;
	}
	for(int i=0;i<101;i++)
		for(int j=0;j<101;j++)
			d[i][j]=30001;
	for(int i=1;i<=n;i++) cin>>mas[i];
	vector<int> q;
	if (mas[1]>100)
	{
		q.push_back(0);
		d[1][1]=mas[1];
		rec_do(1,1,d[1][1],q);
	} else {
		q.push_back(0);
		d[0][1]=mas[1];	
		rec_do(0,1,d[0][1],q);
	}
	
	int mini=1000000000;
	for(int i=0;i<=n;i++)
	{
		if (d[i][n]<mini) {mini=d[i][n]; k1=i;}
	}
	cout<<mini<<endl;
	cout<<k1<<" ";
	for(int j=0;j<puti[k1].size();j++)
	{
		if (puti[k1][j] == -1) k2++;
	}
	cout<<k2<<endl;
	for(int j=0;j<puti[k1].size();j++)
	{
		if (puti[k1][j] == -1) cout<<j+1<<endl;
	}
	return 0;
}