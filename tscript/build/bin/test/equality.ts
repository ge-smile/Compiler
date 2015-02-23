print "start test -------------------->";

print "the following should all be true";
var a,b, n = null;
print "#1";
print a == b; // a
print null == null; // b
print -0.0 == 0.0; //
print 10 == 10;
print "goose" == "goose"; // d
print "goose" == 'goose'; // d
print true == true; // e
print false == false; //e
print "#2";
print a == null;
print "#3";
print null == a;
print "#4";
print 10 == "10";
print "#5";
print "10" == 10;
print "#6";
print false == 0;
print true == 1;
print false == "0";
print true == "1";
print "#7";
print 0 == false;
print 1 == true;
print "0" == false;
print "1" == true;
print "\n\n";

var nan = -"anything that is not a number";
print "the following should all be false";
print "#1";
print nan == 0;
print 0 == nan;
print "NAN" == 20;
print 25 == "NAN";
print -0.0 == 10;
print 10 == -0.0;
print 10 == -10;
print "Goose" == "goose";
print "goose" == "Goose";
print "goose" == "GOOSE";
print "a" == "aa";
print "a" ==  " a";
print "a " == "a";
print true == false;
print false == true;
print "#4";
print 10 == " 10x";
print "#5";
print "x10 " == 10;
print "ten" == 10;
print 10.5 == "10";
print "#6";
print false == 1;
print true == 0;
print false == "1";
print true == "0";
print "#7";
print 1 == false;
print 0 == true;
print "1" == false;
print "0" == true;
print "\n\n";
print "finish test <--------------------";
