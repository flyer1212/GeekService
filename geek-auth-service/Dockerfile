FROM openjdk:8-jdk-alpine
# copy arthas
COPY --from=hengyunabc/arthas:latest /opt/arthas /opt/arthas
RUN apk add --no-cache tini
ENTRYPOINT ["/sbin/tini", "--"]

ADD ./target/geek-auth-service-1.0.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/geek-auth-service-1.0.jar"]

EXPOSE 18000