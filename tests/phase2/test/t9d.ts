var p;
p = function (x) { print x; return x; };

var f;
f = function(x, y) { print x + y + 2; };

f(p(1), p(2), p(3), p(4));

