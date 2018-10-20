#include <iostream>
#include <vector>
#include <fstream>

using namespace std;

vector<long> v;
char c;
long n,tmp;

int main()
{
	ifstream fin("hospital.in");
	ofstream fou("hospital.out");
	fin>>n;
	for(long i=0;i<n;i++)
	{
		fin>>c;
		if(c=='+')
		{
			fin>>tmp;
			v.push_back(tmp);
		}
		if(c=='*')
		{
			fin>>tmp;
			if (v.size()%2!=0) 
			{
				v.insert(v.begin()+v.size()/2+1,tmp); 
			}else {
				v.insert(v.begin()+v.size()/2,tmp);
			}
		}
		if(c=='-')
		{
			fou<<v[0]<<endl;
			v.erase(v.begin(),v.begin()+1);
		}
	}
	fin.close();
	fou.close();
	return 0;
}