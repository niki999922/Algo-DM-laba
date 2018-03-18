//#define FIRST_MISSING
#ifdef FIRST_MISSING
#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
#include <string>
//#define RE
//#define FIRST_VERSION
using namespace std;

#ifdef FIRST_VERSION


#define MAS mas_tupix_pair
#define GO_BBB what_we_need_write
#define SWAP swap_with_who_last

vector<vector<int>> v; 

#ifndef RE
int mass[33333][15];
int mastmp[15];
int k=0;
#define mas mastmp
#endif
#ifdef RE
short mas[15];
pair<short,short> MAS[100000];
#endif // !RE

int n,N,q,GO_BBB;
int go_down=0,m_go;
#ifdef RE
void prov(int g)
{
	if (g==n-1)
	{
		if(GO_BBB==1) return;
		short b1,b2;
		for(int i=0;i<q;i++)
		{
			if (MAS[i].first<0) b1= !mas[abs(MAS[i].first)-1]; else  b1=mas[MAS[i].first-1];
			if (MAS[i].second<0) b2= !mas[abs(MAS[i].second)-1]; else  b2=mas[MAS[i].second-1];
			if ((b1|b2) == 0)
			{
				m_go=max(abs(MAS[i].first)-1,abs(MAS[i].second)-1);
				go_down=1;
				return;
			}
		}
		GO_BBB=1;
		return;
	}
	if (GO_BBB==1) return;
	if ((g-1!=m_go) &&(go_down==1)) return; else go_down=0;
	mas[g+1]=0;
	prov(g+1);
	if ((g-1!=m_go) &&(go_down==1)) return; else go_down=0;
	mas[g+1]=1;
	prov(g+1);
}
#endif

#ifndef RE
void swap(int a1, int a2)
{
	for(int i=0;i<n;i++)
	{
		int tmp=mass[a1][i];
		mass[a1][i]=mass[a2][i];
		mass[a2][i]=tmp;
	}
}

void prov(int g)
{
	if (g==n-1)
	{
		for(int i=0;i<n;i++)
		{
			mass[k][i]=mas[i];
		}
		k++;
		return;
	}
	mas[g+1]=0;
	prov(g+1);
	mas[g+1]=1;
	prov(g+1);
}
#endif

#endif

#ifndef FIRST_VERSION
int n,k,a,b,N,tmp1,tmp2,a1,b1;
string mas[40000];

void bool_table(int left,int right,int g)
{
	if (g==n) return;
	for(int i=left;i<(right+left)/2;i++)
	{
	//	mas[i]+="0";
	}
	for(int i=(right+left)/2;i<right;i++)
	{
	//	mas[i]+="1";
	}
	bool_table(left,(right+left)/2,g+1);
	bool_table((right+left)/2,right,g+1);
}

int toInt(char c)
{
	if (c == '1') return 1; else return 0;
}

