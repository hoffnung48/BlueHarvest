# BlueHarvest
API 


# READ ME PLEASE


prerequisites


  - Java 8
  -  Docker(if uses docker to run)


This is the Blue Harvest assessment than can be run by


    - Eclipse IDE
    - Executable JAR
    - Docker


Note: for docker and executable jar the commands must be run from projects root directory


# For Eclipse


  - Import the project as Gradle Project 
  - Run as SpringBoot App


# For Executable Jar


  - In command line run
  

    - Gradlew build
    - cd build/libs
    - java - jar [Generated jarName]


# For Docker  


  - Gradlew build
  - docker build -t blueharvest .
  - docker run -p 12000:12000 blueharvest


Once the App Starts


We have to URls to test



| H2 DB | [http://127.0.0.1:12000/h2-console] |


| Swagger | [http://127.0.0.1:12000/swagger-ui.html] |


Note: For H2 DB console ensure use jdbc:h2:mem:testdb



The Blue Harvest API has two endpoints 


    /Accounts

 - create Account
 - get Account

 
Note: for create account just need to send this model the complete model is unnecessary



{
  "customerId": 1,
  "initialCredit": 1,
}



    /Customer   
 - getCustomer



**Welcome to the Blue Harvest Assessment**