package com.emse.tb3pwme.labs.hotel.reservation.domain;

import java.time.LocalDateTime;

public class Reservation {

    private final Long number;

    private final String guestName;

    private final LocalDateTime reservationTime;

    private final Room room;

    public Reservation(Long number, String guestName, Room room) {
        this.number = number;
        this.guestName = guestName;
        reservationTime = LocalDateTime.now();
        this.room = room;
    }

    public Long getNumber() {
        return number;
    }

    public String getGuestName() {
        return guestName;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public Room getRoom() {
        return room;
    }

}
