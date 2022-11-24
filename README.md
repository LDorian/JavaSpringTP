## Requirements
<!--- Write a short description of the maven requirements for this project -->
<!-- For example: Java 8, Maven 3.3.9, etc. -->
- Java 19
- Maven 3.8.1
- MySQL 5.6
<!-- Write spring dependencies -->
## Spring dependencies
- Spring Boot 2.7.5
- Spring Data JPA 2.7.5
- Spring Web 2.7.5
- Spring Webflux 2.7.5
- Spring Test 2.7.5
- Spring Starter Validation 2.7.5
- MySQL Connector 8.0.31
- Lombok 1.18.24
- MapStruct 1.5.3.Final
- Springfox Boot Starter 3.0.0
- Jakarta Annotations 1.3.5
- Jackson 2.14.0
## Installation
<!--- How to install the project -->
<!--- Write the steps to install a maven project -->
Step 1: Clone the project
```bash
git clone
```
Step 2: Go to the project folder
```bash
cd
```
Step 3: Run the project
```bash
mvn spring-boot:run
```
## Configuration
<!--- How to configure the project -->
<!--- Write the steps to configure a maven project -->
Step 1: Go to the project folder
```bash
cd 
```
Step 2: Open the file called application.properties
```bash
vi src/main/resources/application.properties
```
Step 3: Modify the following properties according to your database configuration
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
```

## Usage
<!--- How to use the project -->
<!--- Write the steps to use a maven project -->
Step 1: Go to the project folder
```bash
cd
```
Step 2: Run the project
```bash
mvn spring-boot:run
```
## Authors
<!--- Write the authors of the project -->
- Dorian Lamour
