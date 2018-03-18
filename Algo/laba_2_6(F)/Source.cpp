#include <iostream>
#include <fstream>
#include <deque>
#include <string>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

long n,z;
deque<long> q;
vector<long> v;
set<long,long> s_t;
string s;
long num,wh;

int main()
{
	ifstream fin("formation.in");
	ofstream fou("formation.out");
	fin>>n>>z;
	v.push_back(1);
	for(long i=0;i<z;++i) {
		fin>>s;
		if (s=="left") {
			fin>>num>>wh;
			auto it=find(v.begin(),v.end(),wh);
			v.insert(it,num);
		}
		if (s=="right") {
			fin>>num>>wh;
			auto it=find(v.begin(),v.end(),wh);
			v.insert(it+1,num);
		}
		
		if (s=="leave") {
			fin>>num;
			auto it=find(v.begin(),v.end(),num);
			v.erase(it);
		}

		if (s=="name") {
			fin>>num;
			std::vector<long>::iterator it=find(v.begin(),v.end(),num);
			if (*(it)==*(v.begin())) fou<<"0 "<<v[1]<<endl;
			else if (*(it)==*(v.end()-1)) fou<<*(v.end()-2)<<" 0"<<endl;
			else fou<<*(it-1)<<" "<<*(it+1)<<endl;
		}
		s="";
	}
	fin.close();
	fou.close();
	return 0;
}