#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

class Q
{
public:
	long long ch;
	vector<long long> el;
};

long long mas[1000],RTY[1000];
vector<Q> elem;
long long n;

bool myfunction (Q i,Q j) { return (i.ch<j.ch); }

int main()
{
	ifstream fin("huffman.in");
	ofstream fou("huffman.out");
	fin>>n;
	for(long long i=0;i<n;i++) 		
	{
		Q tmp;
		tmp.el.push_back(i);
		fin>>tmp.ch;
		RTY[i]=tmp.ch;
		elem.push_back(tmp);
	}
	while(elem.size()>1)
	{
		sort(elem.begin(),elem.end(),myfunction);
		Q tmp;
		tmp.ch=elem[0].ch+elem[1].ch;

		tmp.el=elem[0].el;
		for(long long i=0;i<elem[1].el.size();i++)
		{
			tmp.el.push_back(elem[1].el[i]);
		}
		elem.erase(elem.begin());
		elem.erase(elem.begin());
		elem.push_back(tmp);
		for(long long i=0;i<tmp.el.size();i++)
		{
			mas[tmp.el[i]]++;
		}
	}
	long long sum=0;
	for(long long i=0;i<n;i++)
	{
		sum+=RTY[i]*mas[i];
	}
	fou<<sum;
	fin.close();
	fou.close();
	return 0;
}