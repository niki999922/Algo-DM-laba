#include <iostream>
#include <fstream>
#include <iomanip>

using namespace std;

double first;
int N;

bool all_ok(double first, double second) 
{
	double tmp;
	for(int i=2;i<N;i++)
	{
		tmp=2*second-first+2;
		if (tmp<=0) return 0;
		first=second;
		second=tmp;
	}
	return 1;
}


double all_ok_f(double first, double second) 
{
	double tmp;
	for(int i=2;i<N;i++)
	{
		tmp=2*second-first+2;
		if (tmp<=0) return 0;
		first=second;
		second=tmp;
	}
	return tmp;
}


int main()
{
	ifstream fin("garland.in");
	ofstream fou("garland.out");
	fin>>N>>first;
	double left,right,mid,B;
	left=0;
	right=first;
	while(left<right-0.0000001) {
		mid=(left+right)/2;
		if(all_ok(first,mid)) {
			right=mid;
		} else {
			left=mid;
		}
	}
	B=all_ok_f(first,right);
	fou<<std::fixed<<setprecision(2)<<B;
	fin.close();
	fou.close();
	return 0;
}