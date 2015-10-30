

# Introduction #

In Karaf console, the following commands are available to display information about BPMN Process definitions, active instances and history. A process instance can be started or terminated using these commands if the process definition is deploy in the runtime.


# Details #

## Starting activiti karaf ##

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

## Activiti Karaf Commands Syntax ##

```
karaf@root> act:
act:clean-history    act:info             act:kill             act:list             act:signal
act:start            act:undeploy
```

### act:list ###
```
karaf@root> act:list --help
DESCRIPTION
        act:list

        Displays information about BPMN active process instances, process definitions, history of process instances

SYNTAX
        act:list [options]

OPTIONS
        -h, --history
                Display information about history of all process instances
        -pd, --definitions
                Display information about all process definitions
        -pi, --active
                Display information about all active process instances
        -d, --deployments
                Display information about all BPMN deployments
        --help
                Display this help message

```
### act:info ###
```
karaf@root> act:info --help
DESCRIPTION
        act:info

        Provides details about the BPMN process instance

SYNTAX
        act:info [options] instanceID

ARGUMENTS
        instanceID
                Instance ID for which the details should be displayed

OPTIONS
        -v, --verbose
                Full details of the process instance
        -q, --quiet
                Show minimun required details of the process instance
        --help
                Display this help message
```
### act:start ###
```
karaf@root> act:start  --help
DESCRIPTION
        act:start

        Starts the BPMN process instance from a deployed process definition

SYNTAX
        act:start [options] definitionID

ARGUMENTS
        definitionID
                BPMN Process definition ID to start an instance of it.

OPTIONS
        --help
                Display this help message

```
### act:signal ###
```
karaf@root> act:signal --help
DESCRIPTION
        act:signal

        Signals any active executions in BPMN process instances

SYNTAX
        act:signal [options] [instanceIDs]

ARGUMENTS
        instanceIDs
                Instance IDs to signal set of active process instances

OPTIONS
        -a, --all
                Signal all active process instances
        -activities, --activities
                Signal all activities in a process instances
        --help
                Display this help message

```
### act:kill ###
```
karaf@root> act:kill --help
DESCRIPTION
        act:kill

        Kills any active BPMN process instances

SYNTAX
        act:kill [options] [instanceIDs]

ARGUMENTS
        instanceIDs
                Instance IDs to kill set of active process instances

OPTIONS
        -a, --all
                Kill all active process instances
        --help
                Display this help message

```
### act:clean-history ###
```
karaf@root> act:clean-history  --help
DESCRIPTION
        act:clean-history

        Removes history of the BPMN process instances

SYNTAX
        act:clean-history [options] [instanceIDs]

ARGUMENTS
        instanceIDs
                Instance IDs to remove from hisotry

OPTIONS
        -pd, --definitions
                Removes history of process instances started from the definitions
        -a, --all
                Remove all BPMN Processes from history
        --help
                Display this help message

```
### act:undeploy ###
```
karaf@root> act:undeploy --help
DESCRIPTION
        act:undeploy

        Undeploys the BPMN Deployments(Process definition, images, bar files etc)

SYNTAX
        act:undeploy [options] [deploymentIDs]

ARGUMENTS
        deploymentIDs
                Deployment IDs of the BPMN deployments for undeploying

OPTIONS
        -a, --all
                Undeploys all BPMN deployments
        -c, --cascade
                Deletes the given deployment and cascade deletion to process instances, history process instances and
                jobs.
        --help
                Display this help message

```

## Activiti Karaf Commands Examples ##