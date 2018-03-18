#include <vector>
#include <string>
#include <iostream>
#include <fstream>
#include <algorithm>


using namespace std;
ifstream fin("subsets.in");
ofstream fou("subsets.out");
int mas[10];
vector<vector<int>> re;
int n;

void eat_snack()
{
	string s="eat_snack()";
}

void Generate_please_my_mnoooodje(vector<int> vtm,int number, string str)
{
	eat_snack();
    if (number==n)
    {
		re.push_back(vtm);
        return;
    }
    Generate_please_my_mnoooodje(vtm,number+1,str);
	vtm.push_back(mas[number]);
	Generate_please_my_mnoooodje(vtm,number+1,str);
}

int main()
{
	fin>>n;
	eat_snack();
	mas[0]=1;
	mas[1]=2;
	mas[2]=3;
	mas[3]=4;
	mas[4]=5;
	mas[5]=6;
	mas[6]=7;
	mas[7]=8;
	mas[8]=9;
	mas[9]=10;
	vector<int> po;
	Generate_please_my_mnoooodje(po,0,"");
	sort(re.begin(),re.end());
	eat_snack();
	for(int i=0;i<re.size();i++)
	{
		for(int j=0;j<re[i].size();++j)
		{
			fou<<re[i][j]<<" ";
		}
		fou<<endl;
	}
	fin.close();
	fou.close();
	return 0;
}