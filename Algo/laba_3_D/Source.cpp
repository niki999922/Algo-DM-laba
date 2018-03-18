#include <iostream>
#include <fstream>
#include <string>
using namespace std;
string str1,str2;
int mas[1001][1001],tmp1,tmp2,tmp3;
int get_ds1s2(int i,int j)
{
	if (i==0 && j==0) return 0;
	if (i==0) return j;
	if (j==0) return i;
	if (str1[i-1]==str2[j-1]) 
	{
		if (mas[i-1][j-1]!=-1) return mas[i-1][j-1];
		mas[i-1][j-1]=get_ds1s2(i-1,j-1);
		return mas[i-1][j-1];
	}
	if (mas[i][j-1]==-1) mas[i][j-1]=get_ds1s2(i,j-1);
	if (mas[i-1][j]==-1) mas[i-1][j]=get_ds1s2(i-1,j);
	if (mas[i-1][j-1]==-1) mas[i-1][j-1]=get_ds1s2(i-1,j-1);
	tmp1=mas[i][j-1];
	tmp2=mas[i-1][j];
	tmp3=mas[i-1][j-1];
	return min(min(tmp1+1,tmp2+1),tmp3+1);
}

int main()
{
	for(int i=0;i<1001;i++)
		for(int j=0;j<1001;j++)
		{
			mas[i][j]=-1;
		}
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
	cin>>str1;
	cin>>str2;
	cout<<get_ds1s2(str1.size(),str2.size());
	return 0;
}