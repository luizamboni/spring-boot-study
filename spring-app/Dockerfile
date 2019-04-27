FROM maven:3-jdk-8


# First copy only the pom file. This is the file with less change
COPY ./pom.xml ./app/pom.xml

WORKDIR /app
# Download the package and make it cached in docker image
RUN mvn dependency:go-offline -B

COPY . /app

# RUN sed -i 's/127\.0\.0\.1/rabbit/g' src/main/resources/application.yml

RUN mvn package

ENTRYPOINT  [ "java",  "-jar", "target/demo-0.0.1-SNAPSHOT.jar" ]