#include <iostream>
#include <fstream>
#include <algorithm>

using namespace std;
int n1,n2,n3,n4;
int a,b,c,d,be_1,be_2,be_3,be_4;
int Max,Min,KoKoKo;
int* mas1;
int* mas2;
int* mas3;
int* mas4;
/*
bool go(){
	if ((t1>=n1)&&(t2>=n2)&&(t3>=n3)&&(t4<n4)) return false;
	if ((t1>=n1)&&(t2>=n2)&&(t3<n3)&&(t4>=n4)) return false;
	if ((t1>=n1)&&(t2<n2)&&(t3>=n3)&&(t4>=n4)) return false;
	if ((t1<n1)&&(t2>=n2)&&(t3>=n3)&&(t4>=n4)) return false;
	return true;
}

int maxnub(int a1,int b1, int c1, int d1)
{
	int* masi=new int[6];
	masi[0]=abs(mas1[a1]-mas2[b1]);
	masi[1]=abs(mas2[b1]-mas3[c1]);
	masi[2]=abs(mas3[c1]-mas4[d1]);
	masi[3]=abs(mas1[a1]-mas3[c1]);
	masi[4]=abs(mas1[a1]-mas4[d1]);
	masi[5]=abs(mas2[b1]-mas4[d1]);
	MergeSort(masi,0,6);
	delete [] masi;
	return masi[5];
}

int rast(int a1,int b1, int c1, int d1)
{
	return abs(mas1[a1]-mas2[b1])+abs(mas2[b1]-mas3[c1])+abs(mas3[c1]-mas4[d1])+abs(mas1[a1]-mas3[c1])+abs(mas1[a1]-mas4[d1])+abs(mas2[b1]-mas4[d1]);
}


int razn(int a1,int b1)
{
	return abs(mas1[a1]-mas2[b1]);
}
*/
void MergeSlit(int* mas, int left, int mid, int right)
{
    int* mas_tmp= new int[right-left];
    int t_1 = 0;
    int t_2 = 0;
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
    for (int i = 0;i<t_1+t_2;i++) mas[left + i] = mas_tmp[i];
    delete [] mas_tmp;
}
 
void MergeSort(int* mas,int left,int right)
{
    if (left + 1 >= right) return;
    int mid = (left + right) / 2;
    MergeSort(mas, left, mid);
    MergeSort(mas, mid, right);
    MergeSlit(mas, left, mid, right);
}

int max_find(int tmp1,int tmp2,int tmp3,int tmp4)
{
	return max(max(tmp1,tmp2),max(tmp3,tmp4));
}

int min_find(int tmp1,int tmp2,int tmp3,int tmp4)
{
	return min(min(tmp1,tmp2),min(tmp3,tmp4));
}

int lets_poishem_best_for_mas1(int k)
{
   int l = -1;            
   int r = n1;    
   while (l < r - 1) {               
       int m = (l + r) / 2;          
		if (mas1[m] < k) {
			l = m;
        }  else{ 
			r =m; 
        }
    }
    return mas1[r];
}

int lets_poishem_best_for_mas2(int k)
{
   int l = -1;            
   int r = n2;    
   while (l < r - 1) {               
       int m = (l + r) / 2;          
		if (mas2[m] < k) {
			l = m;
        }  else{ 
			r =m; 
        }
    }
    return mas2[r];
}

int lets_poishem_best_for_mas3(int k)
{
   int l = -1;            
   int r = n3;    
   while (l < r - 1) {               
       int m = (l + r) / 2;          
		if (mas3[m] < k) {
			l = m;
        }  else{ 
			r =m; 
        }
    }
    return mas3[r];
}

int lets_poishem_best_for_mas4(int k)
{
   int l = -1;            
   int r = n4;    
   while (l < r - 1) {               
       int m = (l + r) / 2;          
		if (mas4[m] < k) {
			l = m;
        }  else{ 
			r =m; 
        }
    }
    return mas4[r];
}


