while (<>) {
  s/(\(.*?\))/()/g;
  print;
}

