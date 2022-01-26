FROM openjdk:12
COPY . /PhraseCount
WORKDIR /PhraseCount
RUN ./gradlew build
ENTRYPOINT ["./gradlew", "run"]
CMD ["--args='src/test/resources/mobydick.txt'"]