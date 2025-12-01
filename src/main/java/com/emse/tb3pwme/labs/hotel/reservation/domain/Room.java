package com.emse.tb3pwme.labs.hotel.reservation.domain;
/**
 * Represents a room in the hotel.
 * A room has a number, a number of beds and an availability flag.
 */
public class Room {
  /**
     * Unique number used to identify the room.
     */
    private final Integer number;
 /**
     * Number of beds available in the room.
     */
    private final int beds;
 /**
     * {@code true} if the room can currently be reserved, {@code false} otherwise.
     */
    private boolean available;

/**
     * Creates a new room instance.
     *
     * @param number    unique number identifying the room
     * @param beds      number of beds in the room
     * @param available initial availability of the room
     */
    public Room(Integer number, int beds, boolean available) {
        this.number = number;
        this.beds = beds;
        this.available = available;
    }

    
    /**
     * Creates a reservation for this room.
     * <p>
     * If the room is not available, an {@link IllegalStateException} is thrown.
     * When the reservation is created, the room becomes unavailable.
     *
     * @param generator reservation number generator used to create a unique number
     * @param guestName name of the guest who reserves the room
     * @return the created {@link Reservation}
     * @throws IllegalStateException if the room is not available
     */
    public Reservation reserve(ReservationNumberGenerator generator, String guestName) {
        if (!available) {
            throw new IllegalStateException("Room %d is unavailable".formatted(number));
        }
        available = false;
        return new Reservation(generator.getNextReservationNumber(), guestName, this);
    }

    /**
     * Returns the unique number of this room.
     *
     * @return the room number
     */
    public Integer getNumber() {
        return number;
    }
 /**
     * Returns the number of beds in this room.
     *
     * @return number of beds
     */
    public int getBeds() {
        return beds;
    }
  /**
     * Indicates whether this room is available for reservation.
     *
     * @return {@code true} if the room is available, {@code false} otherwise
     */
    public boolean isAvailable() {
        return available;
    }

}
