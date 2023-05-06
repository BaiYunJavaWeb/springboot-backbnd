FROM maven:3.8.5-openjdk-17-slim

WORKDIR /app

COPY . /app
RUN mvn package

EXPOSE 1314

CMD ["java", "-jar", "./target/mshop-0.0.1-SNAPSHOT.jar"]