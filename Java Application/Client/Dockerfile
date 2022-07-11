FROM openjdk:16-alpine3.13

COPY ./Client.java .

# RUN javac Server.java
# RUN java Server
RUN ["javac","Client.java"]

ENTRYPOINT ["java","Client"]
