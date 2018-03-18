#include <iostream>
#include <cmath>
#include <string>

using namespace std;

int mas[5][32];
int s[32];
int n, b, maxch = 0;
long tmp;
int stepen[6], flagmas[5];
int flag = 0, pis;
string str;

void vivod() {
    for (int i = 0; i < 32; i++) {
        for (int j = 0; j < n; j++)
            cout << mas[j][i] << " ";
        cout << endl;
    }
}

int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> tmp;
        str = ""; // not super fast
        while (tmp > 0) {
            if (tmp % 2 == 0) str = str + "0"; else str = str + "1";
            tmp /= 2;
        }
        tmp = 0;
        for (int j = 0u; j < str.length(); ++j) {
            mas[i][tmp] = char(str[j] - '0');
            ++tmp;
        }
        stepen[i] = tmp;
        if (tmp < 32) {
            mas[i][tmp] = 0;
            ++tmp;
        }
        if (stepen[i] > stepen[maxch]) maxch = i;
    }

    cin >> tmp;
	if (tmp==0) {cout<<"1&~1"; return 0;}
    str = ""; // not super fast
    while (tmp > 0) {
        if (tmp % 2 == 0) str = str + "0"; else str = str + "1";
        tmp /= 2;
    }
    tmp = 0;
    for (int j = 0u; j < str.length(); ++j) {
        s[tmp] = char(str[j] - '0');
        ++tmp;
    }
    stepen[5] = tmp;
    if (tmp < 32) {
        s[tmp] = 0;
        ++tmp;
    }















    // vivod();
    /*  for(int i=0;i<6;i++) cout<<stepen[i]<<" ";
      cout<<endl;
      cout<<maxch<<endl;
    */
    if (stepen[maxch] < stepen[5]) {
        for (int i = 1; i < 32 - stepen[maxch]; ++i) {
            if (s[stepen[maxch] + i] == 0) {
                cout << "Impossible";
                return 0;
            }
        }
    }

    if (stepen[maxch] < stepen[5]) {
        for (int i = 0; i < 32; i++) s[i] = 1 - s[i];
        flag = 1;
    }
    //kogda 10101000000000 to cherez orrrr x1 x2  and x1 -x2 and -x1 x2 and x1 x2
    //kogda 0110011111111 to cherez and x1 x2 or x1 x2 or -x1 x2  or x1 -x2  NNNOOOOOO











    pis = 1;
    for (int i = 0; i < stepen[maxch] + 1; ++i) {
        tmp = mas[0][i];
        for (int j = 1; j < n; ++j) {
            if (mas[j][i] == 1) tmp = 1;
        }
        if (tmp != s[i]) {
            pis = 0;
            break;
        }
    }
    if (pis == 1) {
        if (flag == 1) cout << "~(";
        for (int i = 0; i < n; ++i) {
            if (i != n - 1) cout << i + 1 << "|"; else cout << i + 1;
        }
        if (flag == 1) cout << ")";
        return 0;
    }




















    for (int i = 0; i < static_cast<int>(pow(2, n)) - 1; i++) {
        for (int j = 0; j < 5; ++j) {
            flagmas[j] = 0;
        }

        tmp = i;
        str = "";
        while (tmp > 0) {
            if (tmp % 2 == 0) str = str + "0"; else str = str + "1";
            tmp /= 2;
        }
        tmp = 0;
        for (int j = 0; j < str.length(); ++j) {
            flagmas[tmp] = char(str[j] - '0');
            ++tmp;
        }
        if (tmp < 5) {
            mas[i][tmp] = 0;
            ++tmp;
        }


        pis = 1;
        for (int z = 0; z < stepen[maxch] + 1; ++z) {
            if (flagmas[0] == 1) tmp = 1 - mas[0][z]; else tmp = mas[0][z];
            for (int j = 1; j < n; ++j) {
                if (flagmas[j] == 1) tmp = tmp * (1 - mas[j][z]); else tmp = tmp * mas[j][z];
            }
            if (tmp != s[z]) {
                pis = 0;
                break;
            }
        }
        if (pis == 1) {
            if (flag == 1) cout << "~(";
            for (int i = 0; i < n; ++i) {
                if (i != n - 1) {
                    if (flagmas[i] == 0) cout << i + 1 << "&"; else cout << "~" << i + 1 << "&";
                } else {
                    if (flagmas[i] == 0) cout << i + 1; else cout << "~" << i + 1;
                }
            }
            if (flag == 1) cout << ")";
            return 0;
        }
    }
    cout << "Impossible";
    return 0;
}


//4294967295