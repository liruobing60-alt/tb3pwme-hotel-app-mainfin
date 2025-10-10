package com.emse.tb3pwme.labs.hotel.reservation.persistence;

import com.emse.tb3pwme.labs.hotel.reservation.domain.Room;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROOM")
public class RoomEntity {
    @Id
    private Integer number;

    private int beds;

    private boolean available;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static RoomEntity fromDomain(Room room) {
        RoomEntity entity = new RoomEntity();
        entity.setNumber(room.getNumber());
        entity.setAvailable(room.isAvailable());
        entity.setBeds(room.getBeds());
        return entity;
    }
    public Room toDomain() {
        return new Room(number, beds, available);
    }

}
