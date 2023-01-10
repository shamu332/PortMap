THIS IS ONLY TO BE USED WITHIN YOUR OWN PRIVATE NETWORK OR ANY NETWORK THAT YOU HAVE PERMISSION TO SCAN! THIS IS FOR EDUCATIONAL PURPOSES ONLY!


Since that is out of the way. PortMap is a progressive web application that would allow the user to scan for open ports by inputting an IP address. I added a gif file to demo what the app can do. The gif file should be under the root folder under demo.gif. You would need to “run npm” start within the directory of ” ..\..\port_map\src\main\ui” to run the front end. Then you need to run “src/main/java/com/network/backend/BackendApplication.java” to run the back end. I ran BackendApplcation.java using IntelliJ and I am using maven as the building tool.

I use Postgres for this project, and you need to change the yml file to connect to your database, which is located in src/main/backend/backend/src/main/resources/application.yml. The database is simple for now and only consists of one table which is shown below.    


![image](https://user-images.githubusercontent.com/57244659/211681321-77d7a288-8fdc-41d6-886f-fe1004fc1f82.png)



This is a work in progress, and I know there is still a lot of work that needs to be done. The project is at a point now where it can be demonstrated, and I am open to any feedback.
