# Bus Route Challenge

### Problem

We are adding a new bus provider to our system. In order to implement a very
specific requirement of this bus provider our system needs to be able to white
list direct connections. We have access to a weekly updated list of bus routes
via a REST-API. As this provider has a lot of long bus routes, we need to come
up with a proper service to quickly answer if two given stations are connected
by a bus route.


### Task

Given the REST end-point
`http://88.198.124.43:1337/API/providers/bus/goeurobus/routes/:key` you can
obtain data describing bus routes with a provided authentication key `:key`. Bus
routes consist of an unique identifier and a list of stations (also just unique
identifiers). A bus route **connects** its list of stations.

To simulate real white list queries you will be given a query file that contains
queries. Each query consists of two station identifiers and asks if these two
stations are connected by a bus route. *Note: the station identifiers given in a
query may not be part of any bus route!*


### Bus Route Data

The first line of the data gives you the number of bus routes **N**. **N** bus
routes follow. For each bus route there will be **one** line containing a space
separated list of at integers. This list contains at least one integer. The
**first** integer represents the bus **route id**. The bus route id is unique
among all other bus route ids in the input. The remaining integers in the list
represent a list of **station ids**. Station ids may occur in multiple bus
routes, but never occur twice within the same bus route.


### Query File

The first line of input gives you the number of queries **M**. **M** queries
follow. For each query there will be **one** line containing **two** integers
**a** and **b**. Both, **a** and **b**, match a **station id** in the
corresponding input file.


### Output

Output the line: `OUTPUT BEGIN` For each query output **one** line containing
`true` or `false`. Output `true` if there exists a bus route in the input data 
that connects the stations represented by **a** and **b** of this query.
Otherwise output `false`. Output the line: `OUTPUT END`


### Example

Input Data:
```
3
0 0 1 2 3 4
1 3 1 6 5
2 0 6 4
```

Query File:
```
2
0 6
2 5
```

Output:
```
OUTPUT BEGIN
true
false
OUTPUT END
```
