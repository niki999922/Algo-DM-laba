while (<>) {
  s/((\w)\2+)/$2/g;
  print;
}
