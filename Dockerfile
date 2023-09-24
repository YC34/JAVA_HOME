# OpenJDK 17 베이스 이미지
# OpenJDK 17 베이스 이미지
FROM openjdk:17

# 호스트에서 JAR 파일을 복사하여 컨테이너 내부로 복사
COPY build/libs/board-0.0.1-SNAPSHOT.jar app.jar

# 컨테이너에서 노출할 포트 지정
EXPOSE 19000

# JAR 파일을 실행
ENTRYPOINT ["java", "-jar", "app.jar"]

