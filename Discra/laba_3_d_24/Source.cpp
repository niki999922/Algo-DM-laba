#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

ifstream fin("nextperm.in");
ofstream fou("nextperm.out");
int mas[100001],mas_tmp[100001];
int n;
vector<int> v,vw;

void last_mi()
{
    int wf=0;
	v.clear();
	for(int i=1;i<=n;i++) mas_tmp[i]=mas[i];
	v.push_back(mas_tmp[n]);
	for(long long i=n-1;i>0;--i)
    {
        if (mas_tmp[i]>mas_tmp[i+1])
        {
			int ch=mas_tmp[i];
			while(find(v.begin(),v.end(),mas_tmp[i])==v.end()) mas_tmp[i]-=1;
			v.erase(find(v.begin(),v.end(),mas_tmp[i]));
			v.push_back(ch);
			sort(v.begin(),v.end());
			for(long long j=0;j<v.size();++j)
            {
				mas_tmp[j+i+1]=v[v.size()-1-j];
            }
            wf=1;
            break;
        }
		if (i!=1)
		{
		v.push_back(mas_tmp[i]);
		}
	}
	if (wf==0) {for(int i=1;i<n;++i) {fou<<"0 ";} fou<<"0"<<endl; return;}
    for(int i=1;i<=n;i++) fou<<mas_tmp[i]<<" ";
    fou<<endl;
}

void next_mi()
{
    int wf=0;
	v.clear();
	for(int i=1;i<=n;i++) mas_tmp[i]=mas[i];
	v.push_back(mas_tmp[n]);
	for(long long i=n-1;i>0;--i)
    {
        if (mas_tmp[i]<mas_tmp[i+1])
        {
			int ch=mas_tmp[i];
			while(find(v.begin(),v.end(),mas_tmp[i])==v.end()) mas_tmp[i]+=1;
			v.erase(find(v.begin(),v.end(),mas_tmp[i]));
			v.push_back(ch);
			sort(v.begin(),v.end());
			for(long long j=0;j<v.size();++j)
			{
                mas_tmp[j+i+1]=v[j];
            }
            wf=1;
            break;
        }
		if (i!=1)
		{
		v.push_back(mas_tmp[i]);
		}
	}
	if (wf==0) {for(int i=1;i<n;++i) {fou<<"0 ";} fou<<"0"<<endl; return;}
    for(int i=1;i<=n;i++) fou<<mas_tmp[i]<<" ";
    fou<<endl;
}

int main()
{
	fin>>n;
	for(int i=1;i<=n;++i) fin>>mas[i];
	last_mi();
	next_mi();
	fin.close();
	fou.close();
	return 0;
}