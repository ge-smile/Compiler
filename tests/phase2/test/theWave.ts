print "I call this the wave";
var width = 70, base = "V", wave, len = 10000, l = 0, w, dir=false, mod, tmp, cur = 5;
while ( ((l = l + 1)-1) < len ) {
	// calc l % width = mod
	mod = l;  while ( ! ( mod < width) ) mod = mod - width;
	if ( mod == 0 )
		dir = !dir;
	w = 0;
	wave = base;
	if ( dir){
		while ( w < ( mod ) ) {
			wave = wave + base;
			w = w + 1;
		}
	} else {
		while ( w < ( width - ( mod)) ) {
			wave = wave + base;
			w = w + 1;
		}
	}
	tmp = cur;
	while ( !((tmp= tmp -1) < 0) )
		print wave;
}

print "What a wild ride!!!!!!!!!!";