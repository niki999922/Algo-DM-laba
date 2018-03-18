#include <iostream>
#include <fstream>
#include <string>
#include <sstream>

using namespace std;
long long n;
long long size=0;
long glub;

class Stack
{
public:
	long long ur;
	long long sum_ur;
	Stack *last;

	void push(long long a,Stack*& stacc)
	{
		if (size==0)
		{
			ur=a;
			last=NULL;
			sum_ur=a;
			++size;
		} else {
			Stack *q=new Stack;
			q->ur=a;
			q->last=stacc;
			q->sum_ur=a+stacc->sum_ur;
			stacc=q;
			++size;
		}
	}

	void pop(Stack*& stacc)
	{
		if (size>0)
		{
			--size;
			Stack* tmpq = stacc->last;
			delete stacc;
			stacc=tmpq;
		}
	}

	long long hight_blood(long long k)
	{
		if (k>1) return (last->hight_blood(k-1)+ur); 
		return this->ur;
	}
	long long g_b()
	{
		--glub;
		if (glub>1) return last->g_b();
		return sum_ur;
	}

};

struct mas_t
{
	long ur;
	long sumur;
};

mas_t mas[50000];
long r_m=0;

int main()
{
	ifstream fin("hemoglobin.in");
	ofstream fou("hemoglobin.out");
	Stack *s=new Stack;
//	size=0;
	fin>>n;
	string tmp;
	long long tmp1;
	mas[0].ur=0;
	mas[0].sumur=0;
	++r_m;
	for(long long i=0;i<n;++i)
	{
		fin>>tmp;
		if (tmp[0]=='+')
		{
			stringstream ss;
			ss<<tmp.substr(1);
			ss>>tmp1;
			mas[r_m].ur=tmp1;
			if (r_m>0) mas[r_m].sumur=tmp1+mas[r_m-1].sumur; else mas[0].sumur=tmp1;
			++r_m;
			//s->push(tmp1,s);
			continue;
		}
		if (tmp[0]=='-')
		{
			fou<<mas[r_m-1].ur<<endl;
			//cout<<s->ur<<endl;
			//s->pop(s);
			--r_m;
			continue;
		}
		if (tmp[0]=='?')
		{
			stringstream ss;
			ss<<tmp.substr(1);
			ss>>tmp1;
			//cout<<s->hight_blood(tmp1)<<endl;
			fou<<(mas[r_m-1].sumur-mas[r_m-1-tmp1].sumur)<<endl;
			continue;
		}		
	}
	fin.close();
	fou.close();
	return 0;
}