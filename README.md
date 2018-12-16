# Sumup Automation Challenge

Welcome to SumUp Automation Challenge. Bellow there is a few important instructions to run this project. 

First of all, you will need configure this requirements in your environment
* Java 8 (https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Apache Maven 3.2.5 (https://maven.apache.org/)
* Firefox 64.0
* Chrome 70+


## How to run this project?
It is really simple to run this project, just follow this steps:

Pre-step:
  * Install git in your computer.

After git was installed:

  * Clone this project in your computer.
  * after the project has been cloned, access the directory *sumupChallenge* using your terminal. 
  * than, execute this command "mvn clean install". Now this project will be building and executed.
  
##

It is possible to execute the mvn command with additional parameters, like:
  * **host** = This propertie will define the host where the application was deployed. By default it will always open in **"https://me.sumup.com/"** 
  * **browser** = It's possible to choose between two options: chrome or firefox. **Chrome** is defined by default.
  * **lang** = It's possible to choose which language the browser will be run. If you don't define this propertie, the browser will run using **English** by default.


Example how to run the project using the properties above:

mvn clean install -Dbrowser=chrome -Dlang="us" -Dhost='https://tst.sumup.com/'

After the tests were ran, you can see the results in: **./sumupChallenge/target/surefire-reports/html/index.html**
