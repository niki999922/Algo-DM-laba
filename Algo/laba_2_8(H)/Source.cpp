#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

using namespace std;

ifstream fin("saloon.in");
ofstream fou("saloon.out");

class Ghost
{
public:
	int num;
	int minut;
	int angry;
};

bool myfunction (Ghost i,Ghost j) { return (i.num<j.num); }

int n;
vector<Ghost> v,v1;
Ghost tmp;
int minut_g,work=0,sc;


int main()
{
	fin>>n;
	for(int i=0;i<n;i++)
	{
		tmp.num=i;
		fin>>work;
		fin>>tmp.minut>>tmp.angry;
		tmp.minut=tmp.minut+work*60;
		v.push_back(tmp);
	}
	minut_g=v[0].minut;
	work=0;
	while ((minut_g!=1440) && (v.size()>0))
	{
		if (work<=0)
		{
			if (v1.size()==0)
			{
				tmp=v.front();
				tmp.minut=minut_g+20;
				v1.push_back(tmp);
				work=20;
			} else {
				v.erase(v.begin());
				if (v.size()==0) continue;
				if (v[0].minut>minut_g) minut_g=v[0].minut;
				tmp=v.front();
				tmp.minut=minut_g+20;
				v1.push_back(tmp);
				work=20;
			}
		}
		--work;
		sc=1;
		for(int i=1;i<v.size(); ++i)
		{
			if (v[i].minut>minut_g) continue;
			if (sc>v[i].angry) { v1.push_back(v[i]);v.erase(v.begin()+sc);--i;--sc;}
			++sc;
		}
		++minut_g;
	}
	sort(v1.begin(),v1.end(),myfunction);
	for(int i=0;i<v1.size();++i)
	{
		fou<<v1[i].minut/60<<" "<<v1[i].minut%60<<endl;
	}
	fin.close();
	fou.close();
	return 0;
}