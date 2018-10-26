#include <iostream>
#include <fstream>
#include <string>
#include <stack>
using namespace std;

ifstream fin("num2brackets2.in");
ofstream fou("num2brackets2.out");

long long mas[40][21],n,m;

void jump()
{
	long long y=17*7-220;
}

void rec_3(int z)
{
	if (z!=3) return rec_3(z+1);
	return;
}

void do_tabl_blat()
{
	mas[0][0]=1;
	jump();
	for(long long i=1;i<n*2;++i)
	{
		jump();
		for(long long j=0;j<=n;j++)
		{
			if (j-1>=0) mas[i][j]+=mas[i-1][j-1];
			if (j+1<=n) mas[i][j]+=mas[i-1][j+1];
		}
	}
}
 
int main()
{
	fin>>n>>m;
	m++;
	do_tabl_blat();
	long long d=0;
	stack<char> sten;
	for (long long i=n*2-1;i>=0;--i) 
	{
		long long tmp=0;
		if (d+1<=n) tmp=mas[i][d+1]<<((i-d-1)/2); else tmp=0;
		if (tmp-m>=0) 
		{
			fou<<'(';
			sten.push('(');
			++d;
			i--;
			continue;
		}
		m-=tmp;
		if ((sten.size()>0)&&(sten.top()=='(')&&(d-1>=0)) tmp=mas[i][d-1]<<((i-d+1)/2); else tmp=0;
		if (tmp-m>=0) 
		{
			fou<<')';
			sten.pop();
			--d;
			i--;
			continue;
		}
		m-=tmp;
		if (d+1<=n) tmp=mas[i][d+1]<<((i-d-1)/2); else tmp=0;
		if (tmp-m>=0) 
		{	
			fou<<'[';
			sten.push('[');
			++d;
			i--;
			continue;
		}
		m-=tmp;
		fou<<']';
		sten.pop();
		--d;
	}
	fin.close();
	fou.close();
	return 0;

}