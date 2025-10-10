package com.emse.tb3pwme.labs.hotel.reservation.web;

public class RoomRepresentation {

    private final Integer number;

    private final int beds;

    private final boolean available;

    public RoomRepresentation(Integer number, int beds, boolean available) {
        this.number = number;
        this.beds = beds;
        this.available = available;
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
