package com.emse.tb3pwme.labs.hotel.reservation.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

    List<RoomEntity> findByAvailableTrue();

}
