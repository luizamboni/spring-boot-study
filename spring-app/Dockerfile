FROM maven:3-jdk-8


COPY . app

WORKDIR /app

ENTRYPOINT [ "mvn", "clean", "package", "spring-boot:run", "-Drun.jvmArguments='-Dserver.port=8080'"]
