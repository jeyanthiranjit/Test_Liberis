#!/bin/sh



##directory where jar file is located    - You need to update this once saved in ur local
dir=C:/Users/jeyan/eclipse-workspace/Test_Project/target

##jar file name
jar_name=Test_Project-0.0.1-SNAPSHOT.jar

cp C:/Users/jeyan/eclipse-workspace/Test_Project/build.sh target/
## Permform some validation on input arguments, one example below


java -jar $dir/$jar_name arg1 arg2

chmod u+x C:/Users/jeyan/eclipse-workspace/Test_Project/target/build.sh