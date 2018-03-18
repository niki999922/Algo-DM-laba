#include <iostream>
#include <vector>

using namespace std;
vector<string> s;
vector<string> arg;

string toBinary(int n) {
 string r;
 while (n != 0) {
  r = (n % 2 == 0 ? "0" : "1") + r;
  n /= 2;
 }
 return r;
}

bool zer(string s1) {
 return s1[0] == '0';
}

bool ed(string s1) {
 return s1[s1.size() - 1] == '1';
}

bool mon(string s1) {
 for (int l = 2; l <= s1.size(); l *= 2) {
  for (int q = 0; q < s1.size(); q += 2*s1.size() / l) {
   if (s1.substr(q, s1.size() / l) > s1.substr(q + s1.size() / l, s1.size() / l))
    return false;
  }
 }
 return true;
}

bool lin(string s1) {
 int k = 0;
 int mas[s1.size()+5];
 for (char item : s1) {
  mas[k] = int(item == '1');
  k++;
 }
	for (int i = 1; i < s1.size(); ++i) 
	{
		for (int j = 0; j < s1.size(); ++j)	
		{
			mas[j] = (mas[j] ^ mas[j + 1]);
		}
		int c = 0;
		for (char ch: toBinary(i)) {
			if (ch == '1')
			c++;
		}
		if ((c > 1) && (mas[0] == 1)) return false;
	}
 return true;

}

bool dvoistv(string s1) {
 for (int i = 0; i < s1.size(); i++) {
  if (s1[i] == s1[s1.size() - i - 1])
   return false;
 }
 return true;
}

int main() {
 int n = 0;
 cin >> n;

 s.resize(1000);
 arg.resize(1000);
 for (int i = 0; i < n; i++) {
  cin >> arg[i];
  cin >> s[i];
 }
 bool zer1 = true, ed1 = true, dvoistv1 = true, mon1 = true, lin1 = true;
 for (int i = 0; i < n; i++) {
  string item = s[i];
  if (!(zer(item)))
   zer1 = false;
  if (!(ed(item)))
   ed1 = false;
  if (!(dvoistv(item)))
   dvoistv1 = false;
  if (!(mon(item)))
   mon1 = false;
  if (!(lin(item)))
   lin1 = false;
 }
 if (zer1 || ed1 || dvoistv1 || mon1 || lin1)
  cout << "NO";
 else
  cout << "YES";

}