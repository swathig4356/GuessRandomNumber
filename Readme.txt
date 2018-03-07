##########
# Prerequasites for running the program
##########
1. Ensure to have JDK 1.8 Installed and path is configured in System PATH with <JDK_INSTALLED_FLDER>\bin folder.
    > Open console and type 'java -version'. If error is thrown, ensure to configure the path correctly.

2. Ensure to have Gradle 4+ downloaded, extracted and path is configured in System PATH with <GRADLE_FLDER>\bin.
    > Open console and type 'gradle -v'. If error is thrown, ensure to configure the path correctly.

#########################
## Steps to execute the program
#########################
1. Extract the project project code in any specific location
2. Open new command window and navigate to the project root folder.
3. Run 'gradle clean build'. This should download the required artifacts and build the project jar file.
    > If any errors are reported, ensure to check the pre-requisets are configured correctly.
4. Once build is successfull, Run 'gradle run'. this should start the application on port 8080.
5. Open browser and access http://localhost:8080/

#######
# Test Cases
#######

1. Number guess successfull on 2nd Attempt

2. Number guess not sucessfull after 3rd Attempt