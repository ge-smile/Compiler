print "start test -------------------->";
var a,b;
var nan = -"anything that is not a number";
var infin = 0x7fffffff;
infin = infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin * infin; // infinity
var ninfin = -infin; // -infinity
print infin;
print ninfin;
print "should all be true";
print "---numbers---";
print 1 < infin;
print infin > 1;
print ninfin < infin;
print infin > ninfin;
print -1 > ninfin;
print ninfin < -1;
print 1 > 0;
print 10 > -10;
print 0 < 1;
print -10 < 10;
print "---strings---";
print "a" < "b";
print "b" > "a";
print "a" < "aa";
print "aa" > "a";

print "\n\n";
print "should all be false";
print "---numbers---";
print nan < 10;
print nan > 10;
print 10 < nan;
print 10 > nan;
print 0 < 0;
print 0 > 0;
print -1 > -1;
print -1 < -1;
print 10 < 10) ;
print 10 > 10;
print "---strings---";
print "a" < "a";
print "a" > "a";
print "\n\n";
print "finish test <--------------------";
