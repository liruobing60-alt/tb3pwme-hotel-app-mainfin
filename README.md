# Hotel Reservation API – Build Tool Demonstration Project

This project is a simple Spring Boot application exposing a REST API for managing hotel room reservations. It is used in this assignment to demonstrate how to set up, configure, and document a modern build tool (Gradle) within a non-trivial Java project.

---

## 1. Project Overview

The application includes:

- REST endpoints to create, list, and cancel reservations
- A domain layer (Room, Reservation, ReservationNumberGenerator)
- A persistence layer using Spring Data JPA
- Database initialization through `schema.sql` and `data.sql`
- Unit and integration tests using JUnit and AssertJ
- An in-memory H2 database

This codebase was originally provided as part of a lab exercise. For this build-tool assignment, I focused on:

- Ensuring the Gradle build is fully functional
- Documenting how to build, test, and run the project
- Verifying dependency management and packaging
- Providing a clear and reproducible setup through Gradle Wrapper

---

## 2. Build Tool: Gradle

This project uses **Gradle Kotlin DSL** (`build.gradle.kts`).

Gradle is used to automate:

### ✔ Dependency Management

Dependencies such as Spring Boot Starter Web, Spring Boot Starter JPA, H2 Database, Lombok, JUnit, and AssertJ are declared in `build.gradle.kts`.

### ✔ Compilation

Gradle automatically compiles the Java source code under:
- `src/main/java`
- `src/test/java`

### ✔ Testing

All unit and integration tests run with:

```bash
./gradlew test
```

### ✔ Packaging

Gradle builds an executable **Spring Boot fat JAR**:

```bash
./gradlew build
```

The final JAR is generated under:

```
build/libs/
```

---

## 3. How to Build the Project

### Build the application:

```bash
./gradlew build
```

### Run all tests:

```bash
./gradlew test
```

(Build succeeds only if tests pass.)

---

## 4. How to Run the Application

Start the Spring Boot server:

```bash
./gradlew bootRun
```

The API is available at:

```
http://localhost:8080
```

---

## 5. Database (H2 Console)

During runtime, you can access the in-memory H2 database at:

```
http://localhost:8080/h2-console
```

Default connection properties:

- **JDBC URL:** `jdbc:h2:mem:testdb`
- **User:** `sa`
- **Password:** (empty)

---

## 6. Project Structure

```
src/
 └── main/
     ├── java/com/emse/tb3pwme/labs/hotel/reservation/
     │   ├── domain/
     │   │   ├── Room.java
     │   │   ├── Reservation.java
     │   │   └── ReservationNumberGenerator.java
     │   ├── persistence/
     │   │   ├── RoomEntity.java
     │   │   ├── RoomRepository.java
     │   │   ├── ReservationEntity.java
     │   │   └── ReservationRepository.java
     │   └── web/
     │       ├── RoomRepresentation.java
     │       ├── ReservationRepresentation.java
     │       ├── ReservationController.java
     │       ├── ReservationService.java
     │       └── HotelAppApplication.java
     └── resources/
         ├── application.properties
         ├── schema.sql
         └── data.sql

test/
 └── java/com/emse/tb3pwme/labs/hotel/reservation/
     ├── RoomTest.java
     ├── CancelReservationTest.java
     ├── ReservationIntegrationTest.java
     └── HotelAppApplicationTests.java
```

---

## 7. Dependencies (from build.gradle.kts)

Main dependencies include:

- `org.springframework.boot:spring-boot-starter-web`
- `org.springframework.boot:spring-boot-starter-data-jpa`
- `com.h2database:h2`
- `org.projectlombok:lombok`
- `org.springframework.boot:spring-boot-starter-test`
- `org.assertj:assertj-core`


---

## Static Code Analysis (Checkstyle)

This project uses **Checkstyle** for static code analysis.

### How to install

1. Install the VS Code extension **"Checkstyle for Java"**.
2. Open this project folder in VS Code.
3. Checkstyle configuration file is located at: `./checkstyle.xml`.

### How to run

- Right-click on any Java file or the `src` folder and select  
  **"Check Code with Checkstyle"**  
  or  
- Open the Command Palette and run **"Checkstyle: Check Code"**.

The current configuration checks indentation, unused imports, braces, naming conventions, and other basic style rules.
