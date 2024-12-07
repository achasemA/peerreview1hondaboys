This is a point-and-click horror story game.

Prerequisites
git 2
maven 3
JDK 21
OpenJavaFX 21 (Find OS Specific Downloads Here)
How to compile
mvn clean install

How to run with maven
mvn javafx:run

How to run with just Java
Replace /path/to/openjavafx to your actual install location of Open JavaFX:

java --module-path /path/to/openjavafx/lib --add-modules javafx.controls -jar .\target\FinalProject-0.0.1.jar

How to run with IntelliJ
Open src/main/java/edu/sdccd/cisc190/Main.java
Press the green play button on Current File on the upper right.
A run configuration should automatically be generated for Main.
Click the run configuration drop down on the upper right and click Edit Configurations...
In the Run/Debug Configurations popup, select Main on the left nav.
Click the Modify options dropdown and select Add VM Options.
Add --module-path /path/to/openjavafx/lib --add-modules javafx.controls, changing /path/to/openjavafx to the location you have it installed on your machine
