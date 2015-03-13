var a = 5,b;
b = a/-0;
print b;
print 2./(-0/-1;
print 2./(0*-1;
print 2./(-0 + -0;
print 2./(0-0;
print 2./(0.*0;
print -2./0 + 2./-0;
print 2./0 + 2./-0;

//print = function (x) { console.log(x; } ;

print null == undefined;
print null == 0;
print null + 0;

print null == "null";

print null == null;

print null < 5;
print null < null;
print null > -0;
print 5 < null;

print "fred" + null;


print "hello world";
print 'Hello World';
print "Bob's string is single quote";
print 'Sally likes to "Double Quote"';
print "";
print '' + "";
print "Super\nBowl\nVictory";

var abc; 
abc = 100; 
print abc;
abc = -100; 
print abc;
print -100;
print abc * -100;
print abc * - 100;
 
var abc; 
abc = true; 
print !abc;

var xyz; 
xyz = false; 
print !xyz;
print true;

var xyz; 
xyz = undefined; 
print xyz;
print xyz + 17;
print xyz / 17;
print xyz * 17;
print xyz - 17;
print !xyz;
print xyz;

print 1 + "Fred"; 
print "Fred" + 1;  
print 1 + 1;  
print "1" + "1";  
print "Fred" + " smells funny";
print true + 1; 
print false + 2;  


print "fred" > "freddy"; 
print "fred" > "fred";
print "freddy" > "fred";
print "";
print "fred" < "freddy"; 
print "fred" < "fred";
print "freddy" < "fred";
print "";
print "abc" < "xyz";
print "xyz" < "abc";
print "abc" > "xyz";
print "xyz" > "abc";

print 1 < 2;
print 2 < 1;
print 2 < 2;

print 1 > 2;
print 2 > 1;
print 2 > 2;


print undefined == undefined;  
print undefined == 3;  
print 3 == 4;  
print 4 == 4; 
print "fred" == "fred";  
print "greg" == "fred";  
print "freddy" == "fred";	 
print true == true;  
print false == false;  
print false == true;  

print 1 == "1"; 
print 1 == "2";  
print "fred" == 1;  
print "1" == 1;  
print "1" == 2;  
print 1 == "fred" ;  
print 1 == true; 
print 1 == false;
print true == 0; 
print false == 0;
print true == "1"; 
print "true" == 1; 

var nan = 1./0.*0., inf = 1./0., minf = 1./-0.;
print "=======0. NaN, Infinity, and -Infinity values: =======";
print nan;
print inf;
print minf;

print "";
print "========1. To Boolean Conversion: ======";
print !null + " !null == true";
print !undefined + " !undefined == true";
print false + " false == false";
print true + " true == true";
print !-0 + " !-0 == true";
print !0 + " !0 == true";
print !nan + " !NaN == true";
print !1 + " !1 == false";
print !-1 + " !-1 == false";
print !inf + " !Infinity == false";
print !minf + " !-Infinity == false";
print !"" + " !'' == true";
print !"abc" + " !'abc' == false";

print "";
print "=========2. To Number Conversion: ======";
print undefined*1 + " undefined.toNumber() == NaN";
print null*1 + " null.toNumber() == 0";
print true*1 + " true.toNumber() == 1";
print false*1 + " false.toNumber() == 0";
print 1 + " 1 == 1";
print 1.e2 + " 1.e2 == 100";
print 0x1 + " 0x1 == 1";
print 0X1 + " 0X1 == 1";
print "string"*1 + " 'string'.toNumber() == NaN";
print "0x1"*1 + " '0x1' == 1";
print "0X1"*1 + " '0X1' == 1";
print "1.0"*1 + " '1.0' == 1";
print "1.e2"*1 + " '1.e2' == 100";

print "";
print "==========3. To String Conversion: ======";
print undefined+"" + " ---> undefined";
print null+"" + " ---> null";
print true+"" + " ---> true";
print false+"" + " ---> false";
print 1+"" + " ---> 1";
print 1.e2 + "" + " ---> 100";
print 0x1+""+ " ---> 1";
print 0X1+"" + " --->1";
print 0.00000000001+""+ " --->1e-11";
print 0.0001+""+" ---> 0.0001";
print 100000000000000000000+"" + " ----> 100000000000000000000";
print 1000000000000000000000+"" + " ----> 1e+21";
print inf+"" + " ---> Infinity";
print minf+""+ " ---> -Infinity";
print nan+"" + " ---> NaN";












