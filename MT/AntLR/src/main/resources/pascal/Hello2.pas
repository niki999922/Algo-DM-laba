Program Some_test_Program_2;

var
  i, j : integer;

begin
  i := 1;
  j := 1;
  while (i < 5) do
  begin
    i := i + 1;
    j := 0;
    WriteLn(i);
    while (j < 5) do
    begin
      j := j + 1;
      WriteLn(j);

    end;

  end;


  i := 1;
  while (i < 5) do
  begin
    WriteLn(i * 2);
    i := i + 1;
  end;
end.