#include <iostream>
#include <fstream>
using namespace std;

int main()
{
	ifstream fin("isheap.in");
	ofstream fou("isheap.out");
	long n;
	fin>>n;
	long* mas=new long[n];
	for(int i=0;i<n;i++) fin>>mas[i];	
	fin.close();
	for(long i=0;i<n;i++) {
		if ((2*i + 1) < n) 
			if (!(mas[i] <= mas[2*i + 1])) {
				fou<<"NO";
				fou.close();
				return 0;
		}
		if ((2*i + 2) < n)
			if (!(mas[i] <= mas[2*i + 2])) {
				fou<<"NO";
				fou.close();
				return 0;
		}
	}
	fou<<"YES";
	fou.close();
	return 0;
}