#include <iostream>
#include <fstream>

using namespace std;

void MergeSlit(long* mas, long left, long mid, long right)
{
	long* mas_tmp= new long[right-left];
    long t_1 = 0;
    long t_2 = 0;
    while ((left + t_1 < mid) && (mid + t_2 < right)) {
        if (mas[left + t_1] < mas[mid + t_2]) {
            mas_tmp[t_1 + t_2] = mas[left + t_1];
            t_1++;
		} else {
            mas_tmp[t_1 + t_2] = mas[mid + t_2];
            t_2++;
		}
	}
    while (left + t_1 < mid) {
        mas_tmp[t_1 + t_2] = mas[left + t_1];
        t_1++;
	}

    while (mid + t_2 < right) {
        mas_tmp[t_1 + t_2] = mas[mid + t_2];
        t_2++;
	}
    for (long i = 0;i<t_1+t_2;i++) mas[left + i] = mas_tmp[i];
	delete [] mas_tmp;
}

void MergeSort(long* mas,long left,long right)
{
	if (left + 1 >= right) return;
    long mid = (left + right) / 2;
    MergeSort(mas, left, mid);
    MergeSort(mas, mid, right);
    MergeSlit(mas, left, mid, right);
}

int main()
{
	ifstream fin("sort.in");
	ofstream fou("sort.out");
	long n;
	fin>>n;
	long* mas=new long[n];
	for(long i=0;i<n;i++) fin>>mas[i];
	fin.close();
	MergeSort(mas,0,n);
	for(long i=0;i<n;i++) fou<<mas[i]<<" ";
	fou.close();
	return 0;
}