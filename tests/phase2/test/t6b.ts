//print = function(x) { console.log(x); };

try {
  try {
    throw 1;
  }
  catch (e)
  {
    print(1);
    throw e;
    print(43);
  }
  finally {
    print(2);
  }
  print(43);
}
catch (y)
{
  print(y+2);
}
finally
{
  print(4);
}
print(5);

