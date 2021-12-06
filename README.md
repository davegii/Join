**How to run your program for the sample CSV files (nation and region)**

Set path to where you have installed java on your system, for me it was:
>set path=C:\Program Files\Java\jdk1.8.0_241\bin

Then compile:
>javac Join.java

Then run: (This example joins based on REGIONKEY via nested loop)

>java Join nation.csv REGIONKEY region.csv REGIONKEY NESTED_LOOP output.csv

**Benchmark result**

Compare the performance (i.e., time) of nested loop join and hash join using two tables LINEITEM and ORDERS. 
Include the results of 10 runs and the average of them, for each of nested loop join and hash join.
