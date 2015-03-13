try {
    var num = -(-"num");
    throw num;
    print "this shouldn't print";
} catch ( e ) {
  print "error: " + e;
}