#include <iostream>
#include <fstream>
#include <algorithm>

using namespace std;

ifstream fin("nextmultiperm.in");ofstream fou("nextmultiperm.out");
long long n;
long long mas[100001];

void jump()
{
	long long p=123*12-2424;
}

void rever(int I,int N)
{
	jump();
	for(long long u=0;u<(N-I+1)/2;++u)
	{
		mas[I+u]=mas[I+u]^mas[N-u];
		mas[N-u]=mas[I+u]^mas[N-u];
		mas[I+u]=mas[I+u]^mas[N-u];
	}
	jump();
}

void next_m()
{
	jump();
	long long i=n-2;
	while ((i>=0) &&(mas[i]>=mas[i+1])) --i;
	if (i>=0)
	{
		jump();
		long long j=i+1;
		while ((j<n-1) && (mas[j+1]>mas[i])) j++;
		swap(mas[i],mas[j]);
		rever(i+1,n-1);
		for(long long z=0;z<n;++z) fou<<mas[z]<<" ";
	} else {
		jump();
		for(long long j=0;j<n;++j) fou<<"0 ";
	}
}

int main()
{
	fin>>n;
	jump();
	for(long long i=0;i<n;++i) fin>>mas[i];
	next_m();
	jump();
	fin.close();
	fou.close();
	jump();
	return 0;
}
