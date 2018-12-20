FROM openjdk:8-jre-alpine

ADD target/microservice.jar /app.jar

ADD entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh 
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JHIPSTER_SLEEP=0 \
    JAVA_OPTS=""


ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8001

