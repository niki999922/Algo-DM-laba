#include <iostream>
#include <fstream>
#include <cmath>

using namespace std;

int main() 
{
	ifstream fin("style.in");
	ofstream fou("style.out");
	int n_1,n_2,a,b;
	fin>>n_1;
	int* mas_1=new int[n_1];
	for(int i=0;i<n_1;i++) fin>>mas_1[i];
	fin>>n_2;
	int* mas_2=new int[n_2];	
	for(int i=0;i<n_2;i++) fin>>mas_2[i];
	fin.close();
	int m=0;
	int t=0;
	a=mas_1[0];
	b=mas_2[0];
	int min=INT_MAX;
	while((t<n_1) && (m<n_2))
	{
		if (min == 0) break;
		if (abs(mas_1[t]-mas_2[m])<min)
		{
			a=mas_1[t];
			b=mas_2[m];
			min=abs(a-b);
		}
		if ((t+1<n_1)&&(abs(mas_1[t+1]-mas_2[m])<abs(mas_1[t]-mas_2[m]))) {
			t++;
		} else {
			m++;
		}
	}
	fou<<a<<" "<<b;
	fou.close();
	return 0;
}