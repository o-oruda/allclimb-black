# 실행 환경 설정: 경량화된 JDK 21 기반
FROM openjdk:21-jdk-slim

# GitHub Actions에서 빌드한 .jar 파일을 복사
COPY build/libs/*.jar app.jar

# 애플리케이션 포트 설정
EXPOSE 8080

# Spring Boot 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]
