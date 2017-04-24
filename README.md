When recording spark events for the Spark History Server and compression
is on you can end up with .lz4 compressed logs.  Naturally the lz4 being
used is incompatible with the lz4 utilities for linux/mac.

This code uses the same library that Spark uses to uncompress such files.

```
   $ sbt clean assembly
   $ java -jar target/scala-2.11/srunlz4-assembly-1.0.jar FILE.lz4
```
