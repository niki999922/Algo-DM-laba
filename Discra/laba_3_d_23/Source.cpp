#include <iostream>
#include <fstream>
#include <string>
 
 
using namespace std;

ifstream fin("nextvector.in");
ofstream fou("nextvector.out");
 
string str;

void prev()
{
	try
	{
		int wf=0;
		string tmp=str;
		for(long long i=tmp.size()-1;i>=0;--i)
		{
			if (tmp[i]=='1')
			{
				tmp[i]='0';
				for(long long j=i+1;j<tmp.size();++j)
				{
					tmp[j]='1';
				}
				wf=1;
				break;
			}
		}
		if (wf==0) {fou<<"-"<<endl;return;}
		fou<<tmp<<endl;
	}	
	catch(...)
	{
		fou<<"-"<<endl;
	}
}

void next()
{
	try
	{
		int wf=0;
		string tmp=str;
		for(long long i=tmp.size()-1;i>=0;--i)
		{
			if (tmp[i]=='0')
			{
				tmp[i]='1';
				for(long long j=i+1;j<tmp.size();++j)
				{
					tmp[j]='0';
				}
				wf=1;
				break;
			}
		}
		if (wf==0) {fou<<"-"<<endl;return;}
		fou<<tmp<<endl;
	}
	catch(...)
	{
		fou<<"-"<<endl;
	}
}

int main()
{
    fin>>str;
	prev();
	next();
	fin.close();
    fou.close();
    return 0;
}