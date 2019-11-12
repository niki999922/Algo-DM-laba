#include <iostream>
#include <fstream>
#include <string>
#include <stack>


using namespace std;

ifstream fin("brackets2num2.in");
ofstream fou("brackets2num2.out");

string str;
long long mas[40][21],n,m=0;

void do_tabl_blat()
{
	mas[0][0]=1;
	for(long long i=1;i<n*2;++i)
	{
		for(long long j=0;j<=n;j++)
		{
			if (j-1>=0) mas[i][j]+=mas[i-1][j-1];
			if (j+1<=n) mas[i][j]+=mas[i-1][j+1];
		}
	}
}

long long num_dai_blat()
{
	stack<char> sten;
	long long d=0,etap=0;
	for (long long i=n*2-1;i>=0;--i) 
	{
		long long tmp=0;
		if (str[n*2-1-i]=='(')  {
			sten.push('(');
			++d;
			continue;
		}

		if (str[n*2-1-i]==')')  {
			if (d+1<=n) tmp=mas[i][d+1]<<((i-d-1)/2); else tmp=0;
			m+=tmp;
			sten.pop();
			--d;
			continue;
		}

		if (str[n*2-1-i]=='[')  {
			if (d+1<=n) tmp=mas[i][d+1]<<((i-d-1)/2); else tmp=0;
			m+=tmp;
			if (d-1>=0) tmp=mas[i][d-1]<<((i-d+1)/2); else tmp=0;
			if (sten.size()>0) if (sten.top()=='[') tmp=0;
			m+=tmp;
			sten.push('[');
			++d;
			continue;
		}

		if (str[n*2-1-i]==']')  {
			if (d+1<=n) tmp=mas[i][d+1]<<((i-d-1)/2); else tmp=0;
			m+=tmp;
			m+=tmp;
			if (d-1>=0) tmp=mas[i][d-1]<<((i-d+1)/2); else tmp=0;
			if (sten.size()>0) if (sten.top()=='[') tmp=0;
			m+=tmp;
			sten.pop();
			--d;
			continue;
		}
	}
	return m;
}

int main()	
{
	fin>>str;
	n=str.size()/2;
	do_tabl_blat();
	fou<<num_dai_blat();
	fin.close();
	fou.close();
	return 0;		
}
