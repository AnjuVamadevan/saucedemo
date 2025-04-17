# saucedemo

# Run commands 
mvn clean test
mvn clean test -D browsername="firefox"
mvn clean test -D browsername="safari"

#for allure reports after run 
allure serve target/allure-results
