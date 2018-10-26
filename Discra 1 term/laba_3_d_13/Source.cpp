#include <iostream>
#include <fstream>
#include <string>
 
using namespace std;
 
ifstream fin("num2perm.in");
ofstream fou("num2perm.out");
 
long long M,Y=-1,y;
long long mas[20];
long long mas_f[20];
long long cont_prefix(long long n)
{
	return mas_f[n];
}

void rec(long long n)
{
    if (n!=0)
    {
        for(long long j=1;j<=M;++j)
        {
			long long e=0;
            for(long long i=0;i<M-n;i++)
            {
                if (mas[i]==j) {e=1;break;}
            }
            if (e==1) continue;
			if (Y+cont_prefix(n-1)<y) {Y+=cont_prefix(n-1); continue;}
            mas[M-n]=j;
            rec(n-1);
			break;
        }
    } else {
        for(long long i=0;i<M;i++)
        {
        fou<<mas[i]<<" ";
        }
        fou<<endl;
	}
}
 
int main()
{
	mas_f[0]=1;
    mas_f[1]=1;
	mas_f[2]=2;
    mas_f[3]=6;
	mas_f[4]=24;
    mas_f[5]=120;
	mas_f[6]=720;
    mas_f[7]=5040;
	mas_f[8]=40320;
    mas_f[9]=362880;
	mas_f[10]=3628800;
	mas_f[11]=39916800;
	mas_f[12]=479001600;
	mas_f[13]=6227020800;
	mas_f[14]=87178291200;
	mas_f[15]=1307674368000;
	mas_f[16]=20922789888000;
	mas_f[17]=355687428096000;
	mas_f[18]=6402373705728000;
	mas_f[19]=121645100408832000;
	long long n;
    fin>>n>>y;
    M=n;
    rec(n);
    fin.close();
    fou.close();
    return 0;
}