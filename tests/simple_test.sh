#!/bin/bash

echo-red () {
    echo -e "\e[1;31m$@\e[0m"
}
echo-green () {
    echo -e "\e[1;32m$@\e[0m"
}

sleep 5
{
    curl -s "localhost:8088/api/direct?dep_sid=3&arr_sid=4" | grep -E 'true|false' > /dev/null &&
    curl -s "localhost:8088/api/direct?dep_sid=0&arr_sid=1" | grep -E 'true|false' > /dev/null &&
    echo-green TEST PASSED!
} || {
    echo-red TEST FAILED!
}
