var
  a, b, sum : integer;
  s, s1 : string;

function umn (s, s1 : string) : string;
var
  a, b : integer;
  sex : string;
begin
  sex := '';
  a := length(s);
  for b:=1 to a do if (s[b] = s1[b]) and (s[b] = '1') then sex := sex + '1' else sex := sex + '0';
  umn := sex;
end;

function suma (s, s1 : string) : string;
var
  a, b : integer;
  sex : string;
begin
  sex := '';
  a := length(s);
  for b:=1 to a do
    if (s[b] = '1') or (s1[b] = '1') then sex := sex + '1' else sex := sex + '0';
  suma := sex;
end;

procedure ravnolong (var s, s1 : string);
var
  a, b : integer;
begin
  a := length(s1) - length(s);
  for b:=1 to a do insert('0', s, 1);
end;

procedure checkvariation (var s, s1 : string);
begin
  if (length(s) > length(s1)) then ravnolong(s1, s) else if(length(s) <> length(s1)) then
    ravnolong(s, s1);
end;

function perevod (a : integer) : string;
var
  s : string;
begin
  s := '';
  while (a >= 1) do if (a mod 2 = 1) then
  begin
    s := '1' + s;
    a := a - 1;
    a := a div 2;
  end
  else begin
    s := '0' + s;
    a := a div 2;
  end;
  perevod := s;
end;

begin
  read(a, b);
  sum := a + b;
  s := perevod(a);
  s1 := perevod(b);
  checkvariation (s, s1);
  writeln(s, '      ', s1);
  writeln(' v dvoichnoy chisla');
  writeln('a*b = ', umn(s, s1));
  writeln('a+b = ', suma(s, s1));
  writeln(' v desatichnoy chisla');
  writeln('a+b =', perevod(sum));
end.