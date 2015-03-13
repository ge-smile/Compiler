try {
  print x;
}
catch (y)
{
  print y;
}
try {
  print 42;
}
catch (y)
{
  print 43;
  print y;
}

try {
  x = 42;
}
catch (z)
{
  print z;
}
