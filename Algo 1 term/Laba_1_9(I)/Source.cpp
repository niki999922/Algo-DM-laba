#include <iostream>
#include <fstream>

using namespace std;

int* mas;
int n;

int Search_l(int k){  
    int l = -1;            
    int r = n;    
    while (l < r - 1) {               
	    int m = (l + r) / 2;          
	    if (mas[m] < k) {
		        l = m;
		}  else{ 
		        r =m; 
		}
	}
	if (mas[r]==k) {return r+1; } else {return -1;}
}

int Search_r(int k){  
    int l = -1;            
    int r = n;    
    while (l < r - 1) {               
	    int m = (l + r) / 2;          
	    if (mas[m] <= k) {
		        l = m;
		}  else{ 
		        r =m; 
		}
	}
	if (mas[l]==k) {return l+1; } else {return -1;}
}
int main() {
	ifstream fin("binsearch.in");
	ofstream fou("binsearch.out");
	fin>>n;
	mas=new int[n];
	for(int i=0;i<n;i++) fin>>mas[i];
	int r,k;
	fin>>r;
	for(int i=0;i<r;i++){
		fin>>k;
		fou<<Search_l(k)<<" "<<Search_r(k)<<endl;
	}
	fou.close();
	return 0;
}