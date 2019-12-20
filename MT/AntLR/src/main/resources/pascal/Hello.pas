Program Some_test_Program;

const
  g_c1 : string = 'asd';
  g_c2 : integer = 13;
  g_c3 : real = -0.13;

var
  g_v1, g_v2 : integer;
  g_b1 : boolean;
  g_r1 : real;
  g_s1 : string;
  it1, it2, it3 : integer;
  sumMain : integer;

function summa(s, s1 : integer) : integer;
var
  a, b : integer;
  kek : integer;
begin
  a := s;
  b := s1;
  kek := a + b;
  summa := kek;
end;

procedure testopera(s, s1 : real);
var
  a, b : real;
  c : integer;
begin
  c := -1 + 1 * 2 + 3 + 54 mod 2 div 3;
  a := s1 - s;
  b := 17;
end;


begin
  sumMain := 0;
  for it1:= 1 to 5 do
    for it2:= 6 to 8 do
    begin
      sumMain := sumMain + it1 * it2;
      WriteLn(sumMain);
    end;
  if (1 < 2 and 2 <= 3 and 2 >= 1 and 2 > 1 and 1 = 2 or 1 <> 2) then
    WriteLn(summa(1, 2));
end.