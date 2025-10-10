package com.emse.tb3pwme.labs.hotel.reservation.persistence;

import com.emse.tb3pwme.labs.hotel.reservation.domain.ReservationNumberGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long>, ReservationNumberGenerator {

    @Query(value = "SELECT NEXTVAL('reservation_number_seq')", nativeQuery = true)
    Long getNextReservationNumber();

}
