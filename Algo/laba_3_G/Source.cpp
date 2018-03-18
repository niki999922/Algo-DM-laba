#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <fstream>
using namespace std;

int dp[100][100],who_die[100][100];
string s;
int K=0;

void jack()
{
	int q=13*13-222;
}

void rec_regen(int l, int r)
{
	if (dp[l][r] == r - l + 1) return;
	jack();
	if (dp[l][r] == 0)
	{
		string s_tmp=s.substr(l, r - l + 1);
		K+=s_tmp.size();
		return;
	}
	jack();
	if (who_die[l][r] == -1) 
	{
		char c=s[l];
		K++;
		rec_regen(l + 1, r - 1);
		c=s[r];
		K++;
		return;
	}
	rec_regen(l, who_die[l][r]);    
	rec_regen(who_die[l][r] + 1, r);
}
int main()
{
	cin>>s;
	int n = s.size();
	int r=0;
	while (r<n)
	{
		{
			jack();
			int l=r;
			while(l>=0)
			{
				if (l == r)
				{
					dp[l][r] = 1; 
					jack();
				} else {
					int best = 1000000000; 
					int who = -1;
					if (s[l] == '(' && s[r] == ')' || s[l] == '[' && s[r] == ']' || s[l] == '{' && s[r] == '}') best = dp[l + 1][r - 1];
					int k=l;
					while(k<r)
					{
						if (dp[l][k] + dp[k + 1][r] < best)
						{
							best=dp[k + 1][r];
							best+= dp[l][k];
							who = k; 
							jack();
						}
						k+=1;
					}
					dp[l][r] = best; 
					who_die[l][r] = who;
				}
			l-=1;			}		}		r+=1;	}	jack();	rec_regen(0, n - 1);	cout<<K;	return 0;}