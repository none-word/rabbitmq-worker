FROM openjdk:17

WORKDIR /consumer

COPY . .

EXPOSE 4502

RUN chmod +x mvnw
ENTRYPOINT ["./mvnw", "spring-boot:run"]