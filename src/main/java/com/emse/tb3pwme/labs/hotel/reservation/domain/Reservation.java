package com.emse.tb3pwme.labs.hotel.reservation.domain;

import java.time.LocalDateTime;

/**
 * Represents a reservation made by a guest for a specific room
 * at a given point in time.
 */
public class Reservation {
/**
     * Unique number identifying this reservation.
     */
    private final Long number;
/**
     * Name of the guest who made the reservation.
     */
    private final String guestName;
/**
     * Date and time at which the reservation was created.
     */
    private final LocalDateTime reservationTime;
/**
     * Room associated with this reservation.
     */
    private final Room room;
/**
     * Creates a new reservation.
     * <p>
     * The {@link #reservationTime} is set to the current date and time.
     *
     * @param number    unique identifier for the reservation
     * @param guestName name of the guest who reserves the room
     * @param room      room that is reserved
     */
    public Reservation(Long number, String guestName, Room room) {
        this.number = number;
        this.guestName = guestName;
        reservationTime = LocalDateTime.now();
        this.room = room;
    }
/**
     * Returns the unique number of this reservation.
     *
     * @return reservation number
     */
    public Long getNumber() {
        return number;
    }
 /**
     * Returns the name of the guest who made this reservation.
     *
     * @return guest name
     */
    public String getGuestName() {
        return guestName;
    }
 /**
     * Returns the date and time when this reservation was created.
     *
     * @return reservation creation time
     */
    public LocalDateTime getReservationTime() {
        return reservationTime;
    }
/**
     * Returns the room that was reserved.
     *
     * @return reserved room
     */
    public Room getRoom() {
        return room;
    }

}
