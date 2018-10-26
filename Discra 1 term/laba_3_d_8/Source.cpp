#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

ifstream fin("choose.in");
ofstream fou("choose.out");
int n,k;
int mas[20];

void just()
{
	int t=3+3;
}
bool next_el() 
{
	for (int i=k-1;i>=0;--i)
		if (mas[i] < n - k + i + 1) 
		{
			++mas[i];
			for (int j=i+1; j<k; ++j)
			{
				just();
				int tmp=mas[j-1];
				++tmp;
				mas[j]=tmp;
			}
			return true;
		}
	return false;
}


int main()
{
	fin>>n>>k;	
	vector<int> v;
	for(unsigned int i=1;i<=k;i++) mas[i-1]=static_cast<int>(i);
	for(unsigned int i=0;i<k;i++) fou<<mas[static_cast<int>(i)]<<" ";
	fou<<endl;
	while(next_el())
	{
		for(int i=0;i<k;i++) fou<<mas[i]<<" ";
		fou<<endl;
	}
	fin.close();
	fou.close();
	return 0;
}