## Introduction ##

[Maven Archetypes](http://maven.apache.org/guides/introduction/introduction-to-archetypes.html) are the project templates used to create a new maven project with predefined structure and code artifacts.

Activiti bpmn archetype described here can be used to create a maven project with required maven project configurations as well as a default activiti bpmn xml and related files. The maven project created with this is ready to build and deploy a sample bpmn process which developer can use to develop the process and package it as a osgi bundle for deployment into the activiti karaf container.

## Building the archetype ##

Typically, the archetype will be available at any public maven repository so that maven tool can use it directly from the public repository. Since we have not yet published any artifacts from this project to the public maven repository, developers who want to use this archetype first need to build it on their development machine so that this will be available in their local maven repository.

To build, cd to ${install.root}/sources/activiti-bpmn-archetype, execute the maven build command (mvn clean install)
```
C:\demo\activiti-karaf-dist-1.0.0-SNAPSHOT\sources\activiti-bpmn-archetype>mvn clean install

```

## Using the archetype to create a project ##


### Archetype Info ###

The following is the Maven GAV of the activiti bpmn archetype which will be used when creating new project using the archetype.

  * archetypeGroupId=org.activiti.karaf.archetypes
  * archetypeArtifactId=activiti-bpmn-archetype
  * archetypeVersion=1.0.0-SNAPSHOT

If you have a Eclipse IDE, install m2e plugins to use maven tooling from IDE and see [how to create a maven project from archetype](http://www.sonatype.com/books/m2eclipse-book/reference/creating.html#creating-sect-m2e-create-archetype).

If you want to use the archetype from command line, use the [maven archetype plugin](http://maven.apache.org/archetype/maven-archetype-plugin/index.html)

### Command line usage ###
```
C:\demo\test> mvn archetype:generate -B -DarchetypeGroupId=org.activiti.karaf.archetypes -DarchetypeArtifactId=activiti-b
pmn-archetype -DarchetypeVersion=1.0.0-SNAPSHOT -DgroupId=org.examples -DartifactId=foo -Dversion=1.0.0-SNAPSHOT

...
[INFO] --- maven-archetype-plugin:2.2:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Batch mode
[INFO] Archetype repository missing. Using the one from [org.activiti.karaf.archetypes:activiti-bpmn-archetype:1.0.0-SNA
PSHOT] found in catalog local
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: activiti-bpmn-archetype:1.0.0-SNAPSHOT
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: org.examples
[INFO] Parameter: artifactId, Value: foo
[INFO] Parameter: version, Value: 1.0.0-SNAPSHOT
[INFO] Parameter: package, Value: org.examples
[INFO] Parameter: packageInPathFormat, Value: org/examples
[INFO] Parameter: package, Value: org.examples
[INFO] Parameter: version, Value: 1.0.0-SNAPSHOT
[INFO] Parameter: groupId, Value: org.examples
[INFO] Parameter: artifactId, Value: foo
[INFO] project created from Archetype in dir: C:\demo\test\foo
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 30.672s
[INFO] Finished at: Thu Mar 15 15:55:58 PDT 2012
[INFO] Final Memory: 6M/16M
[INFO] ------------------------------------------------------------------------

C:\demo\test>dir /S /B foo

C:\demo\test\foo\.classpath
C:\demo\test\foo\.project
C:\demo\test\foo\pom.xml
C:\demo\test\foo\README.txt
C:\demo\test\foo\src
C:\demo\test\foo\src\main
C:\demo\test\foo\src\test
C:\demo\test\foo\src\main\java
C:\demo\test\foo\src\main\process
C:\demo\test\foo\src\main\resources
C:\demo\test\foo\src\main\java\org
C:\demo\test\foo\src\main\java\org\examples
C:\demo\test\foo\src\main\java\org\examples\Main.java
C:\demo\test\foo\src\main\process\foo.activiti
C:\demo\test\foo\src\main\process\foo.bpmn20.xml
C:\demo\test\foo\src\main\resources\META-INF
C:\demo\test\foo\src\main\resources\META-INF\spring
C:\demo\test\foo\src\main\resources\META-INF\spring\beans.xml
C:\demo\test\foo\src\test\java
C:\demo\test\foo\src\test\resources
C:\demo\test\foo\src\test\java\org
C:\demo\test\foo\src\test\java\org\examples
C:\demo\test\foo\src\test\java\org\examples\WorkflowTestCase.java
C:\demo\test\foo\src\test\resources\activiti.cfg.xml
C:\demo\test\foo\src\test\resources\logging.properties

C:\demo\test>
C:\demo\test>cd foo
C:\demo\test\foo>mvn clean package
...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building foo 1.0.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 41.390s
[INFO] Finished at: Thu Mar 15 16:04:24 PDT 2012
[INFO] Final Memory: 10M/29M
[INFO] ------------------------------------------------------------------------

C:\demo\test\foo>jar tvf target\foo-1.0.0-SNAPSHOT.jar
   782 Mon Mar 19 13:03:02 PDT 2012 META-INF/MANIFEST.MF
     0 Mon Mar 19 13:03:02 PDT 2012 META-INF/
     0 Mon Mar 19 13:03:02 PDT 2012 META-INF/maven/
     0 Mon Mar 19 13:03:02 PDT 2012 META-INF/maven/org.examples/
     0 Mon Mar 19 13:03:02 PDT 2012 META-INF/maven/org.examples/foo/
   138 Mon Mar 19 13:03:02 PDT 2012 META-INF/maven/org.examples/foo/pom.properties
  4822 Mon Mar 19 13:01:08 PDT 2012 META-INF/maven/org.examples/foo/pom.xml
     0 Mon Mar 19 13:03:02 PDT 2012 META-INF/spring/
  1227 Mon Mar 19 13:01:08 PDT 2012 META-INF/spring/beans.xml
     0 Mon Mar 19 13:03:02 PDT 2012 OSGI-INF/
     0 Mon Mar 19 13:03:02 PDT 2012 OSGI-INF/activiti/
 12177 Mon Mar 19 13:02:46 PDT 2012 OSGI-INF/activiti/foo.activiti
  2913 Mon Mar 19 13:02:46 PDT 2012 OSGI-INF/activiti/foo.bpmn20.xml
     0 Mon Mar 19 13:03:02 PDT 2012 org/
     0 Mon Mar 19 13:03:02 PDT 2012 org/examples/
  1613 Mon Mar 19 13:02:50 PDT 2012 org/examples/Main.class

C:\demo\test\foo>



```