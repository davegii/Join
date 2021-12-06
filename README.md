**How to run your program for the sample CSV files (nation and region)**

Set path to where you have installed java on your system, for me it was:
>set path=C:\Program Files\Java\jdk1.8.0_241\bin

Then compile:
>javac Join.java

Then run: (This example joins based on REGIONKEY via nested loop)

>java Join nation.csv REGIONKEY region.csv REGIONKEY NESTED_LOOP output.csv
orders.tbl orderkey lineitem.tbl orderkey nested_loop output.csv

>**Benchmark result**
Compare the performance (i.e., time) of nested loop join and hash join using two tables LINEITEM and ORDERS. 
Include the results of 10 runs and the average of them, for each of nested loop join and hash join.

NESTED: 
1.67929996E7 microseconds,
1.6469893E7 microseconds,
1.62230764E7 microseconds,
1.64525109E7 microseconds,
1.65820986E7 microseconds,
1.64320959E7 microseconds,
1.64749027E7 microseconds,
1.66708373E7 microseconds,
1.68349886E7 microseconds,
1.67015612E7 microseconds,

Average: 1.656349642E7 microseconds

HASH:
1.16202278E7 microseconds,
1.14563623E7 microseconds,
1.13874542E7 microseconds,
1.14724535E7 microseconds,
1.16059026E7 microseconds,
1.2039898E7 microseconds,
1.17078699E7 microseconds,
1.16308284E7 microseconds,
1.1668596E7 microseconds,
1.16308569E7 microseconds,

Average 1.162204496E7 microseconds