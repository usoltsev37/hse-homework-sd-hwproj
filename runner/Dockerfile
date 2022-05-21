FROM amazoncorretto:11-alpine-jdk

RUN mkdir /data
WORKDIR /data
COPY . /data

RUN ./gradlew build

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/runner-0.0.1-SNAPSHOT.jar"]