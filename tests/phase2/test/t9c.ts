//print = function(x) { console.log(x); };

var p;
p = function (x) { print (x); return x; };

var f;
f = function(x, y) { if (y == undefined) y = 1; print (x + y); };

f(p(1), p(2));
f(p(4));

