var a , b;
var q = 1, p = q, o=p;
var x = 5, y = x, z = y;
a = "hello";
a = 5 + 2;
a = b = 10;
var x; var y; var z;
var x, y, z;
var z, y, x;
console.log( "\na: ");
console.log( a);
console.log( "\nb: ");
console.log( b);
console.log( "\na+b: ");
console.log( a + b);
console.log( "\nx+y+z, where x=5, y=x, z=y");
console.log( x + y + z);
y = a + b * -3 - 2;
console.log( "\nx+y+z, where y = a + b * -3 - 2");
console.log( x + y + z);

var u, v;

console.log( "\n u...v");
console.log( u); // undefined
console.log( v); // undefined

console.log( u + v); // NaN
console.log( u * v); // NaN
console.log( !u);  // true
console.log( !!v); //false

var none = v;
console.log( none);  // undefined
