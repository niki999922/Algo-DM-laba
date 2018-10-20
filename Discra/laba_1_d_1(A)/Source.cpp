#include<iostream>
using namespace std;

int n, q, a, b, c, t1, t2, p;
int mas[50][50];
int visited[50];

void dfs1(int v)
{
	if (v == p) 
	{
		t1 = 1; 
		return;
	}
	visited[v]=1;
	for(int i = 0; i < n; ++i)
	{
		if ((mas[v][i] == 1) && (visited[i] != 1)) dfs1(i);
	}
}

void dfs2(int v)
{
	if (v == p) 
	{
		t2 = 1;
		return;
	}
	visited[v] = 1;
	for(int i = 0; i < n; ++i)
	{
		if ((mas[v][i] == 1) && (visited[i] != 1)) dfs2(i);
	}
}

int main()
{
	cin>>n>>q;
	n = 2 * n;
	for(int i = 0; i < n; ++i) 
		for(int j = 0; j < n; j++)
		{
			mas[i][j]=0;
		}
	for(int i=0;i<q;i++)
	{
		cin>>a>>b;
		if ((a>0) && (b>0)) 
		{
			mas[n/2+(a-1)][(b-1)]=1;
			mas[n/2+(b-1)][(a-1)]=1;
		} 
		if ((a<0) && (b>0)) 
		{
			mas[abs(a)-1][(b-1)]=1;
			mas[n/2+(b-1)][n/2+abs(a)-1]=1;
		} 
		if ((a>0) && (b<0)) 
		{
			mas[n/2+(a-1)][n/2+abs(b)-1]=1;
			mas[abs(b)-1][a-1]=1;
		} 
		if ((a<0) && (b<0)) 
		{
			mas[abs(a)-1][n/2+abs(b)-1]=1;
			mas[abs(b)-1][n/2+abs(a)-1]=1;
		} 
	}
	for (int i=0; i<n/2; ++i)
	{
		t1=0;
		t2=0;
		for(int j=0;j<50;j++) visited[j]=0;
		p=i+n/2;
		dfs1(i);
		for(int j=0;j<50;j++) visited[j]=0;
		p=i;
		dfs2(i+n/2);
		if ((t1==1) && (t2==1)) {cout<<"YES"; return 0;}
	}
	cout<<"NO";
	return 0;
}

/**
2 3
-1 2
-2 -2
2 -1
NO


2 4
-1 2
-2 -2
2 -1
1 1
YES
*/