FROM openjdk:8u191-jre-alpine3.8
WORKDIR /us/share/udemy
ADD target/Seleium1-0.0.1-SNAPSHOT.jar   ./Seleium1-0.0.1-SNAPSHOT.jar
ADD target/Seleium1-0.0.1-SNAPSHOT-tests.jar   ./Seleium1-0.0.1-SNAPSHOT-tests.jar
ADD target/libs		./libs
ADD book-flight-module.xml	./book-flight-module.xml
ADD search-module.xml		./search-module.xml
ENTRYPOINT java -cp Seleium1-0.0.1-SNAPSHOT.jar:Seleium1-0.0.1-SNAPSHOT-tests.jar:libs/* -DBROWSER=$BROWSER
