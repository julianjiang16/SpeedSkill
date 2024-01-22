#!/bin/bash

rm test.log
java_pid=`ps -ef | grep java| grep -v grep | awk '{print $2}'`
echo "java pid = $java_pid"
grep -i Anonymous /proc/$java_pid/smaps > test.log
sum=0
line_counter=0
while IFS= read -r line; do
        ((line_counter++))
    if [[ $line_counter -eq 1 ]]; then
        continue
    fi
    value=$(echo "$line" | grep -oE '[0-9]+')

    if [[ -n $value ]]; then
        sum=$((sum + value))
    fi
done < "test.log"

echo "Anonymous memory used : $sum  kb"
