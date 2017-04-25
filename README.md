Java Servlet API
================

Building
--------

Prerequisites:

* JDK8+
* Maven 3.0.3+

Run the build:

`mvn install`

The build generates the jar, sources-jar and javadoc-jar by default.

Checking findbugs
-----------------

`mvn -DskipTests-true -Dfindbugs.threshold=Low findbugs:findbugs`

Checking copyright
------------------

`mvn -q org.glassfish.copyright:glassfish-copyright-maven-plugin:copyright`
