FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install wget -y

# Instalar Amazon Corretto 18
RUN wget https://corretto.aws/downloads/latest/amazon-corretto-18-x64-linux-jdk.deb
RUN dpkg -i amazon-corretto-18-x64-linux-jdk.deb

COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM amazoncorretto:18

EXPOSE 8080

COPY --from=build /target/deploy_render-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
