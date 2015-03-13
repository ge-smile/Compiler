for f in $(ls test);
do
echo $f
./ts test/$f > result/$f.out
done

diff standard result