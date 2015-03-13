
var i;
var j;

i = 1;
j = 1;
while (i < 6) {
  while (j < 10) {
    break;
    print j;
    j = j + 1;
  }
  print i;
  i = i + 1;
  if (i == 4) break;
}
print i;
print i + 1;

