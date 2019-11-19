#include <iostream>
#include <fstream>
#include <string>

using namespace std;

ifstream fin("brackets.in");
ofstream fou("brackets.out");
	
void psp(int n, int op, int cl, string str)
{
	if (op+cl==2*n) 
	{
		fou<<str.c_str()<<endl;
		return;
	}
	if (op<n)
	{
		psp(n,op+1,cl,str+"(");
	}
	if (op>cl)
	{
		psp(n,op,cl+1,str+")");
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
