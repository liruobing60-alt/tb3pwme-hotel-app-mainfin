# Lab 1: Hotel App

Welcome to this first lab.

The application is a simple implementation of a REST API for booking a hotel room.
The objective of the lab is to:

* Improve your understanding of unit testing,
* Discover some new tools (native queries, H2 console)
* Practice with the annotations already seen in class.

## Unit tests

You must implement the methods of the `com.emse.tb3pwme.labs.hotel.reservation.RoomTest` class, using JUnit and AssertJ.

## Missing annotations

I have removed the annotations in `ReservationController`, `RoomEntity`, and `ReservationEntity`, but the system is sufficiently constrained that you can reverse engineer the values I had chosen.
It's up to you to put them back.

## New tools

Look at the `com.emse.tb3pwme.labs.hotel.reservation.persistence.ReservationRepository` interface.
What is the `Long getNextReservationNumber()` method used for?

Find the information you need to log in at http://localhost:8080/h2-console.
How many rooms are there in the hotel?

Write your comments in ANSWERS.md at the root of the project.

## Code the cancellation of a reservation

As with the reservation, add the code needed to delete a reservation by its ID.
Remember to test this implementation in the domain.
