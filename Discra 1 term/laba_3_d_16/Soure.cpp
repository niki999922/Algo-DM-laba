#include <iostream>
#include <fstream>
#include <vector>
 
using namespace std;
 
ifstream fin("choose2num.in");
ofstream fou("choose2num.out");
long long n,k,m;
long long mas[40];
long long mas_f[31][31];	
 
//a=k b=n;

//long long cs(long long a,long long b)
//{
//	if (b==21) return ((mas_f[20])/(mas_f[a]*mas_f[b-a]))*21;
//	if (b==22) return ((mas_f[20])/(mas_f[a]*mas_f[b-a]))*21*22;
//	if (b==23) return ((mas_f[20])/(mas_f[a]*mas_f[b-a]))*21*22*23;
//	if (b==24) return ((mas_f[20])/(mas_f[a]*mas_f[b-a]))*21*22*23*24;
//	if (b==25) return ((mas_f[20])/(mas_f[a]*mas_f[b-a]))*21*22*23*24*25;
//	if (b==26) return ((mas_f[20])/(mas_f[a]*mas_f[b-a]))*21*22*23*24*25*26;
//	if (b==27) return ((mas_f[20])/(mas_f[a]*mas_f[b-a]))*21*22*23*24*25*26*27;
//	if (b==28) return ((mas_f[20])/(mas_f[a]*mas_f[b-a]))*21*22*23*24*25*26*27*28;
//	if (b==29) return ((mas_f[20])/(mas_f[a]*mas_f[b-a]))*21*22*23*24*25*26*27*28*29;
//	if (b==30) return ((mas_f[20])/(mas_f[a]*mas_f[b-a]))*21*22*23*24*25*26*27*28*29*30;
//	return mas_f[b]/(mas_f[a]*mas_f[b-a]);
//}

