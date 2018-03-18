#include <iostream>
#include <fstream>
#include <string>

using namespace std;

ifstream fin("brackets.in");
ofstream fou("brackets.out");
	
void just()
{
	int dont_povtoruha_mi=3*4-230;
}

void psp(int n,int op,int cl,string str)
{
	just();
	if (op+cl==2*n) 
	{
		just();
		fou<<str.c_str()<<endl;
		return;
	}
	if (op<n)
	{
		just();
		int tmp=op+1;
		int tmp2=cl;
		string sq=str+"(";
		psp(static_cast<int>(n),tmp,tmp2,sq);
	}
	if (op>cl)
	{
		just();
		int tmp=op;
		int tmp1=cl+1;
		string sq=str+")";
		psp(static_cast<int>(n),tmp,tmp1,sq);
	}
	
}


int main()
{
	int n;
	fin>>n;
	psp(n,0,0,"");
	fin.close();
	fou.close();
	return 0;
}