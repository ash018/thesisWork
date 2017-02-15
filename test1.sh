#!/bin/bash


cd myff
var1 = 1
for i in `ls /home/akash/DIRNAME/numericdomains/depot_Numeric/`
do
echo "$i"
let "var1++"

#ulimit -v 128k
#sleep 100 && kill -ALRM $$ &

timeout() {

    time=$1
	
    # start the command in a subshell to avoid problem with pipes
    # (spawn accepts one command)
    command="/bin/sh -c \"$2\""

    expect -c "set echo \"-noecho\"; set timeout $time; spawn -noecho $command; expect timeout { exit 1 } eof { exit 0 }"    

    if [ $? = 1 ] ; then
        echo "Timeout after ${time} seconds"
    fi

}

#pid=$!
#sleep 1

timeout 180 "./ff -p /home/akash/DIRNAME/numericdomains/depot_Numeric/ -o domain.pddl -f "$i" -s 0 > "/home/akash/solver_output/"$var1".txt" "
#if [ `pgrep $pid` ]
 # then
    
  #  kill $pid
   # echo "killed $pid because it took too long."
#fi

done



