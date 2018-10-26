#include <iostream>
#include <fstream>
#include <string>

using namespace std;

ifstream fin("permutations.in");
ofstream fou("permutations.out");

int M;
int mas[20];

void rec(int n)
{
	if (n!=0)
	{
		for(int j=1;j<=M;++j)
		{
			int e=0;
			for(int i=0;i<M-n;i++)
			{
				if (mas[i]==j) {e=1;break;}
			}
			if (e==1) continue;
			mas[M-n]=j;
			rec(n-1);
		}
	} else {
		for(int i=0;i<M;i++)
		{
		fou<<mas[i]<<" ";
		}
		fou<<endl;
	}
}

int main()
{
	int n;
	fin>>n;
	M=n;
	rec(n);
	fin.close();
	fou.close();
	return 0;
}