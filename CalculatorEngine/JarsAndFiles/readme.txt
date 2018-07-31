Calculator Engine is an app that calculates the operations from input file,
with the configurations from configFile and it writes the results to a file named output.txt.

Requirements:  
 To run the app: at least jre 1.8
 To extend the app: at least jdk 1.8

Files:
 AppCore-0.0.1-SNAPSHOT-jar-with-dependencies.jar
 CalcEngine-API-0.0.1-SNAPSHOT.jar
 CalcEngine-Impl-0.0.1-SNAPSHOT.jar
 configFile.properties
 input.txt
 
How to Run the app:
 in command line: java -jar AppCore-0.0.1-SNAPSHOT-jar-with-dependencies.jar input.txt configFile.properties
 
How to extend the app:
 1.Write the implementation of the classes that will extend the application (for this, you need to use CalcEngine-API as a dependency and you need to extend one of the following classes:
 MathOperation,Unary(for operations with 1 operand), Binary(for operations with 2 operands) or Aggregation( for operations where the number of operands vary from 1 to many)) 
 2.Package them in a jar
 3.Change input.txt with the desired operation 
 4.Add in configFile the classes (eg. Max=com.extension.Max)
 5.Run the following command: 
  java -cp AppCore-0.0.1-SNAPSHOT-jar-with-dependencies.jar;ExtensionJarName.jar com.wkfsfrc.ce.AppCore.MainApp input.txt configFile.properties
  (com.wkfsfrc.ce.AppCore.MainApp -the main class of the application)