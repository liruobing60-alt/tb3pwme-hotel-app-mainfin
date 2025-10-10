package com.emse.tb3pwme.labs.hotel.reservation.persistence;

import com.emse.tb3pwme.labs.hotel.reservation.domain.Reservation;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATION")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guestName;

    private LocalDateTime reservationTime;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public static ReservationEntity fromDomain(Reservation reservation) {
        ReservationEntity entity = new ReservationEntity();
        entity.setId(reservation.getNumber());
        entity.setGuestName(reservation.getGuestName());
        entity.setReservationTime(reservation.getReservationTime());
        entity.setRoom(RoomEntity.fromDomain(reservation.getRoom()));
        return entity;
    }

}
