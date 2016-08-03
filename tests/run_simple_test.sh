#!/bin/bash
docker run -d --name=dev-test -p 8088:8088 dev-test /bin/bash run.sh /data/example > /dev/null 
sleep 5
{
    curl -s localhost:8088/API/providers/bus/goeurobus/direct/3/4 | grep true > /dev/null &&
    curl -s localhost:8088/API/providers/bus/goeurobus/direct/3/4 | grep true > /dev/null &&
    curl -s localhost:8088/API/providers/bus/goeurobus/direct/0/1 | grep false > /dev/null &&
    echo TEST PASSED!
} || {
    echo TEST FAILED!
}
docker rm -f dev-test > /dev/null 
