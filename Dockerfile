FROM amazoncorretto:17.0.10
WORKDIR /app
ARG localizacao_build=/tmp/secret.properties
ENV localizacao=$localizacao_build
EXPOSE 8080
#RUN mkdir -p "/var/logs/spring"
COPY target/cervejas-0.0.1-SNAPSHOT.jar app.jar
COPY secret-prod.properties /tmp/secret.properties
ENTRYPOINT ["java", "-jar", "app.jar"]