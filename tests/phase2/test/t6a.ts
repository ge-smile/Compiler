try {
  print x;
}
catch (y)
{
  print y;
}
finally
{
  print "finally";
}
try {
  print 42;
}
catch (y)
{
  print 43;
  print y;
}
finally
{
  print "finally";
}
