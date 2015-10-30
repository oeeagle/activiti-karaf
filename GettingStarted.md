  1. [Download](http://code.google.com/p/activiti-karaf/downloads/list) distribution archive
  1. Unzip the downloaded file to some location (e.g c:/demo)
    * _note: if unzip tool prompts for overwrite files, ignore_
  1. Install [Required Software](RequiredSoftware.md)
  1. Start Activiti Karaf - _cd to bin directory in unziped folder and execute **karaf**_
```
C:\demo\activiti-karaf-dist-1.0.0-SNAPSHOT\bin>karaf
                   _   _       _ _   _
         /\       | | (_)     (_) | (_)
        /  \   ___| |_ ___   ___| |_ _
       / /\ \ / __| __| \ \ / / | __| |
      / ____ \ (__| |_| |\ V /| | |_| |
     /_/    \_\___|\__|_| \_/ |_|\__|_|

  Activiti Karaf (1.0.0-SNAPSHOT)

Hit '<tab>' for a list of available commands
and '[cmd] --help' for help on a specific command.
Hit '<ctrl-d>' or 'osgi:shutdown' to shutdown Activiti Karaf.

karaf@root> 
```
  1. Access Activiti Web tools
    1. Open Activiti Modeler - http://localhost:8181/activiti-modeler
    1. Open Activiti Explorer - http://localhost:8181/activiti-explorer
      * use _kermit/kermit_ as _username/password_ for login
  1. Build, deploy and run Examples
    * Three examples for Activiti Explorer were pre-deployed. Use the activiti explorer to run these examples.
    * You can use Activiti Modeler to create a BPMN process and then use the Activiti Explorer to deploy and run the process.
      * For example, from Activiti Modeler, create a simple process that _start -> script task -> end_ , and configure the script task to use groovy and add script that prints some message (e.g. system.out.println("Hello World!!");). When you save the process, the process bpmn xml will be saved under ${install.root}/activiti-repo.
      * Open Activiti Explorer to upload and deploy the bpmn process that is saved from the modeler.
  1. Build, deploy and run example using maven
    * See [Examples](Examples.md) to build, deploy and run hello process
  1. Run [Activiti CLI](ActivitiCLI.md) commands
```
karaf@root> act:list

BPMN Deployments
----------------
 ID   Name            Deployment Time
[10 ][Demo processes][Mar 14, 2012 11:00:13 PM]

BPMN Process Definitions
-------------------------
 Definition ID               Name                     Ver  Resource

[createTimersProcess:1:15  ][Create timers process  ][1  ][org/activiti/explorer/demo/process/createTimersProcess.bpmn20
.xml]
[simpleApprovalProcess:1:16][Simple approval process][1  ][org/activiti/explorer/demo/process/testProcess.bpmn20.xml
    ]
[oneTaskProcess:1:17       ][Famous One Task Process][1  ][org/activiti/explorer/demo/process/oneTaskProcess.bpmn20.xml
    ]

History of BPMN Process Instances
---------------------------------
No History on BPMN Processes.

Active BPMN Process Instances
-----------------------------
No Active BPMN Process Instances Found.
karaf@root>
```