#include <iostream>
#include <fstream>
#include <cmath>
#include <vector>
#include <string>

using namespace std;
int n,k,e=0;
int mas[32];
vector<string> v;
int main()
{
	ifstream fin("vectors.in");
	ofstream fou("vectors.out");
	fin>>n;
    for(int i=0;i<static_cast<int>(pow(2,n));++i)
    {
        k=i;
		e=0;
        for(int j=0;j<n;++j)
        {
            mas[n-j-1]=k%2;
            k=k>>1;
        }

        for(int j=0;j<n-1;++j)
        {
			if ((mas[j]==mas[j+1])&& (mas[j]==1)) {e=1;break;}
        }
		if (e==1) continue;
		v.push_back("");
		for(int j=0;j<n;++j)
        {
			v[v.size()-1]+=to_string(mas[j]);
        }
    }
	fou<<v.size()<<endl;
	for(int i=0;i<v.size();i++)
	{
		fou<<v[i]<<endl;
	}
	fin.close();
	fou.close();
	return 0;
}