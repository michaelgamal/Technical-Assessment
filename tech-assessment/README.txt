{\rtf1\ansi\ansicpg1252\cocoartf1671
{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red42\green0\blue255;\red0\green0\blue0;}
{\*\expandedcolortbl;;\csgenericrgb\c16471\c0\c100000;\csgray\c0;}
\paperw11900\paperh16840\margl1440\margr1440\vieww28600\viewh17500\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0  \
\
    Overview : \
                   - The tech-assessment project is a Java SpringBoot application was built to fetch the git-hub the public repositories and the each repository contributers for a specific git-hub user.\
                   - The project built using java 8 features, Spring boot and Maven.\
\
\
\
  \
    Pre-requests : \
        \
                    - JDK with minimum version of 1.8\
                    - Java IDE to build the project code, STS  IDE is recommended. \
                    \
 \
     Application Flow :\
\
                     -  The Application initially asks for a git-hub username\
                     -  An http request with method get will be sent to the \'93
\f1 \cf2 https://api.github.com/users/\{username\}/repos\'94.
\f0 \cf0 \
                     -  If the username exists the application retrieve a list for repositories id for the username.\
                     -  The application stream the repositories list and for each repository the application retrieve the list contributors with the no if contribution in the repositroy.\
                     -  For each repository contributors list, the list sorted depending by the no of contribution.\
                     -  Finally the application print the summery for the repositories and contributions for the username.\
\
 \
\
      Project Building steps :\
\
                       - Pull the project from the git-hub\
                       - Import the project as an existing maven project to your IDE (STS recomended)\
                       - Right click on the project from the IDE the select maven-> update project, just to make sure the all dependecies are fetched.\
                       - From the IDE \'97> Export\'97> Runnable Jar.\
                       - From the cmd navigate to the jar directory and run it using the below commend \
                                                 \
                                           
\f1\fs22 \cf3 \CocoaLigature0 java -jar git-hub-tech-assessment.jar  (Assumed the jar name is \'93git-hub-tech-assessment\'94)
\f0\fs24 \cf0 \CocoaLigature1  \
                       - The application will be opened and as for a user name, enter a username and press enter.\
\
\
\
      Known Bugs :\
           \
                      - The Springboot Debug logs are being viewed.\
                      - I am using the System out/ System Error to print to the terminal not the Logger. \
                      - I am handling two kinds only of the response error which are:   \
                                      1- Not found -> when the user not exists\\\
                                      2- The \'93403 Forbidden\'94 and that\'92s happen when too many requests submitted to the git-hub \
                       \
                          There are some other error code should be handled also.\
 }