//print = function (x) { console.log(x); };

var i;
var j;
var f;

i = 1;
j = 3;
f = function () {
  var i;
  i = j + 14;
  var g;
  g = function () { return (i + j); };
  return g;
};

var f1;
f1 = f();
print (f1());
i = 6;
print (f1());
j = 6;
print (f1());

f1 = f();
print (f1());
i = 6;
print (f1());
j = 3;
print (f1());

