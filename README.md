# Description
Please create a program executable from the command line that when given text(s) 
will return a list of the 100 most common three word sequences.

# Installation and Running Application
I used Intellij Community Edition and used jdk 1.8. I prefer Intellij as the ultimate edition 
supports with adding databases and refactoring is very easy.

### Prerequisites

Java JDK or JRE version 8 or higher must be installed. To check, run `java -version`:

```bash
$ java -version
java version "1.8.0_321"
```

### Clone and Build Project
- I use GitBash/IntelliJ

```bash
# Clone Repository
git clone https://github.com/madhavibheema/PhraseCount.git 
git checkout master

# Build Application - Invoke gradlew to execute the build
./gradlew build
```

### How to run the program -  gradle

```bash
# Runs the main method from App.java with the supplied file
./gradlew run --args='src/test/resources/mobydick.txt'

Or

# Runs the main method from PhraseCount.java with input from stdin
cat src/test/resources/mobydick.txt | ./gradlew run
```



### What you would do next, given more time (if anything)?
-For Asynchronous processing we can use Kafka/Rabbit MQ. 
-I would have preferred creating Spring Boot Rest based microservice which uses Kafka
 to asynchronously consume and process the file and create/update entries in DB. 
- Implement validations in UI if there are file size/data restrictions and display error messages to user.
- Do load testing during peak/nonpeak hours with different file sizes.


###* Are there bugs that you are aware of?
None