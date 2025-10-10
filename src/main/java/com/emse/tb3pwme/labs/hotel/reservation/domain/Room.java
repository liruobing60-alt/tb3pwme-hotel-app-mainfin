package com.emse.tb3pwme.labs.hotel.reservation.domain;

public class Room {

    private final Integer number;

    private final int beds;

    private boolean available;

    public Room(Integer number, int beds, boolean available) {
        this.number = number;
        this.beds = beds;
        this.available = available;
    }

    public Reservation reserve(ReservationNumberGenerator generator, String guestName) {
        if (!available) {
            throw new IllegalStateException("Room %d is unavailable".formatted(number));
        }
        available = false;
        return new Reservation(generator.getNextReservationNumber(), guestName, this);
    }

    public Integer getNumber() {
        return number;
    }

    public int getBeds() {
        return beds;
    }

    public boolean isAvailable() {
        return available;
    }

}
