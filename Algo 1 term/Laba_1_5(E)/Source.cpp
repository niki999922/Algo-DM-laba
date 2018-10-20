#include <iostream>
#include <fstream>

using namespace std;



int main()
{
	ifstream fin("antiqs.in");
	ofstream fou("antiqs.out");
	long n;
	fin>>n;
	fin.close();
	long* mas=new long[n];
	for(long i=0;i<n;i++) mas[i]=i+1;
	long tmp;
	for (long i = 0;i<n;i++) {
		tmp=mas[i / 2];
		mas[i / 2]=mas[i];
		mas[i]=tmp;
	}
	for(long i=0;i<n;i++) fou<<mas[i]<<" ";
	fou.close();
	return 0;
}