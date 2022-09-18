# Frievent

This is a mobile application for those people who have certain hobbies but do not have friends who have those hobbies. Or who wants to make friends in a country or city they don’t know at all. It will help people to make new friends and meet new people, thanks to their common hobbies and activities that they wish to do.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `src/main/kotlin/com/frievent/bitirme/BitirmeApplication.kt` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
## About the Service
The service is just a simple tinder-like REST service. It uses PostgreSQL to store the data. (Don't forget to adjust your database connection settings). Application works on port 8080.

Here are some endpoints you can call:
http://localhost:8080/category
http://localhost:8080/register

## Logic Design






## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
