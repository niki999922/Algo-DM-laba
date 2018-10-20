#include <iostream>
#include <fstream>
#include <string>

using namespace std;
const int size = 300000;
int num;
int l1,l2;
pair<int,int> mas[size];
int n=0;

//void  siftDown(int i)
//{
//        int left = 2 * i + 1;            
//        int right = 2 * i + 2;      
//		if ((left>n) || (right>n)) return;
//		if ((mas[left].first >= mas[i].first) && (mas[right].first >= mas[i].first)) return;
//		int j = right;
//		if (mas[right].first > mas[left].first) j=left;
//        swap(mas[i], mas[j]);
//		siftDown(j);
//}

void siftDown(int i)
{
    int left,right,j;
	while (2 * i + 1 < n) {
        left = 2 * i + 1;   
        right = 2 * i + 2;  
        j = left;
        if ((right < n) && (mas[right].first < mas[left].first))
            j = right;
		if (mas[i].first <= mas[j].first)
            break;
        swap(mas[i], mas[j]);
        i = j;
	}
}

void siftUp(int i)
{
    while (mas[i] < mas[(i - 1) / 2]) 
	{
		swap(mas[i], mas[(i - 1) / 2]);
        i = (i - 1) / 2;
	}
}		

//void siftUp(int i) {
//	while (i>0) {
//		if ((mas[((i - 1) / 2)].first) > (mas[i].first))
//		{
//	    swap(mas[i],mas[((i - 1) / 2)]);
//		i = ((i - 1) / 2);
//		} else {
//			return;
//		}
//	}
//}

int main()
{
	ifstream fin("priorityqueue.in");
	ofstream fou("priorityqueue.out");
	for(int i=0;i<size;i++) 
	{
		mas[i].first=10000000;
		mas[i].second=-2;
	}
	num=1;
	string str;
	string ad = "push";
	string viv = "extract-min";
    string del = "decrease-key";
    while(!fin.eof()) {
		fin>>str;
		if (str == ad) {
			fin>>mas[n].first;
			mas[n].second=num;
			siftUp(n);
			n++;
		}
		if (str == viv) {
			if (n > 0)
			{
				fou<<mas[0].first<<endl;
				mas[0].first=mas[n-1].first;
				mas[0].second=mas[n-1].second;
				//swap(mas[0],mas[n-1]);
				n--;
				siftDown(0);
			} else {
				fou<<"*"<<endl;
			}	
		}
		if (str == del) {
			fin>>l2>>l1;
			for(int i=0;i<n;i++) 
			{
				if (mas[i].second==l2) {
					mas[i].first=l1;
					siftUp(i);
					break;
				}
			}	
		}
		str="";
		num++;	
	}
	fin.close();
	fou.close();
	return 0;
}