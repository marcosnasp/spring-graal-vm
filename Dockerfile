FROM eclipse-temurin:20.0.2_9-jdk-jammy as spring-builder
RUN addgroup spring; adduser  --ingroup spring --disabled-password spring
USER demo

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
RUN ./mvnw clean install

FROM eclipse-temurin:20.0.2_9-jre-alpine
WORKDIR /opt/app
EXPOSE 8080
COPY --from=spring-builder /app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar" ]

CMD ["./mvnw", "spring-boot:run"]