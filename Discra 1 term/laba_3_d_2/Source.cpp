#include <iostream>
#include <fstream>
#include <cmath>

using namespace std;
int n,k;
int mas[32];	
int main()
{
	ifstream fin("gray.in");
	ofstream fou("gray.out");
	fin>>n;
    for(int i=0;i<static_cast<int>(pow(2,n));++i)
    {
        k=i;
		k=k^(k>>1);
        for(int j=0;j<n;++j)
        {
            mas[n-j-1]=k%2;
            k=k>>1;
        }
        for(int j=0;j<n;++j)
        {
            fou<<mas[j];
        }
        fou<<endl;
    }
	fin.close();
	fou.close();
	return 0;
}