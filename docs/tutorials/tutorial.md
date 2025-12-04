# Hotel Reservation App – Quick Tutorial

This tutorial explains how to download, run and test the Hotel Reservation App used for the TB3PWME lab.

---

## 1. Clone the project

To download the project from GitHub, run:

```bash
git clone https://github.com/liruobing60-alt/tb3pwme-hotel-app-mainfin.git
cd tb3pwme-hotel-app-mainfin
```

---

## 2. Run the application

### On Windows:

```bash
.\gradlew.bat bootRun
```

### On macOS / Linux:

```bash
./gradlew bootRun
```
---

## 3. Run the tests

To execute all tests:

```bash
.\gradlew.bat test
# or
./gradlew test
```

If everything is correct, you should see:

```
BUILD SUCCESSFUL
```

---

## 4. Generate the reference documentation (Javadoc)

To generate Java API documentation:

### Windows:

```bash
.\gradlew.bat javadoc
```

### Mac / Linux:

```bash
./gradlew javadoc
```

The generated HTML files can be found in:

```
build/docs/javadoc/index.html
```

Open this file in your browser to view the documentation.

---

## 5. Project structure (simplified)

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

## 6. License

This project is distributed under the MIT License.
See the `LICENSE` file for more information.
