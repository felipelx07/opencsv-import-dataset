## OpenCSV Import Dataset

#### Technologies used: 

- JavaEE 8 (CDI/JPA/JSF) 
- Jboss Thorntail 2.4.0.Final (similar to SpringBoot) 

*others*
- Primefaces
- Log4j
- Hibernate
- Lombok
- Arquillian (Junit)


#### Instructions
1º -  Install & Configure Maven w/ Java 8

2º -  Clone this project

3º - Create a Postgres DB w/ that credentials
```
DATABASE: caers
USERNAME: caers
PASSWORD: caers
```

4º - Build the Project & Run
```
mvn package && mvn thorntail:run
```
