# Commulade
Le 6ème projet du parcours "Développeur d'Application - Java" de OpenClassrooms


## Informations
This project make usage of the Maven architecture and is mainly made to be used with Tomcat and PostgreSQL

The passwords aren't encrypted before being stored because there was no real focus on security aspects while doing the project.
The same go for Users who can easily be impersonated by cookies poisonning

No pictures are provided to go with the demoData for the database, either add some after renaming them or just ignore it


## Configuration
You can find the configuration files under the "config" folder.

For Tomcat, just add the content of "context.xml" to your own setup however you want it.

To use a custom log4j2 configuration file, add this to your VM arguments: -Dlog4j.configurationFile="path/to/your/file"
See the file "AutoStart_tomcat.bat" in "Tomcat/example" folder for a Windows example
You can find the file used for testing in "Log4j2" folder
