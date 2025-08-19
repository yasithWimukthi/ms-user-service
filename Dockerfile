FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
RUN ./mvnw -q -DskipTests package || (./mvnw -q -DskipTests package)

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/ms-user-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/app.jar"]
