  1. What is the url for activiti modeler web app
    * http://localhost:8181/activiti-modeler
  1. Where is my activiti modeler repository
    * it is "activiti-repo" folder under the installation root
  1. What is the url for activiti explorer web app
    * http://localhost:8181/activiti-explorer
  1. How to change activiti jdbc data source configuration
    * modify the data source properties in the org.activiti.karaf.cfg file under ${install-root}/etc and restart the server.
      * _**note: by modifying the data source to a different db, all your in-flight processes and deployments will not be visible anymore unless you have exported that data to the new db.**_