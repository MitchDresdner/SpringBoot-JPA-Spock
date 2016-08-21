# SpringBoot-JPA-Spock
###Spring Boot project which integrates JPA, JUnit and Spock (extended sample from Craig Walls book)

Uses 
* MySQL Hibernate/JPA
* Spock
* JUnit

run: gradle test

Built using the following versions
* Gradle 2.3
* Groovy 2.3.9
* Java 1.8.0_60

Worked Around:
1. Spock 1.0 doesn't support `@SpringBootTest`

```
  resolved: Moved to Spock 1.1 RC
  testCompile('org.spockframework:spock-core:1.1-groovy-2.4-rc-1')
  testCompile('org.spockframework:spock-spring:1.1-groovy-2.4-rc-1')
```
  `see:` [stackoverflow description](http://stackoverflow.com/questions/38544788/spring-boot-1-4-spock-and-application-properties/38552695#38552695)
  