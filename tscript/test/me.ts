// var print = console.log;
var tab = "    ", ind = tab;
try {
    print ("try block 0");
    throw 0;
}
catch (nest0){
    try {
        print (ind + "try block 1");
        var num = 10;
        throw nest0 + 1;
    } catch (nest1){
        ind = tab + tab;
        print (ind + "previous catch: " + nest0);
        print (ind + "this catch: " +nest1);
        try {
            ind = ind + tab;
            print (ind + "try block 2");
            throw nest1 + 1;
        } catch (nest2){
            var something = "idk";
            print (ind + "previous catch: " + nest1);
            print (ind + "this catch: " +nest2);
        }
        ind = tab + tab;
        try {
            print (nest2);
        } catch (err){
            print (ind + "err: "+ err);
            print (ind + "nest2 is now out of scope");
        }
    }
    ind = tab;
    try {
        print (nest1);
    } catch (err){
        print (ind + "err: "+ err);
        print (ind + "nest1 is now out of scope");
    }
}
finally{
    try {
        print (nest0);
    } catch (err){
        print ("err: "+ err);
        print (("nest0 is now out of scope"));
    }
    try{
        print (("num: " + num));
        print (("something: " + something));
    }catch(err){
        print (("something went wrong!!!"));
    }
}

print (("test complete  <---------------------------------------"));