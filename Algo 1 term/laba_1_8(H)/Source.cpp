#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

vector<int> vec;
int n,k;
int A,B,C,a1,a2;
/*
int findOrderStatistic(int k) {
	int left = 0, right =n-1;
	while (true) {
		int x=vec[rand()%(right-left+1)+left];
		int i = left;
		int j=right;
		while (i <= j){ 
			 while (vec[i] < x) i++;
			while (vec[j] > x) j--;
			if (i <= j) swap(vec[i++], vec[j--]);
		}
		if (j<left) j=left;
		int mid=j;
		
		
		if (mid == k) {
			return vec[mid];
		}
		else if (k < mid) {
			right = mid;
		}
		else {
			left = mid + 1;
		}
	}
}*/

int partition(int l, int r)
{
    int i = l;
    int j=r;
	int x=vec[rand()%(r-l+1)+l];
    while (i <= j){ 
       while (vec[i] < x) i++;
       while (vec[j] > x) j--;
       if (i <= j) swap(vec[i++], vec[j--]);
    }
    if (j<l) j=l;
	return j;
}

int findOrderStatistics_Random(int left, int right)
{
	if (right == left) return vec[left];
	int middle = partition(left, right);
	if (k <= middle)
	{
		return findOrderStatistics_Random(left, middle);
	} else{
		return findOrderStatistics_Random(middle + 1, right);
	}
}




int main()
{
	ifstream fin("kth.in");
	ofstream fou("kth.out");
	fin>>n;
	vec.resize(n);
	fin>>k>>A>>B>>C>>vec[0]>>vec[1];
	k=k-1;
	for(int i=2;i<n;i++) {
		vec[i]=A*vec[i-2]+B*vec[i-1]+C;
	}
	fin.close();
	fou<<findOrderStatistics_Random(0,n-1);
	fou.close();
	return 0;
}