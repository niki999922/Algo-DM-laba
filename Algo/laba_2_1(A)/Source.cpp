#include <iostream>
#include <fstream>
#include <stack>

using namespace std;

char c;
stack<long long> s;
long long q1,q2;

int main()
{
	ifstream fin("postfix.in");
	ofstream fou("postfix.out");
	while (!(fin.eof()))
	{
		fin>>c;
		if (fin.eof()) continue;
		if (s.empty())
		{
			s.push((c-'0'));
			continue;
		}
		if ((c=='+') || (c=='-') || (c=='*'))
		{
			q1=s.top();
			s.pop();
			q2=s.top();
			s.pop();
			if (c=='+')
			{	
				s.push(q1+q2);
				continue;
			}
			if (c=='-')
			{
				s.push(q2-q1);
				continue;
			}
			if (c=='*')
			{	
				s.push(q1*q2);
				continue;
			}
		} else {
			s.push((c-'0'));
		}
	}
	fou<<s.top();
	fin.close();
	fou.close();
	return 0;
}