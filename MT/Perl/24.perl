use strict;
use warnings;

my $str = "";
while (<>) {
    $str = $str . $_;
}

my @links = ($str =~ /<a.*?href *= *["'](.*?)["'].*?>/g);
my @nakedLinks = ();

foreach (@links) {
    my @tmpFinds = ($_ =~ /^([^:]*:(\/){1,2})?([^\@]*\@)?([\d\w][^:\/]*\.\w+)(:\d+)?(\/.*)?$/g);
    if (defined $tmpFinds[3] && length $tmpFinds[3] > 0) {
        # print "$tmpFinds[3]\n";
        push @nakedLinks, $tmpFinds[3];
    }
}

sub uniq {
    my %seen;
    grep !$seen{$_}++, @_;
}

print join "\n" => uniq(sort(@nakedLinks));
# print join "\n" => @nakedLinks;