#include <iostream>
#include <fstream>
#include <cmath>
#include <string>
 
 
using namespace std;
int n,k,K;
string mas[1000000];
int main()
{
	ifstream fin("telemetry.in");
	ofstream fou("telemetry.out");
	fin>>n>>K;
	int R=1;
	while(R<static_cast<int>(pow(K,n)))
	{
		for(int i=0;i<static_cast<int>(pow(K,n));++i)
		{
			mas[i]+=to_string((i/R)%K);
		}
		R=R*K;
	}
	R=K;
	int p=0;
	while(R<static_cast<int>(pow(K,n)))
	{
		for(int i=0;i<static_cast<int>(pow(K,n));++i)
		{
			if ((i/R)%2!=0)
			{
				mas[i][p]=char(((K-1)-(mas[i][p]-48))+48);
			}
		}
		++p;
		R=R*K;
	}
	for(int i=0;i<static_cast<int>(pow(K,n));++i)
	{
		fou<<mas[i]<<endl;
	}

    //for(int i=0;i<static_cast<int>(pow(K,n-1));++i)
    //{
    //    k=i;
    //    mas[0]=0;
    //    for(int j=0;j<n-1;++j)
    //    {
    //        mas[n-j-1]=k%K;
    //        k=k/K;
    //    }
    //    for(int j=0;j<n;++j)
    //    {
    //        fou<<mas[j];
    //    }
    //    fou<<endl;
    //    for(int j=0;j<n;++j)
    //    {
    //        mas[j]=(mas[j]+1)%K;
    //        fou<<mas[j];
    //    }
    //    fou<<endl;
    //    for(int j=0;j<n;++j)
    //    {
    //        mas[j]=(mas[j]+1)%K;
    //        fou<<mas[j];
    //    }
    //    fou<<endl;
    //}
	fin.close();
	fou.close();
	return 0;
}