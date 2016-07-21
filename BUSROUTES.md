# Bus Route Challenge


###Task

You are given data file describing bus routes. Bus routes consist of an unique
identifier and a list of stations. A bus route **connects** its list of stations.

Along with the data file you will be given a query file that contains queries.
Each query consists of two stations and asks if these two stations are connected
by a bus route.


###Data File

The first line of the data file gives you the number of bus routes **N**. **N** bus
routes follow. For each bus route there will be **one** line containing a space
separated list of at integers. This list contains at least one integer. The
**first** integer represents the bus **route id**. The bus route id is unique among
all other bus route ids in the input. The remaining integers in the list
represent a list of **station ids**. Station ids may occur in multiple bus routes,
but never occur twice within the same bus route.


###Query File

The first line of input gives you the number of queries **M**. **M** queries follow.
For each query there will be **one** line containing **two** integers **a** and **b**. 
Both, **a** and **b**, match a **station id** in the corresponding input file.


###Output

Output the line: `OUTPUT BEGIN`
For each query output **one** line containing `true` or `false`. Output `true` if
there exists a bus route in the data file that connects the stations represented
by **a** and **b** of this query. Otherwise output `false`.
Output the line: `OUTPUT END`


###Example

Data File:
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
