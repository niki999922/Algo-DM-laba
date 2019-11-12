#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>
#include <sstream>

using namespace std;

ifstream fin("part2num.in");
ofstream fou("part2num.out");

int sl[2000];
int n,num,req=0,b=0;
long long qqq[101][101];
long long slag[100000];
int mas[101];
long long slag_num=0;
string str;

int fromString(string s) 
{
	istringstream iss(s);
	int res;
	iss >> res;
	return res;
}

void rasklad()
{
	string tmp=str;
	long long tmp_ch=0,q;
	while(tmp.length()>0)
	{
		if (tmp.find("+") != string::npos)
		{
			q=fromString(tmp.substr(0,tmp.find("+")));
			tmp_ch+=q;
			slag[slag_num]=q;
			++slag_num;
			tmp=tmp.substr(tmp.find("+")+1);
	
		} else {
			q=fromString(tmp);
			tmp_ch+=q;
			slag[slag_num]=q;
			++slag_num;
			tmp="";
		}
	}
	n=tmp_ch;
}

void help_dinamoooo()
{
	for(int i=0;i<=n;i++) qqq[i][i]=1;
	for(int i=1;i<=n;i++)
	{
		int q=1;
		for(int j=i-1;j>0;--j)
		{
			qqq[i][j]=qqq[i][j+1]+qqq[i-j][j];
			q++;
		}
	}
}

long long get_num()
{
	int num=0,ch,last=1;
	for(int i=0;i<slag_num;++i)
	{
		jump();
		ch=0;
		for(int j=last;j<slag[i];j++)
		{
			ch+=qqq[n-j][j];
		}
		num+=ch;
		n-=slag[i]; 
		last=slag[i];
	}
	return num;
}

//1+1+1+1   0
//1+1+2		1
//1+3		2
//2+2		3
//4			4

//1+1+1+1+1    0
//1+1+1+2      1
//1+1+3	       2
//1+2+2	       3
//1+4	       4
//2+3	       5
//5		       6


//1+1+1+1+1+1+1     0
//1+1+1+1+1+2       1
//1+1+1+1+3	        2
//1+1+1+2+2	        3
//1+1+1+4	        4
//1+1+2+3	        5
//1+1+5		        6
//1+2+2+2	        7
//1+2+4		        8
//1+3+3		        9
//1+6		        10
//2+2+3		        11
//2+5		        12
//3+4		        13
//7			        14


int main()
{
	//for(int i=0;i<=14;i++)
	//{
		slag_num=0;
		fin>>str;
		rasklad();
		help_dinamoooo();
		fou<<get_num();
	//}
	fin.close();
	//fou.close();
	return 0;
}
