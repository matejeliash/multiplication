# Option 1 Calculate multiplication

Write a program which computes the multiplication of two large numbers (integers) entered as command
line arguments.
Each number can have any number of digits (up to the maximum length of a CLI argument, try at least 20
digits for each).
It is mandatory to provide two implementations of the algorithm computing the multiplication (one of
them can use e.g.: BigInteger class another one should implement the algorithm from scratch).
The program must have an ability to choose one of the implementations by arguments.
It is also mandatory to implement at least one Unit test which computes multiplication using both
algorithms for the same inputs and compares results which must be equal.


## How to run

Compile:
```bash
  ./mvnw clean package
```

Run tests:
```bash
  ./mvnw  test
```


Run .jar and write numbers as args:
```bash
java -jar target/multiplication-1.0-SNAPSHOT.jar {--alg1|--alg2}  <number> <number>
java -jar target/multiplication-1.0-SNAPSHOT.jar --alg1 2000000 30000000
java -jar target/multiplication-1.0-SNAPSHOT.jar --alg2 2000000 30000000
```









