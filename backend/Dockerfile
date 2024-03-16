FROM maven:latest AS build
WORKDIR /workspace
COPY . .
RUN --mount=type=cache,target=/root/.m2/repository mvn -e -B clean package -Dmaven.test.skip=true

FROM openjdk:17-alpine
COPY --from=build /workspace/target/*.jar Lab4-0.0.1-SNAPSHOT.jar
EXPOSE 8081
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/Lab4-0.0.1-SNAPSHOT.jar"]