//print = function (x) { console.log(x); };

var i;
var j;
var f;
var g;

i = 1;
j = 3;
f = function () { var i; i = 17;  g = function () { print(i + j);};  g();};

f();
i = 6;
g();
j = 6;
f();


