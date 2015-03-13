
var i;
i = 1;

var j;
j = 5;

var f;
f = function () { var j; j = i; print j;};

f();
i = i + 1;
f();
i = i + 1;
f();
i = i + 1;
f();
i = i + 1;
print j;
