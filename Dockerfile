FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

COPY --from=build /app/Wallet_DUOC /app/wallet

ENV TNS_ADMIN=/app/wallet

EXPOSE 8080
ENTRYPOINT ["java", "-DTNS_ADMIN=/app/wallet", "-jar", "app.jar"]

