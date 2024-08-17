FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install wget -y

RUN wget https://download.oracle.com/java/20/latest/jdk-20_linux-x64_bin.deb
RUN dpkg -i jdk-20_linux-x64_bin.deb

COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM oraclelinux:8-slim

EXPOSE 8080

COPY --from=build /target/deploy_render-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]