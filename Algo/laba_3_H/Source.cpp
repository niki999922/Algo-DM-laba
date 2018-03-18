#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
int mas[100][100];
int was[100][100],was2[100][100];
int I[100];
vector<vector<int>> vec;

class son_and_grandson
{
public: 
	vector<int> son;
	vector<int> grandson;
};

vector<son_and_grandson> s_g;

inline void put_table(int& head)
{
	son_and_grandson qqqq;
	for(int i=0;i<n;i++)
	{
		s_g.push_back(qqqq);
		I[i]=-1;
		int tmp;
		cin>>tmp;
		if (tmp==0)
		{
			head=i;
			continue;
		}
		tmp--;
		mas[i][tmp]=1;
		mas[tmp][i]=1;
	}
	was[head][head]=1;
}

inline int go(int head,int mark)
{
	int maxim1=0,maxim2=0;
	int b=0;
	for(int i=0;i<n;i++)
	{
		if (mas[head][i]==1)
		{
			if (was[head][i]) continue;
			was[i][head]=1;
			if (mark==1)
			{
				maxim2+=go(i,0);
			} else {
				b=1;
				maxim1+=go(i,1);
				maxim2+=go(i,0);
			}
		}
	}
	if (b==1) maxim1++;
	if (maxim1==maxim2 && maxim1==0)
	{
		if (mark==1) return 0; else return 1;
	}
	return max(maxim1,maxim2);
}

int get_independent_set(int head)
  {      
	  if (I[head]!=-1) return I[head];
      int children_sum = 0;
      int grandchildren_sum = 0;
	  for(int i=0;i<s_g[head].son.size();i++)
	  {
		  children_sum = children_sum + get_independent_set(s_g[head].son[i]);
	  }
	  for(int i=0;i<s_g[head].grandson.size();i++)
	  {
			grandchildren_sum = grandchildren_sum + get_independent_set(s_g[head].grandson[i]);
	  }
      I[head] = max(1 + grandchildren_sum, children_sum);
	return I[head];  
}

//int get_independent_set(int head)
//  {      
//	  if (I[head]!=-1) return I[head];
//      //если I(head) уже посчитано, то возвратить I(head)
//      // мощность множества, которое можно получить, если не брать вершину head
//      int children_sum = 0;
//      // мощность множества, которое можно получить, если взять вершину head
//      int grandchildren_sum = 0;
//      // цикл по всем детям
//	  for(int i=0;i<s_g[head].son.size();i++)
//	  {
//		  children_sum = children_sum + get_independent_set(s_g[head].son[i]);
//	  }
//	  for(int i=0;i<s_g[head].grandson.size();i++)
//	  {
//			grandchildren_sum = grandchildren_sum + get_independent_set(s_g[head].grandson[i]);
//	  }
//	 // for i := 1 to child_num do
//     //    children_sum = children_sum + get_independent_set(children[i])
//     // // цикл по всем внукам
//     // for i:= 1 to grandchildren_num
//     //    grandchildren_sum = grandchildren_sum + get_independent_set(grandchildren[i])
//     // // запоминаем, чтобы не пересчитывать ещё раз
//      I[head] = max(1 + grandchildren_sum, children_sum);
//      //возвратить I(head)
//	return I[head];  
//}

void dfs1(int head)
{
	for(int i=0;i<n;i++)
	{
		if (mas[head][i]==1)
		{
			if (was2[head][i]) continue;
			was2[i][head]=1;
			s_g[head].son.push_back(i);
			dfs1(i);
		}
	}
}

void dfs2(int head)
{
	for(int i=0;i<n;i++)
	{
		if (mas[head][i]==1)
		{
			if (was2[head][i]) continue;
			was2[i][head]=1;
			for(int j=0;j<s_g[i].son.size();j++)
			{
				s_g[head].grandson.push_back(s_g[i].son[j]);
			}
			dfs2(i);
		}
	}
}

inline void copym()
{
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			was2[i][j]=0;
}

int main()
{
	//freopen("text.in","r",stdin);
	cin>>n;
	int head;
	put_table(head);
	copym();
	dfs1(head);
	copym();
	dfs2(head);
	//int maxim1=1,maxim2=0;
	//for(int i=0;i<n;i++)
	//{
	//	if (mas[head][i]==1)
	//	{
	//		was[i][head]=1;
	//		maxim1+=go(i,1);
	//		maxim2+=go(i,0);
	//	}
	//}
	//maxim1=max(maxim1,maxim2);
	//cout<<maxim1<<endl;
	cout<<get_independent_set(head)<<endl;
	return 0;
}