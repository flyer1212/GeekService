FROM java:8-jre
ADD ./target/geek-message-service-1.0.jar /app/
# COPY nginx.conf /usr/local/openresty/nginx/conf/nginx.conf
CMD ["java", "-Xmx200m", "-jar", "/app/geek-message-service-1.0.jar"]

EXPOSE 18008
EXPOSE 18009