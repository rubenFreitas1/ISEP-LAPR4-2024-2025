ECHO OFF
echo Running shodrone-app1...
SET BASE_CP=shodrone.app1/target/shodrone.app1-0.1.0.jar;shodrone.app1/target/dependency/*;

java -cp %BASE_CP% hello.HelloWorld
