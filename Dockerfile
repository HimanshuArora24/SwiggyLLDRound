FROM openjdk:19
WORKDIR /app
COPY . /app
RUN  javac -cp src/main/java src/main/java/MagicalArenaGame.java
CMD ["java", "-cp", "src/main/java", "MagicalArenaGame"]