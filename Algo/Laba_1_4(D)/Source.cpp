#include <iostream>
#include <fstream>
#include <string>
#include <map>
#include <vector>
#include <utility>

using namespace std;

map<char,vector<string>> A;
string sim[1000];
int n,m,el;
/*
char digit(int whos,int ind) {
	return A[whos][ind];
}

void radixSort()
{
	int C[130];
	string B[1000];
	int scor=0;
  //  for (int i = 0;i<m;i++) {
      for (int i = m-1;i>0;i--) {
		if (scor==el) break;
		for (int j = 97;j<123;j++) {                              
            C[j] = 0;                 
		}
        for (int j = 0;j<n;j++) {
            char d = digit(j,i);
            C[d]++;
		}
        int count = 0;
        for (int j = 97;j<123;j++) {
            int tmp = C[j];
            C[j] = count;
            count += tmp;
		}
        for (int j = 0;j<n;j++) {
            char d = digit(j,i);                             
            B[C[d]] = A[j];            
            C[d]++;
		}
        for(int j=0;j<n;j++)
		{
		A[j] = B[j];
		}
		scor++;
	}
}
*/
int main()
{
	ifstream fin("radixsort.in");
	ofstream fou("radixsort.out");
	fin>>n>>m>>el;
	string str;
	for(int i=0;i<n;i++) 
	{
		fin>>str;
		if (A.count(str[str.size()-1]) == 0) {
			vector<string> v;
			A.insert(pair<char,vector<string>>(str[str.size()-1],v));
			A.find(str[str.size()-1])->second.push_back(str);
		} else {
				A.find(str[str.size()-1])->second.push_back(str);
		}
	}
	int el_now=1;
	for(int q=str.size()-2;q>=0;q--)
	{
		if (!(el>1)) break;
		int j=0;
		for(auto& item : A)
		{
			for(int i=0;i<item.second.size();i++)
			{
				sim[j]=item.second[i];
				j++;
			}
		}

		A.clear();
		for(int i=0;i<n;i++) 
		{
			str=sim[i];
			if (A.count(str[q]) == 0) {
				vector<string> v;
				A.insert(pair<char,vector<string>>(str[q],v));
				A.find(str[q])->second.push_back(str);
			} else {
					A.find(str[q])->second.push_back(str);
			}
		}
		el--;
	}
	//auto it=A.find(aaas[0][0]);
	//radixSort();
	//for(int i=0;i<n;i++) fou<<A[i]<<endl;
	for(auto& item : A)
	{
		for(int i=0;i<item.second.size();i++)
		{
			fou<<item.second[i]<<endl;
		}
	}
	fin.close();
	fou.close();
	return 0;
}
