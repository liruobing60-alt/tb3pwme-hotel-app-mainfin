### 3. Add documentation & generate reference documentation

I added Javadoc comments in the following files:
- src/main/java/com/emse/tb3pwme/labs/hotel/reservation/domain/Room.java
- src/main/java/com/emse/tb3pwme/labs/hotel/reservation/domain/Reservation.java
- src/main/java/com/emse/tb3pwme/labs/hotel/reservation/ReservationService.java

How to generate the reference documentation:
1. Windows:
    ```bash
    .\gradlew.bat javadoc
    ```
2. Mac/Linux:
    ```bash
    ./gradlew javadoc
    ```
The generated documentation can be found locally in:
build/docs/javadoc/index.html