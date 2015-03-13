print "starting test ----------------------->";
var i = 0;
print " print 1-13, but skip 5";
while ( i = i + 1) { // i is always true
    if ( i == 5 ) continue;
    print "i is " + i;
    print "i to bool is " + !!i;
    if ( i > 12) break;
}
