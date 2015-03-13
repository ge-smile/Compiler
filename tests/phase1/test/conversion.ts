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



