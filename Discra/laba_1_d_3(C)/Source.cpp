#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int Q,n,q,c1,c2,c3,c4,c5,bad,BAD=0;
string s;
int mas[1050];
int mas_k[10000000];

void check_1() //save 0
{
	if (s[0]!='0') c1=1;
}

void check_2() //save 1 
{
	if (s[s.length()-1]!='1') c2=1;
}

void check_3() //samodvoistennaya
{
	for(int i=0;i<n;i++)
	{
		if (s[i] == s[n-i-1]) {c3=1; break;}
	}
}

void check_4()  //monotoona
{
	for(int l=2;l<=n;l=l*2) 
	{
		for(int q=0;q<n;q=q+2*n/l) 
		{
			if (s.substr(q,n/l) > s.substr(q+n/l,n/l)) c4=1;
		}
	}
}

void check_5()
{
	int tmp=0;
	int mas[40];
	for(char c : s) 
	{
		mas[tmp]=int(c=='1');
			++tmp;
	}
	for (int i = 1; i < n; ++i) 
	{
		for (int j = 0; j < n; ++j)	
		{
			mas[j] = (mas[j] ^ mas[j + 1]);
		}
		int sum = 0;
		tmp=i;
		while(tmp!=0)
		{
			if (tmp % 2 == 1) ++sum;
			tmp/=2;
		}
		if ((sum > 1) && (mas[0] == 1)) c5=1;
	}
}

int main()
{
	cin>>Q;
	c1=0;
	c2=0;
	c3=0;
	c4=0;
	c5=0;
	for(int z=0;z<Q;++z)
	{
		cin>>n>>s;
		n=static_cast<int>(pow(2,n));
		if (c1!=1) check_1();
		if (c2!=1) check_2();
		if (c3!=1) check_3();
		if (c4!=1) check_4();
		if (c5!=1) check_5();

	}
	if (c1*c2*c3*c4*c5==1) cout<<"YES"; else cout<<"NO";
	return 0;
}


/*
3
2 0111
2 0001
1 10
YES

2
2 0110
1 01
NO
*/