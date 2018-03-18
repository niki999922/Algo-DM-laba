#include <iostream>
#include <fstream>
#include <string>
#include <vector>
using namespace std;

ifstream fin("kenobi.in");
ofstream fou("kenobi.out");
	

class eque
{
public:
    eque *next;
	eque *last;
    int x;
};
 
eque *q,*go;
 

class Deque
{
private:
    eque *begin;
    eque *end;
    int size_d;
public:
    int size()
    {
        return size_d;
    }
 
    void push_back(int l)
    {
        eque* t=new eque;
        if (size_d==0)
        {
            begin=t;
            end=t;
            t->x=l;
            t->next=t;
			t->last=t;
            ++size_d;
        } else {
            end->next=t;
			t->next=begin;
			begin->last=t;
			t->last=end;
			end=t;
            end->x=l;
            ++size_d;
        }
    }
 
    int front()
    {
        return begin->x;
    }
 
    void pop_front()
    {
        q=begin;
        end->next=begin->next;
        begin=begin->next;
        delete q;
        size_d--;
    }
	
	void pop_back()
    {
        q=end;
		end->last->next=begin;
		begin->last=end->last;
		end=end->last;
		delete q;
        size_d--;
    }

	void mam_aaaaaaa()
	{
		go=begin;
		for(int i=0;i<size_d/2;i++)
		{
			go=go->next;
		}
		go=go->last;
		begin=go->next;
		end=go;
	}

	void print_sost()
	{
		go=begin;
		for(int i=0;i<size_d;i++)
		{
			fou<<go->x<<" ";
			go=go->next;
		}
	} 
};

string st;
int tmp;
Deque d;
vector<int> v;

int main()
{
	std::ios::sync_with_stdio(false);
	while (!(fin.eof())) {
        if (fin.eof()) continue;
        fin >> st;
		if (st == "add")
		{
			fin>>tmp;
			v.push_back(tmp);
			//d.push_back(tmp);
		}
		if (st == "take")
		{
			if (v.size()==0) continue;	
			v.pop_back();
			//d.pop_back();
		}
		if (st == "mum!")
		{
			if (v.size()<2) continue;
			int t=v.size()/2;
			v.insert(v.end(),v.begin(),v.begin()+t);
			v.erase(v.begin(),v.begin()+t);
			//d.mam_aaaaaaa();
		}	
		st="";
	}
	fou<<v.size()<<endl;
	//fou<<d.size()<<endl;
	for(auto it : v) fou<<it<<" ";
	//d.print_sost();
	fin.close();
	fou.close();
	return 0;
}