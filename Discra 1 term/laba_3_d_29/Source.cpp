#include <iostream>
#include <fstream>
#include <string>
#include <sstream>

using namespace std;

ifstream fin("nextpartition.in");
ofstream fou("nextpartition.out");


int sl[2000];
int fir=0,b=0,nac,nos,findp,ttt1,ttt2;
string str,str_tmp;


int fromString(string s) 
{
  istringstream iss(s);
  int res;
  iss >> res;
  return res;
}

void slag(int u,int p,int n_o)
{
	if (n_o == 0)  
	{
		//if (fir==0) { fir=1;return;}
		//fou<<nac<<"=";
		for(int i=0;i<u-1;i++) fou<<sl[i]<<"+";		
		fou<<sl[u-1];	
		b=1;
	} else {
		for(int i=p;i<=n_o;i++)
		{
			if (b==1) return;
			//if (fir==0) 
			//{
			//	findp=str.find("+");
			//	i=fromString(str.substr(0,findp));
			//	str=str.substr(findp+1);
			//}
			//if ((2*i>n_o)&& (i<n_o)) i=n_o;
			sl[u]=i;
			slag(u+1,i,n_o-i);
		}   
	}
}




int main()
{
	
	int n,ost;
	fin>>str;
	findp=str.find("=");
	if (str.substr(0,findp)== str.substr(findp+1)) {fou<<"No solution"; return 0;}
	n=fromString(str.substr(0,findp));
	findp=str.rfind("+");
	str_tmp=str.substr(findp+1);
	ttt1=fromString(str_tmp);
	str=str.substr(0,findp);
	findp=str.rfind("+");
	if (findp==string::npos) findp=str.rfind("=");
	str_tmp=str.substr(findp+1);
	ttt2=fromString(str_tmp);
	str=str.substr(0,findp+1);
	fou<<str;
	nos=ttt1+ttt2;
	++ttt2;
	if((ttt2)*2>nos)
	{
		fou<<nos;
	} else {
		if ((nos%ttt2)==0)
		{
			for(int i=0;i<nos/(ttt2)-1;++i) fou<<ttt2<<"+";
			fou<<ttt2;
		} else {
			ost=nos;
			for(int i=0;i<nos/(ttt2)-1;++i) {ost-=ttt2;fou<<ttt2<<"+";}
			fou<<ost;
		}
		//slag(0,ttt2+1,nos);
	}
	fin.close();
	fou.close();
	return 0;
}