//print = function (x) { console.log(x); };

var i;
var j;
var k;
var l;

i = 1;
j = 2;
k = 1;
l = 19;

while (i < 17)
{
  print (i);
  k = k + 2;
  if (i + j == k) continue;
  i = i + 1;
}

print (i + j + k + l + 17);

