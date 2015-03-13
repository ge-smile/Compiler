var x;

try {
  x = 1;
  print x;
  throw x;
  print 42;
}
catch (y)
{
  print y + 1;
}
print 3;
print 4;
print 5;

