#include <iostream>
#include <fstream>
#include <cmath>


using namespace std;
int n,k;
int mas[32];
int main()
{
	ifstream fin("antigray.in");
	ofstream fou("antigray.out");
	fin>>n;
	for(int i=0;i<static_cast<int>(pow(3,n-1));++i)
    {
        k=i;
		mas[0]=0;
        for(int j=0;j<n-1;++j)
        {
            mas[n-j-1]=k%3;
            k=k/3;
        }
        for(int j=0;j<n;++j)
        {
            fou<<mas[j];
        }
	    fou<<endl;
    	for(int j=0;j<n;++j)
        {
			mas[j]=(mas[j]+1)%3;
            fou<<mas[j];
        }
        fou<<endl;
    	for(int j=0;j<n;++j)
        {
			mas[j]=(mas[j]+1)%3;
            fou<<mas[j];
        }
        fou<<endl;
    }
	fin.close();
	fou.close();
	return 0;
}