 

    Overview : 
                   - The tech-assessment project is a Java SpringBoot application was built to fetch the git-hub the public repositories and the each repository contributers for a specific git-hub user.
                   - The project built using java 8 features, Spring boot and Maven.



  
    Pre-requests : 
        
                    - JDK with minimum version of 1.8
                    - Java IDE to build the project code, STS  IDE is recommended. 
                    
 
     Application Flow :

                     -  The Application initially asks for a git-hub username
                     -  An http request with method get will be sent to the “https://api.github.com/users/{username}/repos”.
                     -  If the username exists the application retrieve a list for repositories id for the username.
                     -  The application stream the repositories list and for each repository the application retrieve the list                          contributors with the no if contribution in the repositroy.
                     -  For each repository contributors list, the list sorted depending by the no of contribution.
                     -  Finally the application print the summery for the repositories and contributions for the username.

 

    Project Building steps :

                       - Pull the project from the git-hub
                       - Import the project as an existing maven project to your IDE (STS recomended)
                       - Right click on the project from the IDE the select maven-> update project, just to make sure the all                            dependecies are fetched.
                       - From the IDE —> Export—> Runnable Jar.
                       - From the cmd navigate to the jar directory and run it using the below commend 
                                                 
                             java -jar git-hub-tech-assessment.jar  (Assumed the jar name is “git-hub-tech-                                                 assessment”) 
                       - The application will be opened and as for a user name, enter a username and press enter.



      Known Bugs :
           
                      - The Springboot Debug logs are being viewed.
                      - I am using the System out/ System Error to print to the terminal not the Logger. 
                      - I am handling two kinds only of the response error which are:   
                                      1- Not found -> when the user not exists\
                                      2- The “403 Forbidden” and that’s happen when too many requests submitted to the git-hub 
                       
                          There are some other error code should be handled also.
 
