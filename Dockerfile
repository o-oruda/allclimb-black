FROM amazoncorretto:21-alpine3.19-jdk
COPY user-api/build/libs/*.jar user-api.jar
ENTRYPOINT ["java", "-jar", "/user-api.jar"]