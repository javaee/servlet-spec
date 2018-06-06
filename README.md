#### :warning:This project is now part of the EE4J initiative. This repository has been archived as all activities are now happening in the [corresponding Eclipse repository](https://github.com/eclipse-ee4j/servlet-api). See [here](https://www.eclipse.org/ee4j/status.php) for the overall EE4J transition status. 
 
---

Java Servlet API
================

Building
--------

Prerequisites:

* JDK8+
* Maven 3.0.3+

Run the build: 

`mvn install`

The build runs copyright check and generates the jar, sources-jar and javadoc-jar by default.

Checking findbugs
-----------------

`mvn -DskipTests -Dfindbugs.threshold=Low findbugs:findbugs`

