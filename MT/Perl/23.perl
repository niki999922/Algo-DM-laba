use strict;
use warnings;

my $str = "";
while (<>){
    $str = $str.$_;
}

$str =~ s/<.*?>//g; #delete html tag
$str =~ s/^[ ]+//mg; #delete '   a' -> 'a'
$str =~ s/[ ]+$//mg; #delete 'a   ' -> 'a'
$str =~ s/[ ]+/ /mg; #delete 'a  a' -> 'a a'
$str =~ s/([ ]*\n)*//; #delete empty string before text
$str =~ s/([ ]*\n)*$//; #delete empty string after text
$str =~ s/^([ ]*\n)+/\n/mg; #delete n next line to 1

print $str;