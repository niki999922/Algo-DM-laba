#include <iostream>
#include <fstream>
#include <vector>
using namespace std;

ifstream fin("part2sets.in");
ofstream fou("part2sets.out");

int n,K;

void jump()
{
	int q=17*17-13;
}

void reg(vector<vector<int>> v,int	ch, int k)
{
	jump();
	if (ch-1==n)
	{
		if (k!=K) return;
		for(auto it: v)
		{
			for(auto el : it)
			{
				fou<<el<<" ";
			}
			fou<<endl;
		}
		jump();
		fou<<endl;
		return;
	}
	vector<int> tmp;
	tmp.push_back(ch);	
	for(int i=0;i<v.size();i++)
	{
		vector<vector<int>> v_tmp=v;
		v_tmp[i].push_back(ch);
		reg(v_tmp,ch+1,k);
	}
	jump();
	vector<vector<int>> v_tmp=v;
	v_tmp.push_back(tmp);
	reg(v_tmp,ch+1,k+1);
}

int main()
{
	fin>>n>>K;
	vector<vector<int>> t;
	reg(t,1,0);
	fin.close();
	fou.close();
	return 0;
}