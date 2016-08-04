#!/bin/bash
sleep 5
{
    curl -s localhost:8088/API/providers/bus/goeurobus/direct/3/4 | grep -E 'true|false' > /dev/null &&
    curl -s localhost:8088/API/providers/bus/goeurobus/direct/0/1 | grep -E 'true|false' > /dev/null &&
    echo TEST PASSED!
} || {
    echo TEST FAILED!
}