#endif
int main()
{

#ifdef FIRST_VERSION
	cin>>n>>q;
	/*for(int i=0;i<q;i++)
	{
	cin>>MAS[i].first>>MAS[i].second;
	}*/
#ifdef RE
	GO_BBB=0;
	prov(-1);
	if (GO_BBB==1) cout<<"NO"<<endl; else cout<<"YES"<<endl;
#endif

#ifndef RE
	prov(-1);
	N=static_cast<int>(pow(2,n));
	int SWAP=N-1;
	int first,second;
	for(int i=0;i<q;i++)
	{
		cin>>first>>second;
		if (N>0) 
		{
			for(int j=0;j<N;j++) 
			{
				short b1,b2;
				if (first<0) b1= !(mass[j][abs(first)-1]); else  b1=(mass[j][first-1]);
				if (second<0) b2= !(mass[j][abs(second)-1]); else  b2=(mass[j][second-1]);
				if ((b1|b2) == 0)
				{
					swap(j,N-1);
					j--;
					N--;
				}
			}
		}
	}
	if (N>0) cout<<"NO"<<endl; else cout<<"YES"<<endl;
#endif
#endif
#ifndef FIRST_VERSION
	cin>>n>>k;
	N=static_cast<int>(pow(2,n));
	bool_table(0,N,0);
	for(int i=0;i<k;++i)
	{
		cin>>a>>b;
		a1=abs(a)-1;
		b1=abs(b)-1;
		if (N>0) 
		{
			for(int j=0;j<N;++j)
			{
				if (a<0) {
					tmp1=1-toInt(mas[j][a1]);
				} else {
					tmp1=toInt(mas[j][a1]);
				}
				if (b<0) {
					tmp2=1-toInt(mas[j][b1]);
				} else {
					tmp2=toInt(mas[j][b1]);
				}
				if ((tmp1|tmp2) == 0)
				{
					swap(mas[j],mas[N-1]);
					--j;
					--N;
				}
			}
		} else break;
	}
	if (N>0) cout<<"NO"; else cout<<"YES";
#endif

	return 0;
}
#endif

#ifndef FIRST_MISSING
#include<iostream>
using namespace std;

int n,q,a,b,/*k,*/c,/*col,*/t1,t2,p;
int mas[50][50];
//int masH[50][50];
int visited[50];
//int time[500],component[500];

//bool beincomv(int v);

void dfs1(int v)
{
	if (v==p) 
	{
		t1=1; 
		return;
	}
	visited[v]=1;
	for(int i=0;i<n;i++)
	{
		if ((mas[v][i]==1) && (visited[i]!=1)) dfs1(i);
	}
}

void dfs2(int v)
{
	if (v==p) 
	{
		t2=1;
		return;
	}
	visited[v]=1;
	for(int i=0;i<n;i++)
	{
		if ((mas[v][i]==1) && (visited[i]!=1)) dfs2(i);
	}
}
/*
void dfs2 (int v) {
	visited[v] = true;
	component[col]=v;
	++col;
	for (int i=0; i<n; ++i)
		if ((beincomv(i)) && (masH[v][i]==1))
			dfs2 (i);
}
*/
/*
bool beincomv(int v)
{
	for(int i=0;i<col;i++)
	{
		if (component[i]==v) return false;
	}
	return true;
}
*/

int main()
{
	cin>>n>>q;
	n=2*n;
	for(int i=0;i<n;i++) 
		for(int j=0;j<n;j++)
		{
			mas[i][j]=0;
	//		masH[i][j]=0;
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
	/*for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
		{
			if (mas[i][j]==1)
				masH[j][i]=1;
			
		}
	*/
	//for(int j=0;j<50;j++) visited[j]=0;
	//k=0;
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
	//for(int j=0;j<50;j++) visited[j]=0;
	
	
//	for (int i=0; i<n; ++i) {
//		c=0;
//		int v = time[n-1-i];
//		if (!visited[v]) {
//			dfs2 (v);
//			for(int j=0;j<c;j++)
//			{
//				//if component[j]
//			}
//		}
//	}
//	
//	 col = 1
//       for (по всем вершинам u списка ord[] в обратном порядке)                                                        
//           if (вершина u не находится ни в какой компоненте)
//               dfs2(u)
//               col++
	/*col=0;
	for(int i=k-1;i>=0;--i)
	{
		int v = time[i];
		if (beincomv(v))
		{
			dfs2(v);
			col++;
		}
	}
	*/
	/*
	for(int i=0;i<col-1;i++)
	{
		for(int j=i+1;j<col;++j)
		{
			if(j-i-n/2==0) if (component[j]==component[i]) { cout<<"NO"; return 0;}	

		}
	}
	*/
	cout<<"NO";
	return 0;
}

/**
*            2 3
*            -1 2
*            -2 -2
*            2 -1
NO




2 4
-1 2
-2 -2
2 -1
1 1YES
*/

#endif