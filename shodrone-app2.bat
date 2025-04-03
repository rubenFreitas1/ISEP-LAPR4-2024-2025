ECHO OFF
echo Running shodrone-app2...
SET BASE_CP=shodrone.app2/target/shodrone.app2-0.1.0.jar;shodrone.app2/target/dependency/*;

java -cp %BASE_CP% hello2.HelloWorld

