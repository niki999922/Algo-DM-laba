#include <iostream>
#include <cmath>
#include <string>
using namespace std;

int mas[1050];
int mas_k[1050];
int n,q;

void prt(string s, int g)
{
	if (g==n) 
	{
		cout<<s<<" "<<mas_k[q]<<endl;
		q++;
		return;
	}
	prt(s+"0",g+1);
	prt(s+"1",g+1);
}
int main()
{
	for(int i=0;i<1050;i++) mas[i]=0;
	cin>>n;
	int k=n;
	n=static_cast<int>(pow(2,n));
	string s;
	for(int i=0;i<n;i++) 
	{
		cin>>s;
		cin>>mas[i];
	}
	int q=0;
	while (n>0) 
	{
		mas_k[q]=mas[0];
		q++;
		for(int i=0;i<n-1;i++)
		{
			if (mas[i]==mas[i+1]) mas[i]=0; else mas[i]=1;
		}
		n--;
	}
	n=k;
	q=0;
	prt("0",1);
	prt("1",1);
	return 0;
}