int main()
{
	ifstream fin("style.in");
	ofstream fou("style.out");
	fin>>n1;
	mas1=new int[n1];
	for(int i=0;i<n1;i++) fin>>mas1[i];
	fin>>n2;
	mas2=new int[n2];
	for(int i=0;i<n2;i++) fin>>mas2[i];
	fin>>n3;
	mas3=new int[n3];
	for(int i=0;i<n3;i++) fin>>mas3[i];
	fin>>n4;
	mas4=new int[n4];
	for(int i=0;i<n4;i++) fin>>mas4[i];
	fin.close();
	MergeSort(mas1,0,n1);
	MergeSort(mas2,0,n2);
	MergeSort(mas3,0,n3);
	MergeSort(mas4,0,n4);
	a=mas1[0];
	b=mas2[0];
	c=mas3[0];
	d=mas4[0];
	KoKoKo=100000000;
	for(int i=0;i<n1;i++)
	{
		be_2=lets_poishem_best_for_mas2(mas1[i]);
		be_3=lets_poishem_best_for_mas3(mas1[i]);
		be_4=lets_poishem_best_for_mas4(mas1[i]);
		Max=max_find(mas1[i],be_2,be_3,be_4);
		Min=min_find(mas1[i],be_2,be_3,be_4);
		if  (abs(Max-Min)<KoKoKo) 
		{
			a=mas1[i];
			b=be_2;
			c=be_3;
			d=be_4;
			KoKoKo=abs(Max-Min);
		}
	}
	for(int i=0;i<n2;i++)
	{
		be_1=lets_poishem_best_for_mas1(mas2[i]);
		be_3=lets_poishem_best_for_mas3(mas2[i]);
		be_4=lets_poishem_best_for_mas4(mas2[i]);
		Max=max_find(be_1,mas2[i],be_3,be_4);
		Min=min_find(be_1,mas2[i],be_3,be_4);
		if  (abs(Max-Min)<KoKoKo) 
		{
			a=be_1;
			b=mas2[i];
			c=be_3;
			d=be_4;
			KoKoKo=abs(Max-Min);
		}
	}
	for(int i=0;i<n3;i++)
	{
		be_1=lets_poishem_best_for_mas1(mas3[i]);
		be_2=lets_poishem_best_for_mas2(mas3[i]);
		be_4=lets_poishem_best_for_mas4(mas3[i]);
		Max=max_find(be_1,be_2,mas3[i],be_4);
		Min=min_find(be_1,be_2,mas3[i],be_4);
		if  (abs(Max-Min)<KoKoKo) 
		{
			a=be_1;
			b=be_2;
			c=mas3[i];
			d=be_4;
			KoKoKo=abs(Max-Min);
		}
	}	
	for(int i=0;i<n4;i++)
	{
		be_1=lets_poishem_best_for_mas1(mas4[i]);
		be_2=lets_poishem_best_for_mas2(mas4[i]);
		be_3=lets_poishem_best_for_mas3(mas4[i]);
		Max=max_find(be_1,be_2,be_3,mas4[i]);
		Min=min_find(be_1,be_2,be_3,mas4[i]);
		if  (abs(Max-Min)<KoKoKo) 
		{
			a=be_1;
			b=be_2;
			c=be_3;
			d=mas4[i];
			KoKoKo=abs(Max-Min);
		}
	}
	/*
	int sum=INT_MAX;
	max_nub=maxnub(t1,t2,t3,t4);
	int sum1,sum2,sum3,sum4,tmp1,tmp2,sum_1,sum_2,sum_3,sum_4;
	while(go())
	{
		if ((rast(t1,t2,t3,t4)<sum)&&(maxnub(t1,t2,t3,t4)<=max_nub)) {
			sum=rast(t1,t2,t3,t4);
			a=mas1[t1];
			b=mas2[t2];
			c=mas3[t3];
			d=mas4[t4];
		}
		
		if ((t1<n1)&&(t2<n2)&&(t3<n3)&&(t4<n4)) {
			sum1=INT_MAX;
			sum2=INT_MAX;
			sum3=INT_MAX;
			sum4=INT_MAX;
			sum_1=INT_MAX;
			sum_2=INT_MAX;
			sum_3=INT_MAX;
			sum_4=INT_MAX;
			if (t1+1<n1) sum1=maxnub(t1+1,t2,t3,t4);
			if (t2+1<n2) sum2=maxnub(t1,t2+1,t3,t4);
			if (t3+1<n3) sum3=maxnub(t1,t2,t3+1,t4);
			if (t4+1<n4) sum4=maxnub(t1,t2,t3,t4+1);
			if (t1+1<n1) sum_1=rast(t1+1,t2,t3,t4);
			if (t2+1<n2) sum_2=rast(t1,t2+1,t3,t4);
			if (t3+1<n3) sum_3=rast(t1,t2,t3+1,t4);
			if (t4+1<n4) sum_4=rast(t1,t2,t3,t4+1);
			if ((sum1<sum2)&&((sum_1<sum_2))) {
				tmp1=sum1;
				sum1=sum_1;
			} else {
				tmp1=sum2;
				sum1=sum_2;
			}
			if ((sum3<sum4)&&((sum_3<sum_4))) {
				tmp2=sum3;
				sum2=sum_3;
			} else {
				tmp2=sum4;
				sum2=sum_4;
			}
			if ((tmp1<tmp2)&&((sum1<sum2))) {
				if (tmp1==sum1) {
					t1++;
				} else {
					t2++;
				}
			} else {
				if ((tmp2==sum3)&&((sum2==sum_3))) {
					t3++;
				} else {
					t4++;
				}
			}
		}

		if ((t1>=n1)&&(t2<n2)&&(t3<n3)&&(t4<n4)) {
			sum1=INT_MAX;
			sum2=INT_MAX;
			sum3=INT_MAX;
			sum_1=INT_MAX;
			sum_2=INT_MAX;
			sum_3=INT_MAX;
			if (t2+1<n2) sum1=maxnub(t1-1,t2+1,t3,t4);
			if (t3+1<n3) sum2=maxnub(t1-1,t2,t3+1,t4);
			if (t4+1<n4) sum3=maxnub(t1-1,t2,t3,t4+1);
			if (t2+1<n2) sum_1=rast(t1-1,t2+1,t3,t4);
			if (t3+1<n3) sum_2=rast(t1-1,t2,t3+1,t4);
			if (t4+1<n4) sum_3=rast(t1-1,t2,t3,t4+1);
			if ((sum1<sum2)&&(sum_1<sum_2)) {
				if ((sum1<sum3)&&(sum_1<sum_3)) {
					t2++;
				} else {
					t4++;
				}
			} else {
				if ((sum2<sum3)&&(sum_2<sum_3)) {
					t3++;
				} else {
					t4++;
				}
			}
		}
		
		if ((t1<n1)&&(t2>=n2)&&(t3<n3)&&(t4<n4)) {
			sum1=INT_MAX;
			sum2=INT_MAX;
			sum3=INT_MAX;
			sum_1=INT_MAX;
			sum_2=INT_MAX;
			sum_3=INT_MAX;
			if (t1+1<n1) sum1=maxnub(t1+1,t2-1,t3,t4);
			if (t3+1<n3) sum2=maxnub(t1,t2-1,t3+1,t4);
			if (t4+1<n4) sum3=maxnub(t1,t2-1,t3,t4+1);
			if (t1+1<n1) sum_1=rast(t1+1,t2-1,t3,t4);
			if (t3+1<n3) sum_2=rast(t1,t2-1,t3+1,t4);
			if (t4+1<n4) sum_3=rast(t1,t2-1,t3,t4+1);
			if ((sum1<sum2)&&((sum_1<sum_2))) {
				if ((sum1<sum3)&&((sum_1<sum_3))) {
					t1++;
				} else {
					t4++;
				}
			} else {
				if ((sum2<sum3)&&((sum_2<sum_3))) {
					t3++;
				} else {
					t4++;
				}
			}
		}

		if ((t1<n1)&&(t2<n2)&&(t3>=n3)&&(t4<n4)) {
			sum1=INT_MAX;
			sum2=INT_MAX;
			sum3=INT_MAX;
			sum_1=INT_MAX;
			sum_2=INT_MAX;
			sum_3=INT_MAX;
			if (t1+1<n1) sum1=maxnub(t1+1,t2,t3-1,t4);
			if (t2+1<n2) sum2=maxnub(t1,t2+1,t3-1,t4);
			if (t4+1<n4) sum3=maxnub(t1,t2,t3-1,t4+1);
			if (t1+1<n1) sum_1=rast(t1+1,t2,t3-1,t4);
			if (t2+1<n2) sum_2=rast(t1,t2+1,t3-1,t4);
			if (t4+1<n4) sum_3=rast(t1,t2,t3-1,t4+1);
			if ((sum1<sum2)&&(sum_1<sum_2)) {
				if ((sum1<sum3)&&(sum_1<sum_3)) {
					t1++;
				} else {
					t4++;
				}
			} else {
				if ((sum2<sum3)&&(sum_2<sum_3)) {
					t2++;
				} else {
					t4++;
				}
			}
		}

		if ((t1<n1)&&(t2<n2)&&(t3<n3)&&(t4>=n4)) {
			sum1=INT_MAX;
			sum2=INT_MAX;
			sum3=INT_MAX;
			sum_1=INT_MAX;
			sum_2=INT_MAX;
			sum_3=INT_MAX;
			if (t1+1<n1) sum1=maxnub(t1+1,t2,t3,t4-1);
			if (t2+1<n2) sum2=maxnub(t1,t2+1,t3,t4-1);
			if (t3+1<n3) sum3=maxnub(t1,t2,t3+1,t4-1);
			if (t1+1<n1) sum_1=rast(t1+1,t2,t3,t4-1);
			if (t2+1<n2) sum_2=rast(t1,t2+1,t3,t4-1);
			if (t3+1<n3) sum_3=rast(t1,t2,t3+1,t4-1);
			if ((sum1<sum2)&&(sum_1<sum_2)) {
				if ((sum1<sum3)&&(sum_1<sum_3)) {
					t1++;
				} else {
					t3++;
				}
			} else {
				if ((sum2<sum3)&&(sum_2<sum_3)) {
					t2++;
				} else {
					t3++;
				}
			}
		}
		
		if ((t1>=n1)&&(t2>=n2)&&(t3+1<n3)&&(t4<n4)) 
		{
			if ((maxnub(t1-1,t2-1,t3+1,t4)<maxnub(t1-1,t2-1,t3,t4))&&(rast(t1-1,t2-1,t3+1,t4)<rast(t1-1,t2-1,t3,t4))) 
			{
				t3++;
				continue;
			} else {
				t4++;
				continue;
			}
		}

		if ((t1>=n1)&&(t2+1<n2)&&(t3>=n3)&&(t4<n4))
		{
			if ((maxnub(t1-1,t2+1,t3-1,t4)<maxnub(t1-1,t2,t3-1,t4))&&(rast(t1-1,t2+1,t3-1,t4)<rast(t1-1,t2,t3-1,t4))) 
			{
				t2++;
				continue;
			} else {
				t4++;
				continue;
			}
		}

		if ((t1>=n1)&&(t2+1<n2)&&(t3<n3)&&(t4>=n4)) 
		{
			if ((maxnub(t1-1,t2+1,t3,t4-1)<maxnub(t1-1,t2,t3,t4-1))&&(rast(t1-1,t2+1,t3,t4-1)<rast(t1-1,t2,t3,t4-1))) 
			{
				t2++;
				continue;
			} else {
				t3++;
				continue;
			}
		}

		if ((t1+1<n1)&&(t2>=n2)&&(t3>=n3)&&(t4<n4))
		{
			if ((maxnub(t1+1,t2-1,t3-1,t4)<maxnub(t1,t2-1,t3-1,t4))&&(rast(t1+1,t2-1,t3-1,t4)<rast(t1,t2-1,t3-1,t4))) 
			{
				t1++;
				continue;
			} else {
				t4++;
				continue;
			}
		}

		if ((t1+1<n1)&&(t2>=n2)&&(t3<n3)&&(t4>=n4)) 
		{
			if ((maxnub(t1+1,t2-1,t3,t4-1)<maxnub(t1,t2-1,t3,t4-1))&&(rast(t1+1,t2-1,t3,t4-1)<rast(t1,t2-1,t3,t4-1))) 
			{
				t1++;
				continue;
			} else {
				t3++;
				continue;
			}
		}

		if ((t1+1<n1)&&(t2<n2)&&(t3>=n3)&&(t4>=n4)) 
		{
			if ((maxnub(t1+1,t2,t3-1,t4-1)<maxnub(t1,t2,t3-1,t4-1))&&(rast(t1+1,t2,t3-1,t4-1)<rast(t1,t2,t3-1,t4-1))) 
			{
				t1++;
				continue;
			} else {
				t2++;
				continue;
			}
		}


		if ((t1>=n1)&&(t2>=n2)&&(t3+1==n3)&&(t4+1==n4)) 
		{
			break;
		}

		if ((t1>=n1)&&(t2+1==n2)&&(t3>=n3)&&(t4+1==n4)) 
		{
			break;
		} 

		if ((t1>=n1)&&(t2+1==n2)&&(t3+1==n3)&&(t4>=n4)) 
		{
			break;
		}

		if ((t1+1==n1)&&(t2>=n2)&&(t3>=n3)&&(t4+1==n4)) 
		{
			break;
		}

		if ((t1+1==n1)&&(t2>=n2)&&(t3+1==n3)&&(t4>=n4)) 
		{
			break;
		} 

		if ((t1+1==n1)&&(t2+1==n2)&&(t3>=n3)&&(t4>=n4))
		{
			break;
		} 


	}*/
	fou<<a<<" "<<b<<" "<<c<<" "<<d<<endl;
	fou.close();
	return 0;
}