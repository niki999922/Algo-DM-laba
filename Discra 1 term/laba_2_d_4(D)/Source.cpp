#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <algorithm>
#include <map>

using namespace std;
string c;
string tmp,s;
vector<string> alf;
map<string,long long> m;
map<string,long long>::iterator it;
long long num;


int main()
{
	ifstream fin("lzw.in");
	ofstream fou("lzw.out");
	m.insert(pair<string,long long>("a",0));
	m.insert(pair<string,long long>("b",1));
	m.insert(pair<string,long long>("c",2));
	m.insert(pair<string,long long>("d",3));
	m.insert(pair<string,long long>("e",4));
	m.insert(pair<string,long long>("f",5));
	m.insert(pair<string,long long>("g",6));
	m.insert(pair<string,long long>("h",7));
	m.insert(pair<string,long long>("i",8));
	m.insert(pair<string,long long>("j",9));
	m.insert(pair<string,long long>("k",10));
	m.insert(pair<string,long long>("l",11));
	m.insert(pair<string,long long>("m",12));
	m.insert(pair<string,long long>("n",13));
	m.insert(pair<string,long long>("o",14));
	m.insert(pair<string,long long>("p",15));
	m.insert(pair<string,long long>("q",16));
	m.insert(pair<string,long long>("r",17));
	m.insert(pair<string,long long>("s",18));
	m.insert(pair<string,long long>("t",19));
	m.insert(pair<string,long long>("u",20));
	m.insert(pair<string,long long>("v",21));
	m.insert(pair<string,long long>("w",22));
	m.insert(pair<string,long long>("x",23));
	m.insert(pair<string,long long>("y",24));
	m.insert(pair<string,long long>("z",25));
	tmp="";
	fin>>s;
	for(long long i=0;i<s.size();i++)
	{
		c=s[i];
		it=m.find(c);
		if (i==s.size()-1)
		{
			fou<<it->second;
		} else {
			string word=c;
			int j=1;
			while ((m.find(word)!=m.end()) &&(i+j<s.size()))
			{
				word+=s[i+j];
				j++;
			}
			if (m.find(word)==m.end()) {
				m.insert(pair<string,long long>(word,m.size()));
				fou<<(m.find(word.substr(0,word.size()-1)))->second<<" ";
				i+=word.size()-2;
			} else { 
				fou<<(m.find(word))->second<<" ";
				i+=word.size()-1;
			}
		}
	}
	fin.close();
	fou.close();
	return 0;
}