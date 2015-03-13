try {
    x = 10;
} catch (err) {
    var prefix = "error msg: ";
        print  prefix + err;
    var ten = 5+5;
}

try {
    print "ten = " + ten;
    // try to use the catch var from before
    err = 10;
    print "this shouldn't print";
} catch (err){
    print prefix + err;
} finally {
    print "Finally print something.";
}

try {
    y = 10;
} finally { print "Finally finished.";}