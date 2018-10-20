#include <iostream>
using namespace std;

long long mas[10][101];
int n;
int main()
{
	cin>>n;
	for(int i=0;i<10;i++) mas[i][1]=1;
	mas[0][1]=0;
	mas[8][1]=0;
	for(int i=2;i<=n;i++)
	{
		for(int j=0;j<10;j++)
		{
			if (j==5)
			{
				mas[j][i]=0;
				continue;
			}
			switch (j)  
			{  
				case (0):
					mas[j][i]=mas[4][i-1]+mas[6][i-1];
					
					break;  
				case (1):  
					mas[j][i]=mas[6][i-1]+mas[8][i-1];
					break;
				case (2):  
					mas[j][i]=mas[7][i-1]+mas[9][i-1];
					break;
				case (3):  
					mas[j][i]=mas[4][i-1]+mas[8][i-1];
					break;
				case (4):  
					mas[j][i]=mas[3][i-1]+mas[9][i-1]+mas[0][i-1];
					break;
				case (6):  
					mas[j][i]=mas[1][i-1]+mas[7][i-1]+mas[0][i-1];
					break;
				case (7):  
					mas[j][i]=mas[2][i-1]+mas[6][i-1];
					break;
				case (8):  
					mas[j][i]=mas[1][i-1]+mas[3][i-1];
					break;
				case (9):  
					mas[j][i]=mas[2][i-1]+mas[4][i-1];
					break;
			}
			mas[j][i]=mas[j][i]%1000000000;
		}
	}
	long long sum=0;
	for(int i=0;i<10;i++)
	{
		sum+=mas[i][n];
	}
	cout<<sum%1000000000<<endl;
	return 0;
}