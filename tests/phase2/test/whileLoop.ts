print " i = 10\nwhile i > 0\nprint i--";
var i = 10;
while ( i > 0 ) print "     i is " + ((i =  i - 1) + 1);
print "loop done";
print "i is " + i;

print " crazy loop...";
i = 0;
var loops = 6, half = loops / 2;
while ( (( i = i + 1) - 1) < loops ) {
	if ( i == 0 ) print "zero";
	else if ( i == 1 ) print "one";
	else if ( i == 2 ) print "two";
	else if ( i == 3 ) print "three";
	else if ( i == 100 ) print "one hundred";
	else print "" + i;
	
	if ( i - half > 0) 
		print "upper half";
	else
		print "lower half";
}
print "... done";

print "\n\nmodulo";
var num = 9, mod = 2;
var tmp = num;
while ( !(tmp < mod) ) {
	tmp = tmp - mod;
}
print num + " mod " + mod + " = " + tmp +"\n\n";

print "do nothing loop...";
var g = 0;
while ( ( g = g + 1) < 100 ) ;
print "...nothing done.\n";

print "finished........................\n";