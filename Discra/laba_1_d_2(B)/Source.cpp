#include <iostream>
using namespace std;

int n,k,c,num,it;
int mas[200][200],col[200],v[200];

int main()
{
	cin>>n>>k;	
	for(int j=0;j<n;j++) v[j]=-1;
	for(int i=0;i<k;i++) 
		for(int j=0;j<n;j++) 
		{
			cin>>mas[i][j];
			if (mas[i][j]!=-1) col[i]++;
		}
	for(int i=0;i<k;i++) if (col[i]!=0) c++;
	if (c!=k) {cout<<"YES"; return 0;}
	while(c>0)
	{
		num=-1;
		for(int i=0;i<k;i++)
		{
			if (col[i]==1) 
			{
				num=i;
				break;
			}
		}
		if (num==-1) {cout<<"NO"; return 0;}
		for(int i=0;i<n;i++)
		{
			if (mas[num][i]!=-1)
			{
				it=i;
				if (mas[num][i]==1)
				{
					v[i]=1;
				} else {
					v[i]=0;
				}
				break;
			}
		}
		for(int i=0;i<k;i++)
		{
			if (col[i]!=0)
			{
				if (mas[i][it]==-1) continue;
				if ((v[it]==1) && (mas[i][it]==1) || (v[it]==0) && (mas[i][it]==0))
				{
					col[i]=0;
					--c;
				} else {
					if (col[i]==1) {cout<<"YES"; return 0;}
					--col[i];
					mas[i][it]=-1;
				}				
			}
		}
	}
	cout<<"NO";
	return 0;
}


/*
3 3
1 0 -1
0 1 0
-1 0 1
NO

3 3
0 0 0
-1 -1 1
-1 1 -1
NO


1 2
1
0
YES
*/