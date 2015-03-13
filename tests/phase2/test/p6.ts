//print = function (x) { console.log(x); };

print(0);

var n;
var j;

n = 5;
j = 10;

while (n > 0)
{
  print(n);
  try {
    print(1999);
    while (j > 0)
    {
      print(n); print(j);
      if (n + j == 14)
      {
        j = 0;
        throw 1918;
      }
      j = j - 1;
    }
    print(1066);
  }
  catch (e)
  {
    print (e);
  }
  n = n - 1;
}

