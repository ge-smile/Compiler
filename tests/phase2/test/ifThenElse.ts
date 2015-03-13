
print "starting test ---------------->";

if ( true )
   print "exp was true\n\n";

if ( false )
   print "you should not see this line\n\n";

if ( 10 == (5+5)){
   print " 10 is the same as...";
   print "( 5 + 5 )\n\n";
}

if ( 10 == 9 ) {
   print " you should not see this ";
   print "nor, should you see this\n\n";
}

 if (true)
 ; // nothing

if (true){;}

if ( 10 ) print "10 is true\n\n"; else print "10 is not true\n\n";
if ( 0 ) print "0 is true\n\n"; else print "0 is not true\n\n";
var a, b;

if ( 10 > 1){
    var a = 10;
    print "set a to 10";
    if ( a == 10) print "a is still ten";
    else print "a is no longer ten";
} else {
    var b = 11;
    print "set b to 11";
}
print "a is " + a;
print "b is " + b;

a = 10;
print "a is " + a;
print "only one line should print below to ...";
if ( a > 100) {
    print " a > 100";
} else if ( a > 10){
    print " a > 10";
} else {
    print " a <= 10";
}
print "...here";


print "finished testing <--------------------";


