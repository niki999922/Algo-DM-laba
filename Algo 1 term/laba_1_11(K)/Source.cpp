#include <iostream>
#include <fstream>
#include <vector>
#include <iomanip>

using namespace std;

int n,L,N;
double Way;
vector<pair<double,int>> v;
vector<double> vt;

/*int find_N(double k){  
	int l=-1;            
	int r=n;    
	while (l<r-1) {               
		int m=(l+r)/2;          
		if (vt[m] < k) {
			l = m;
		}  else{ 
			r=m; 
		}
	}
	return r;
}*/

bool check(double mid)
{
	double t1=v[0].first,t2=mid,w1=0,w2=0,tl1=0,tl2=0;
	int i=0,j=n;
	while(i<n) {
		if (t1<t2) 
		{
			w1+=t1*v[i].second;
			w2+=t1*v[j].second;
			t2=t2-t1;
			i++;
			t1=v[i].first;
		} else {
			w1+=t2*v[i].second;
			w2+=t2*v[j].second;
			t1=t1-t2;
			j++;
			j=j%(n+1);
			t2=v[j].first;
		}
		if (w1-w2<L && j<n) return 0;
	}
	return 1;
}

int main()
{
	ifstream fin("trains.in");
	ofstream fou("trains.out");
	fin>>L>>n;
	Way=0;
	v.resize(n);
	vt.resize(n);
	for(int i=0;i<n;i++) fin>>v[i].first>>v[i].second;
	vt[0]=static_cast<double>(v[0].first);
	for(int i=1;i<n;i++) vt[i]=vt[i-1]+static_cast<double>(v[i].first);
	for(int i=0;i<n;i++) Way+=static_cast<double>(v[i].first*v[i].second);
	double left=0,mid;
	double right=vt[n-1];
	v.push_back(pair<double,int>(0,0));
	while(left<right-0.0000001) 
	{
		mid=(left+right)/2;
		if (check(mid)) {
			right=mid;	
		} else {
			left=mid;
		}
	}
	fou<<fixed<<setprecision(3)<<left;
	fin.close();
	fou.close();
	return 0;
}