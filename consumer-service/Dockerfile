FROM openjdk:8-jre-alpine
ARG version=1.0-SNAPSHOT
ENV APP_NAME=consumer-service
COPY target/${APP_NAME}-${version}.jar /${APP_NAME}.jar
ENTRYPOINT exec java -jar /${APP_NAME}.jar
