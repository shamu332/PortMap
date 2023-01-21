THIS PROGRESSIVE WEB APPLICATION IS ONLY TO BE USED WITHIN YOUR OWN PRIVATE NETWORK OR ANY NETWORK THAT YOU HAVE PERMISSION TO SCAN! THIS IS FOR EDUCATIONAL PURPOSES ONLY!


With that is out of the way, PortMap is a progressive web application that will allow the user to scan for open ports by inputting an IP address. There is a gif file that demo's how to use this app. The gif file is be under the root folder under "demo.gif". After cloning this repo, You would need to enter the command “run npm” to start within the directory of ” ..\..\port_map\src\main\ui” to run the front end. Then you need to run “src/main/java/com/network/backend/BackendApplication.java” to run the back end.  IntelliJ was used for BackendApplcation.java and maven was used as the building tool.

I used Postgres for this project, and you will need to change the yml file to connect to your database, which is located in "src/main/backend/backend/src/main/resources/application.yml". The database is simple for now and only consists of one table which is shown below.    


![image](https://user-images.githubusercontent.com/57244659/211681321-77d7a288-8fdc-41d6-886f-fe1004fc1f82.png)



This is a work in progress, and I know there is still a lot of work that needs to be done. The project is at a point now where it can be demonstrated, and I am open to any feedback.
