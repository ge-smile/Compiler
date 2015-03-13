// print = function (x) { console.log(x); };

var i;
var j;
var k;
var l;

i = 1;
j = 2;
k = 3;

l = i == j + k > j + i < k + !k;
l = l + (i == j) + (k > j) + (i < k) + !k;
l = l + !(i == j) + !(k > j) + !(i < k) + !!k;

var n;

n = l * 8 + 2;
print (n);

