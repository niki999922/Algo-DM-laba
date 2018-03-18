#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <algorithm>
#include <stack>

using namespace std;
stack<pair<long,long>> s;

long n,c,m;

int main()
{
	ifstream fin("stack-min.in");
	ofstream fou("stack-min.out");
	fin>>n;
	for(int i=0;i<n;++i)
	{
		fin>>c;
		if (c==1)
		{
			fin>>c;
			if (s.empty())
			{
				s.push(pair<long,long>(c,c));
				continue;
			}
			s.push(pair<long,long>(c,min(c,s.top().second)));
			continue;
		} 
		if (c==2)
		{
			s.pop();
		} 
		if (c==3)
		{
			fou<<s.top().second<<endl;
			continue;
		} 
	}
	fin.close();
	fou.close();
	return 0;
}