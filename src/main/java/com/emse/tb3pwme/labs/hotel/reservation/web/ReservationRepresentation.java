package com.emse.tb3pwme.labs.hotel.reservation.web;

import java.time.LocalDateTime;

public class ReservationRepresentation {

    private final Long id;

    private final String guestName;

    private final LocalDateTime reservationTime;

    private final RoomRepresentation room;

    public ReservationRepresentation(Long id, String guestName, LocalDateTime reservationTime, RoomRepresentation room) {
        this.id = id;
        this.guestName = guestName;
        this.reservationTime = reservationTime;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public String getGuestName() {
        return guestName;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public RoomRepresentation getRoom() {
        return room;
    }

}
