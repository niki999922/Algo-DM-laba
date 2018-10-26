#include <iostream>
#include <fstream>


using namespace std;

ifstream fin("partition.in");
ofstream fou("partition.out");

int sl[2000];

void slag(int u,int p,int n_o)
{
	if (n_o == 0) 
	{
		for(int i=0;i<u-1;i++) fou<<sl[i]<<"+";		
		fou<<sl[u-1]<<endl;	
	//	for(int i=1;i<=u-1;i++) cout<<sl[i]<<"+";		
	//	cout<<sl[u]<<endl;;
	} else {
		//for(int i=p+2;i<=n_o;i++)
		for(int i=p;i<=n_o;i++)
		{
			//sl[u+1]=i;
			//slag(u+1,i,n_o-i);	
			sl[u]=i;
			slag(u+1,i,n_o-i);
		}   
	}
}




int main()
{
	int n;
	fin>>n;
	//slag(0,-1,n);
	slag(0,1,n);
	fin.close();
	fou.close();
	return 0;
}