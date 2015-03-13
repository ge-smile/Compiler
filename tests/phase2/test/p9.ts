//print = function (x) { console.log(x); };

var f;
f = function (x) { var g; g = function (y) { return x + y;}; return g;};

var f1;
f1 = f(19);
print(f1(23));

var f2;
f2 = f(3);

print (f2(39));

