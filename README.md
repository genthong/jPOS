## Build distribution

    ./gradlew dist

    
## Install locally

    ./gradlew install
    
## Verify version

    ./gradlew version
    
## Maven POM

```xml
<dependency>
  <groupId>org.jpos</groupId>
  <artifactId>jpos</artifactId>
  <version>1.9.4</version>
</dependency>
```

if you want to use our nightly builds, for instance to get `1.9.5-SNAPSHOT`, you can
add the following repository:

```xml
<repository>
  <id>jpos</id>
  <name>jPOS Central Repository</name>
  <url>http://jpos.org/maven</url>
  <layout>default</layout>
</repository>
```

## Programmer's Guide

Visit [http://jpos.org/learn](http://jpos.org/learn).

----
See the [ChangeLog:](http://jpos.org/wiki/ChangeLog) or visit the [Resources](http://jpos.org/resources) page for additional information.
