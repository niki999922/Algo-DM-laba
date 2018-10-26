#include <iostream>
#include <fstream>
#include <cmath>
#include <map>
#include <string>

using namespace std;
string tmp,tmp2,str="0000000000000000";
int n,k,r_m=1;
//string mas[33333];
map<string,string> s;
int main()
{
	ifstream fin("chaincode.in");
	ofstream fou("chaincode.out");
	fin>>n;
	str=str.substr(0,n);
	tmp=str;
	s.insert(pair<string,string>(str,str));
	fou<<str<<endl;
	for(int i=0;i<static_cast<int>(pow(2,n));++i)
    {
		tmp=tmp.substr(1);
		if (s.find((tmp+"1"))==s.end())
		{
			tmp=tmp+"1";
			s.insert(pair<string,string>(tmp,tmp));
			fou<<tmp<<endl;
			continue;
		} else if (s.find((tmp+"0"))==s.end())
		{
				tmp=tmp+"0";
				s.insert(pair<string,string>(tmp,tmp));
				fou<<tmp<<endl;
				continue;
		}
	}
	fin.close();
	fou.close();
	return 0;
}