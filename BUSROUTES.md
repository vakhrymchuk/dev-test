# Bus Route Challenge

### Problem

We are adding a new bus provider to our system. In order to implement a very
specific requirement of this bus provider our system needs to be able to white
list direct connections. We have access to a weekly updated list of bus routes
in form of a **bus route data file**. As this provider has a lot of long bus
routes, we need to come up with a proper service to quickly answer if two given
stations are connected by a bus route.


### Task

The bus route data file provided by the bus provider contains a list of bus
routes. These routes consist of an unique identifier and a list of stations
(also just unique identifiers). A bus route **connects** its list of stations.

Your task is to implement a micro service which is able to answer whether there
is a bus route providing a direct connection between two given stations. *Note:
the station identifiers given in a query may not be part of any bus route!*


### Bus Route Data

The first line of the data gives you the number of bus routes **N**. **N** bus
routes follow. For each bus route there will be **one** line containing a space
separated list of at integers. This list contains at least one integer. The
**first** integer represents the bus **route id**. The bus route id is unique
among all other bus route ids in the input. The remaining integers in the list
represent a list of **station ids**. Station ids may occur in multiple bus
routes, but never occur twice within the same bus route.


### REST API

Your micro service has to implement a REST-API supporting a single URL and only
GET requests. It has to serve
`http://localhost:8088/rest/provider/goeurobus/direct/:dep_sid/:arr_sid`. The
parameters `dep_sid` (departure) and `arr_sid` (arrival) are two station ids
(sid) represented by 32 bit integers.

The response has to be a single JSON Object:

```
{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "type": "object",
  "properties": {
    "dep_sid": {
      "type": "integer"
    },
    "arr_sid": {
      "type": "integer"
    },
    "direct_bus_route": {
      "type": "boolean"
    }
  },
  "required": [
    "dep_sid",
    "arr_sid",
    "direct_bus_route"
  ]
}
```

The `direct_bus_route` field has to be set to `true` if there exists a bus route
in the input data that connects the stations represented by `dep_sid` and
`arr_sid`. Otherwise `direct_bus_route` must be set to `false`.




### Example Data

Bus Routes Data File:
```
3
0 0 1 2 3 4
1 3 1 6 5
2 0 6 4
```

Query:
````
http://localhost:8088/rest/provider/goeurobus/direct/0/6
```

Response:
```
{
    "dep_sid": 0,
    "arr_sid": 6,
    "direct_bus_route": true
}
```


### Packaging

Your micro service must contain two simple bash scripts in the top level
repository directory.

- `build.sh`: builds your project. This could be as simple as:
  ```
  #!/bin/bash
  mvn clean package
  ```

  We will execute this on an **Ubuntu 16.04** docker container with installed:

  ```
  openjdk-8-jdk
  maven
  gradle
  ```

- `run.sh`: runs your micro service. Accepts the path to a **bus routes data
  file** as argument (`bash run.sh FILE`). After `run.sh` got started your micro
  service shall answer queries until its terminated. This could look like:
  ```
  #!/bin/bash
  java -jar target/my-fancy-service-fat-jar.jar $1
  ```


### Quick Smoketest

We will run some tests on your implementation. To gain some insight we opened up
a simplified version of what we run. There are two bash scripts located in the
`tests/` directory:
```
build_docker_image.sh
run_simple_test.sh
```

Given a running `docker` installation and a UNIX-like environment you can run:
```
cd tests/
bash build_docker_image.sh YOUR_GIT_REPO_URL
bash run_simple_test.sh
```
This should output:
```
TEST PASSED!
```

*Note: The simple test assumes your running native docker. If not (e.g. your on
OSX) please adopt the `run_simple_test.sh` file and replace `localhost` with the
IP of your docker VM*
