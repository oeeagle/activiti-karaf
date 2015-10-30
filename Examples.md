  1. Install [Required Software](RequiredSoftware.md) for building code
  1. Building
    1. cd to _${install.root}/sources/activiti-karaf-examples_
    1. build the maven projects - execute _mvn clean install_
```
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] activiti-karaf-examples ........................... SUCCESS [0.656s]
[INFO] activiti-karaf-examples/hello-activiti-example .... SUCCESS [14.875s]
[INFO] activiti-karaf-examples/mail-activiti-example ..... SUCCESS [4.625s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 25.250s
[INFO] Finished at: Mon Mar 19 13:13:21 PDT 2012
[INFO] Final Memory: 9M/29M
[INFO] ------------------------------------------------------------------------
```
  1. Deploying
    * cd to _${install.root}/sources/activiti-karaf-examples/hello-activiti-bundle/target_
    * copy hello-activiti-bundle-1.0.0-SNAPSHOT.jar to deploy directory of the runtime (copy hello-activiti-bundle-1.0.0-SNAPSHOT.jar ${install.root}/deploy
  1. Running - from the karaf console
```
karaf@root> list
...
...
[ 146] [Active     ] [            ] [Started] [   60] activiti-karaf-examples/hello-activiti-example (1.0.0.SNAPSHOT)

karaf@root> act:list

BPMN Deployments
----------------
 ID   Name                               Deployment Time
[18 ][org.activiti.karaf.examples.hello][Mar 14, 2012 11:23:17 PM]

BPMN Process Definitions
-------------------------
 Definition  Name   Ver  Resource
[Hello:1:22 ][hello ][1  ][OSGI-INF/activiti/hello.bpmn20.xml ]

History of BPMN Process Instances
---------------------------------
No History on BPMN Processes.

Active BPMN Process Instances
-----------------------------
No Active BPMN Process Instances Found.

karaf@root> act:start Hello:1:22

*** Executing Print Service Task... Execution Id:[23] Activity: ServiceTaskId1[Print Service 1]
#### Hello   ####

*** Executing Print Service Task... Execution Id:[23] Activity: ServiceTaskId2[Print Service 2]
#### World!! ####
Process instance 23 Started
karaf@root> act:list -h

History of BPMN Process Instances
---------------------------------
 Definition  Ins  Start Time                End Time
[Hello:1:22][23 ][Mar 14, 2012 11:24:11 PM][Mar 14, 2012 11:24:12 PM]

```