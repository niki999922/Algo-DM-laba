#include <iostream>
#include <fstream>


using namespace std;

ifstream fin("nextchoose.in");
ofstream fou("nextchoose.out");

int n,k;
int mas[10003];
int main()
{
	fin>>n>>k;
	int ch=n+1,wf=0;
	for(int i=1;i<=k;i++) fin>>mas[i];
	for(int i=k;i>0;--i)
	{
		if (mas[i]+1<ch)
		{
			mas[i]+=1;
			ch=mas[i];
			for(int j=1;j<=k-i;j++)
			{
				mas[i+j]=ch+1;
				++ch;
			}
			wf=1;
			break;
		}
		ch=mas[i];
	}
	if (wf==0) {fou<<"-1";return 0;}
	for(int i=1;i<=k;i++) fou<<mas[i]<<" ";
	fin.close();
	fou.close();
	return 0;
}