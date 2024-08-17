FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install -y openjdk-20-jdk maven

ENV JAVA_HOME=/usr/lib/jvm/java-20-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

COPY . .

RUN mvn clean install

FROM ubuntu:latest

RUN apt-get update
RUN apt-get install -y openjdk-20-jdk

ENV JAVA_HOME=/usr/lib/jvm/java-20-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

EXPOSE 8080

COPY --from=build /target/deploy_render-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