bool next_el() 
{
    for (long long i=k-1;i>=0;--i)
        if (mas[i] < n - k + i + 1) 
        {
            ++mas[i];
            for (long long j=i+1; j<k; ++j)	
            {
				just();
                int tmp=mas[j-1];
                ++tmp;
                mas[j]=tmp;
            }
            return true;
        }
    return false;
}
 
 
int main()
{
	
	mas_f[1][1]=1;
    
	mas_f[2][1]=2;
    mas_f[2][2]=1;

	mas_f[3][1]=3;
	mas_f[3][2]=3;
	mas_f[3][3]=1;

    mas_f[4][1]=4;
    mas_f[4][2]=6;
    mas_f[4][3]=4;
    mas_f[4][4]=1;

    mas_f[5][1]=5;
    mas_f[5][2]=10;
    mas_f[5][3]=10;
    mas_f[5][4]=5;
    mas_f[5][5]=1;
    
	mas_f[6][1]=6;
    mas_f[6][2]=15;
    mas_f[6][3]=20;
    mas_f[6][4]=15;
    mas_f[6][5]=6;
    mas_f[6][6]=1;
    
	mas_f[7][1]=7;
    mas_f[7][2]=21;
    mas_f[7][3]=35;
    mas_f[7][4]=35;
    mas_f[7][5]=21;
    mas_f[7][6]=7;
    mas_f[7][7]=1;
    
	mas_f[8][1]=8;
    mas_f[8][2]=28;
    mas_f[8][3]=56;
    mas_f[8][4]=70;
    mas_f[8][5]=56;
    mas_f[8][6]=28;
    mas_f[8][7]=8;
    mas_f[8][8]=1;
    
	mas_f[9][1]=9;
    mas_f[9][2]=36;
    mas_f[9][3]=84;
    mas_f[9][4]=126;
    mas_f[9][5]=126;
    mas_f[9][6]=84;
    mas_f[9][7]=36;
    mas_f[9][8]=9;
    mas_f[9][9]=1;
    
	mas_f[10][1]=10;
	mas_f[10][2]=45;
	mas_f[10][3]=120;
	mas_f[10][4]=210;
	mas_f[10][5]=252;
	mas_f[10][6]=210;
	mas_f[10][7]=120;
	mas_f[10][8]=45;
	mas_f[10][9]=10;
	mas_f[10][10]=1;
			  
    mas_f[11][1]=11;
    mas_f[11][2]=55;
    mas_f[11][3]=165;
    mas_f[11][4]=330;
    mas_f[11][5]=462;
    mas_f[11][6]=462;
    mas_f[11][7]=330;
    mas_f[11][8]=165;
    mas_f[11][9]=55;
    mas_f[11][10]=11;
    mas_f[11][11]=1;
    		  
	mas_f[12][1]=12;
    mas_f[12][2]=66;
    mas_f[12][3]=220;
    mas_f[12][4]=495;
    mas_f[12][5]=792;
    mas_f[12][6]=924;
    mas_f[12][7]=792;
    mas_f[12][8]=495;
    mas_f[12][9]=220;
    mas_f[12][10]=66;
    mas_f[12][11]=12;
    mas_f[12][12]=1;
    		  
	mas_f[13][1]=13;
    mas_f[13][2]=78;
    mas_f[13][3]=286;
    mas_f[13][4]=715;
    mas_f[13][5]=1287;
    mas_f[13][6]=1716;
    mas_f[13][7]=1716;
    mas_f[13][8]=1287;
    mas_f[13][9]=715;
    mas_f[13][10]=286;
    mas_f[13][11]=78;
    mas_f[13][12]=13;
    mas_f[13][13]=1;
    
	mas_f[14][1]=14;
    mas_f[14][2]=91;
    mas_f[14][3]=364;
    mas_f[14][4]=1001;
    mas_f[14][5]=2002;
    mas_f[14][6]=3003;
    mas_f[14][7]=3432;
    mas_f[14][8]=3003;
    mas_f[14][9]=2002;
    mas_f[14][10]=1001;
    mas_f[14][11]=364;
    mas_f[14][12]=91;
    mas_f[14][13]=14;
    mas_f[14][14]=1;
    		 
	mas_f[15][1]=15;
    mas_f[15][2]=105;
    mas_f[15][3]=455;
    mas_f[15][4]=1365;
    mas_f[15][5]=3003;
    mas_f[15][6]=5005;
    mas_f[15][7]=6435;
    mas_f[15][8]=6435;
    mas_f[15][9]=5005;
    mas_f[15][10]=3003;
    mas_f[15][11]=1365;
    mas_f[15][12]=455;
    mas_f[15][13]=105;
    mas_f[15][14]=15;
    mas_f[15][15]=1;
    		 
	mas_f[16][1]=16;
    mas_f[16][2]=120;
    mas_f[16][3]=560;
    mas_f[16][4]=1820;
    mas_f[16][5]=4368;
    mas_f[16][6]=8008;
    mas_f[16][7]=11440;
    mas_f[16][8]=12870;
    mas_f[16][9]=11440;
    mas_f[16][10]=8008;
    mas_f[16][11]=4368;
    mas_f[16][12]=1820;
    mas_f[16][13]=560;
    mas_f[16][14]=120;
    mas_f[16][15]=16;
    mas_f[16][16]=1;
    		
	mas_f[17][1]=17;
    mas_f[17][2]=136;
    mas_f[17][3]=680;
    mas_f[17][4]=2380;
    mas_f[17][5]=6188;
    mas_f[17][6]=12376;
    mas_f[17][7]=19448;
    mas_f[17][8]=24310;
    mas_f[17][9]=24310;
    mas_f[17][10]=19448;
    mas_f[17][11]=12376;
    mas_f[17][12]=6188;
    mas_f[17][13]=2380;
    mas_f[17][14]=680;
    mas_f[17][15]=136;
    mas_f[17][16]=17;
    mas_f[17][17]=1;
    		
	mas_f[18][1]=18;
    mas_f[18][2]=153;
    mas_f[18][3]=816;
    mas_f[18][4]=3060;
    mas_f[18][5]=8568;
    mas_f[18][6]=18564;
    mas_f[18][7]=31824;
    mas_f[18][8]=43758;
    mas_f[18][9]=48620;
    mas_f[18][10]=43758;
    mas_f[18][11]=31824;
    mas_f[18][12]=18564;
    mas_f[18][13]=8568;
    mas_f[18][14]=3060;
    mas_f[18][15]=816;
    mas_f[18][16]=153;
    mas_f[18][17]=18;
    mas_f[18][18]=1;
    		
	mas_f[19][1]=19;
	mas_f[19][2]=171;
	mas_f[19][3]=969;
	mas_f[19][4]=3876;
	mas_f[19][5]=11628;
	mas_f[19][6]=27132;
	mas_f[19][7]=50388;
	mas_f[19][8]=75582;
	mas_f[19][9]=92378;
	mas_f[19][10]=92378;
	mas_f[19][11]=75582;
	mas_f[19][12]=50388;
	mas_f[19][13]=27132;
	mas_f[19][14]=11628;
	mas_f[19][15]=3876;
	mas_f[19][16]=969;
	mas_f[19][17]=171;
	mas_f[19][18]=19;
	mas_f[19][19]=1;
			
	mas_f[20][1]=20;
	mas_f[20][2]=190;
	mas_f[20][3]=1140;
	mas_f[20][4]=4845;
	mas_f[20][5]=15504;
	mas_f[20][6]=38760;
	mas_f[20][7]=77520;
	mas_f[20][8]=125970;
	mas_f[20][9]=167960;
	mas_f[20][10]=184756;
	mas_f[20][11]=167960;
	mas_f[20][12]=125970;
	mas_f[20][13]=77520;
	mas_f[20][14]=38760;
	mas_f[20][15]=15504;
	mas_f[20][16]=4845;
	mas_f[20][17]=1140;
	mas_f[20][18]=190;
	mas_f[20][19]=20;
	mas_f[20][20]=1;
			
	mas_f[21][1]=21;
	mas_f[21][2]=210;
	mas_f[21][3]=1330;
	mas_f[21][4]=5985;
	mas_f[21][5]=20349;
	mas_f[21][6]=54264;
	mas_f[21][7]=116280;
	mas_f[21][8]=203490;
	mas_f[21][9]=293930;
	mas_f[21][10]=352716;
	mas_f[21][11]=352716;
	mas_f[21][12]=293930;
	mas_f[21][13]=203490;
	mas_f[21][14]=116280;
	mas_f[21][15]=54264;
	mas_f[21][16]=20349;
	mas_f[21][17]=5985;
	mas_f[21][18]=1330;
	mas_f[21][19]=210;
	mas_f[21][20]=21;
	mas_f[21][21]=1;
			
	mas_f[22][1]=22;
	mas_f[22][2]=231;
	mas_f[22][3]=1540;
	mas_f[22][4]=7315;
	mas_f[22][5]=26334;
	mas_f[22][6]=74613;
	mas_f[22][7]=170544;
	mas_f[22][8]=319770;
	mas_f[22][9]=497420;
	mas_f[22][10]=646646;
	mas_f[22][11]=705432;
	mas_f[22][12]=646646;
	mas_f[22][13]=497420;
	mas_f[22][14]=319770;
	mas_f[22][15]=170544;
	mas_f[22][16]=74613;
	mas_f[22][17]=26334;
	mas_f[22][18]=7315;
	mas_f[22][19]=1540;
	mas_f[22][20]=231;
	mas_f[22][21]=22;
	mas_f[22][22]=1;
			
	mas_f[23][1]=23;
	mas_f[23][2]=253;
	mas_f[23][3]=1771;
	mas_f[23][4]=8855;
	mas_f[23][5]=33649;
	mas_f[23][6]=100947;
	mas_f[23][7]=245157;
	mas_f[23][8]=490314;
	mas_f[23][9]=817190;
	mas_f[23][10]=1144066;
	mas_f[23][11]=1352078;
	mas_f[23][12]=1352078;
	mas_f[23][13]=1144066;
	mas_f[23][14]=817190;
	mas_f[23][15]=490314;
	mas_f[23][16]=245157;
	mas_f[23][17]=100947;
	mas_f[23][18]=33649;
	mas_f[23][19]=8855;
	mas_f[23][20]=1771;
	mas_f[23][21]=253;
	mas_f[23][22]=23;
	mas_f[23][23]=1;
			
	mas_f[24][1]=24;
	mas_f[24][2]=276;
	mas_f[24][3]=2024;
	mas_f[24][4]=10626;
	mas_f[24][5]=42504;
	mas_f[24][6]=134596;
	mas_f[24][7]=346104;
	mas_f[24][8]=735471;
	mas_f[24][9]=1307504;
	mas_f[24][10]=1961256;
	mas_f[24][11]=2496144;
	mas_f[24][12]=2704156;
	mas_f[24][13]=2496144;
	mas_f[24][14]=1961256;
	mas_f[24][15]=1307504;
	mas_f[24][16]=735471;
	mas_f[24][17]=346104;
	mas_f[24][18]=134596;
	mas_f[24][19]=42504;
	mas_f[24][20]=10626;
	mas_f[24][21]=2024;
	mas_f[24][22]=276;
	mas_f[24][23]=24;
	mas_f[24][24]=1;
			
	mas_f[25][1]=25;
	mas_f[25][2]=300;
	mas_f[25][3]=2300;
	mas_f[25][4]=12650;
	mas_f[25][5]=53130;
	mas_f[25][6]=177100;
	mas_f[25][7]=480700;
	mas_f[25][8]=1081575;
	mas_f[25][9]=2042975;
	mas_f[25][10]=3268760;
	mas_f[25][11]=4457400;
	mas_f[25][12]=5200300;
	mas_f[25][13]=5200300;
	mas_f[25][14]=4457400;
	mas_f[25][15]=3268760;
	mas_f[25][16]=2042975;
	mas_f[25][17]=1081575;
	mas_f[25][18]=480700;
	mas_f[25][19]=177100;
	mas_f[25][20]=53130;
	mas_f[25][21]=12650;
	mas_f[25][22]=2300;
	mas_f[25][23]=300;
	mas_f[25][24]=25;
	mas_f[25][25]=1;
			
	mas_f[26][1]=26;
	mas_f[26][2]=325;
	mas_f[26][3]=2600;
	mas_f[26][4]=14950;
	mas_f[26][5]=65780;
	mas_f[26][6]=230230;
	mas_f[26][7]=657800;
	mas_f[26][8]=1562275;
	mas_f[26][9]=3124550;
	mas_f[26][10]=5311735;
	mas_f[26][11]=7726160;
	mas_f[26][12]=9657700;
	mas_f[26][13]=10400600;
	mas_f[26][14]=9657700;
	mas_f[26][15]=7726160;
	mas_f[26][16]=5311735;
	mas_f[26][17]=3124550;
	mas_f[26][18]=1562275;
	mas_f[26][19]=657800;
	mas_f[26][20]=230230;
	mas_f[26][21]=65780;
	mas_f[26][22]=14950;
	mas_f[26][23]=2600;
	mas_f[26][24]=325;
	mas_f[26][25]=26;
	mas_f[26][26]=1;
			
	mas_f[27][1]=27;
	mas_f[27][2]=351;
	mas_f[27][3]=2925;
	mas_f[27][4]=17550;
	mas_f[27][5]=80730;
	mas_f[27][6]=296010;
	mas_f[27][7]=888030;
	mas_f[27][8]=2220075;
	mas_f[27][9]=4686825;
	mas_f[27][10]=8436285;
	mas_f[27][11]=13037895;
	mas_f[27][12]=17383860;
	mas_f[27][13]=20058300;
	mas_f[27][14]=20058300;
	mas_f[27][15]=17383860;
	mas_f[27][16]=13037895;
	mas_f[27][17]=8436285;
	mas_f[27][18]=4686825;
	mas_f[27][19]=2220075;
	mas_f[27][20]=888030;
	mas_f[27][21]=296010;
	mas_f[27][22]=80730;
	mas_f[27][23]=17550;
	mas_f[27][24]=2925;
	mas_f[27][25]=351;
	mas_f[27][26]=27;
	mas_f[27][27]=1;
			
	mas_f[28][1]=28;
	mas_f[28][2]=378;
	mas_f[28][3]=3276;
	mas_f[28][4]=20475;
	mas_f[28][5]=98280;
	mas_f[28][6]=376740;
	mas_f[28][7]=1184040;
	mas_f[28][8]=3108105;
	mas_f[28][9]=6906900;
	mas_f[28][10]=13123110;
	mas_f[28][11]=21474180;
	mas_f[28][12]=30421755;
	mas_f[28][13]=37442160;
	mas_f[28][14]=40116600;
	mas_f[28][15]=37442160;
	mas_f[28][16]=30421755;
	mas_f[28][17]=21474180;
	mas_f[28][18]=13123110;
	mas_f[28][19]=6906900;
	mas_f[28][20]=3108105;
	mas_f[28][21]=1184040;
	mas_f[28][22]=376740;
	mas_f[28][23]=98280;
	mas_f[28][24]=20475;
	mas_f[28][25]=3276;
	mas_f[28][26]=378;
	mas_f[28][27]=28;
	mas_f[28][28]=1;
			 
	mas_f[29][1]=29;
	mas_f[29][2]=406;
	mas_f[29][3]=3654;
	mas_f[29][4]=23751;
	mas_f[29][5]=118755;
	mas_f[29][6]=475020;
	mas_f[29][7]=1560780;
	mas_f[29][8]=4292145;
	mas_f[29][9]=10015005;
	mas_f[29][10]=20030010;
	mas_f[29][11]=34597290;
	mas_f[29][12]=51895935;
	mas_f[29][13]=67863915;
	mas_f[29][14]=77558760;
	mas_f[29][15]=77558760;
	mas_f[29][16]=67863915;
	mas_f[29][17]=51895935;
	mas_f[29][18]=34597290;
	mas_f[29][19]=20030010;
	mas_f[29][20]=10015005;
	mas_f[29][21]=4292145;
	mas_f[29][22]=1560780;
	mas_f[29][23]=475020;
	mas_f[29][24]=118755;
	mas_f[29][25]=23751;
	mas_f[29][26]=3654;
	mas_f[29][27]=406;
	mas_f[29][28]=29;
	mas_f[29][29]=1;
			 
	mas_f[30][1]=30;
	mas_f[30][2]=435;
	mas_f[30][3]=4060;
	mas_f[30][4]=27405;
	mas_f[30][5]=142506;
	mas_f[30][6]=593775;
	mas_f[30][7]=2035800;
	mas_f[30][8]=5852925;
	mas_f[30][9]=14307150;
	mas_f[30][10]=30045015;
	mas_f[30][11]=54627300;
	mas_f[30][12]=86493225;
	mas_f[30][13]=119759850;
	mas_f[30][14]=145422675;
	mas_f[30][15]=155117520;
	mas_f[30][16]=145422675;
	mas_f[30][17]=119759850;
	mas_f[30][18]=86493225;
	mas_f[30][19]=54627300;
	mas_f[30][20]=30045015;
	mas_f[30][21]=14307150;
	mas_f[30][22]=5852925;
	mas_f[30][23]=2035800;
	mas_f[30][24]=593775;
	mas_f[30][25]=142506;
	mas_f[30][26]=27405;
	mas_f[30][27]=4060;
	mas_f[30][28]=435;
	mas_f[30][29]=30;
	mas_f[30][30]=1;

	fin>>n>>k;  
	int tmp;
	long long rez=-1,ch=1;
	for(int i=1;i<=k;i++)
	{
		fin>>tmp;
		if (i==k) {
			rez+=(tmp-ch)+1;
		} else {
			while(ch!=tmp)
			{
				rez+=mas_f[n-ch][k-i];
				++ch;
			}
			ch=tmp+1;
		}
	}
	fou<<rez;
    fin.close();
    fou.close();
    return 0;
}
