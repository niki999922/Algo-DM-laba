#include <iostream>
#include <fstream>
#include <vector>
using namespace std;


int mas[600000];
int size_d;
int l=0,r;
int n,m,tmp,ll,rr;
   
int main()
{
    std::ios::sync_with_stdio(false);
    ifstream fin("bureaucracy.in");
    ofstream fou("bureaucracy.out");
    fin>>n>>m;
    size_d=n;
    r=n;
    for(int i=0;i<n;++i) 
    {
        fin>>mas[i];
    }  
	while((m>0)&&(size_d>0))
    {   
		if (m>=size_d)
		{
			tmp=m/size_d;
			m=m%size_d;
			ll=l;rr=r;
			for(int i=ll;i<rr;++i)
			{
				mas[i]-=tmp;
				if (mas[i]<=0)
				{
					m+=abs(mas[i]);
					++l;
					--size_d;
				} else {
					++l;
					mas[r++]=mas[i];
				}
			}
		} else {
			if (mas[l]-1>0) {++size_d; mas[r++]=mas[l]-1;}
			--size_d;
			++l;
			m--;
		}
	}
	if (size_d==0) {
        fou<<"-1";
    } else {
        fou<<size_d<<endl;
        for(int i=l;i<r;++i)
        {
            fou<<mas[i]<<" ";
        }
    }
    fin.close();
    fou.close();
    return 0;
}