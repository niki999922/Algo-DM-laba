#include <iostream>
#include <fstream>
#include <string> 
#include <algorithm>
using namespace std;
 
long long mas[1001000];
long long star[501000];
int n;
int start;
int val;
 
void set(long long v,int tl, int tr,int pos)
{
	if (tl>tr || tr < pos || tl > pos)
		return;
    if (tl == tr)
	{
		mas[v] = val;
		return;
	}
    int tmp=(tl+tr)>>1;
    if (pos <= tmp)
        set((v<<1)+1,tl,tmp,pos);
    else
        set((v<<1)+2,tmp+1,tr,pos);
    mas[v] = mas[v*2+1] + mas[v*2+2];
}
 
long long sum_el(int v,int tl, int tr,int l, int r)
{
    if (l > r)
        return 0;
	if (tl>tr || tr < l || tl > r)
		return 0;
    if (l<=tl && tr<= r)
        return mas[v];
    int tmp=(tl+tr) >> 1;
    return sum_el((v<<1)+1,tl,tmp,l,min(r,tmp))+sum_el((v<<1)+2,tmp+1,tr,max(l,tmp+1),r);
}
 
 
inline int get_hight() 
{
    int l = n - 1;
    int i = 0;
    while (l > 0)
    {
        ++i;
        l = l >> 1;
    }
    return i;
}


void build (int v, int tl, int tr) {
	if (tl>n) return;
	if (tl == tr)
		mas[v] = star[tl-1];
	else {
		int tm = (tl + tr) / 2;
		build (v*2+1, tl, tm);
		build (v*2+2, tm+1, tr);
		mas[v] = mas[v*2+1] + mas[v*2+2];
	}
}

int main()
{       
    ios_base:: sync_with_stdio(false);
    ifstream fin("rsq.in");
    ofstream fou("rsq.out");
    fin>>n;
    start=(1<<get_hight())- 1;
    int line_l=start+1;
	for(int i = 0;i < n; ++i) 
        fin>>star[i];
	build(0,1,line_l);
    string str;
    int x,tmp;
    
    while(fin>>str>>x>>tmp) 
    {
        if (str == "sum") 
        {
            fou<<sum_el(0,1,line_l,x,tmp)<<endl;
        } 
        if (str == "set") {
            val=tmp;
            set(0,1,line_l,x);
        }
    }
    fin.close();
    fou.close();
    return 0;
}