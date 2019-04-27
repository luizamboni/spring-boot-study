FROM maven:3-jdk-8


# First copy only the pom file. This is the file with less change
COPY ./pom.xml ./app/pom.xml

WORKDIR /app
# Download the package and make it cached in docker image
RUN mvn dependency:go-offline -B

COPY . /app

RUN mvn package

ENTRYPOINT  [ "java",  "-jar", "target/configServer-0.0.1-SNAPSHOT.jar" ]