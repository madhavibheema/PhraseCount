# Description
Please create a program executable from the command line that when given text(s) 
will return a list of the 100 most common three word sequences.

# Software Used
- Intellij Community Edition with jdk 1.8. 
- Github.
- I prefer Intellij as the ultimate edition supports adding databases within IDE and refactoring is very easy. We do need a separated DB tool and it saves time.

# Installation and Running Application

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


### Output Sample - ./gradlew run --args='src/test/resources/mobydick.txt'
- Printing TOP 100 Phrases for :src/test/resources/mobydick.txt
- Phrase #################################  Frequency
- the sperm whale                          | 84
- whale the sperm                          | 83
- of the whale                             | 48



### What you would do next, given more time (if anything)?
-For Asynchronous processing we can use Kafka/Rabbit MQ. With limited resources I did not do that.
-I would have preferred creating Spring Boot Rest based microservice which uses Kafka
 to asynchronously consume and process the file and create/update entries in DB. 
- Implement validations for file size/data restrictions if any and display error messages to user.
- Do load testing during peak/nonpeak hours with different file sizes. 
- Did not work on UTF-8 string comparision due to time constraint.
- Tried with different matcher combinations but went ahead with considering hyphen and apostrophe.

### Are there bugs that you are aware of?
None
