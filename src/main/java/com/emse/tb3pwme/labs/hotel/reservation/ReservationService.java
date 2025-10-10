package com.emse.tb3pwme.labs.hotel.reservation;

import com.emse.tb3pwme.labs.hotel.reservation.domain.Reservation;
import com.emse.tb3pwme.labs.hotel.reservation.domain.ReservationNumberGenerator;
import com.emse.tb3pwme.labs.hotel.reservation.domain.Room;
import com.emse.tb3pwme.labs.hotel.reservation.persistence.ReservationEntity;
import com.emse.tb3pwme.labs.hotel.reservation.persistence.ReservationRepository;
import com.emse.tb3pwme.labs.hotel.reservation.persistence.RoomEntity;
import com.emse.tb3pwme.labs.hotel.reservation.persistence.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    private final RoomRepository roomRepository;

    private final ReservationRepository reservationRepository;

    private final ReservationNumberGenerator generator;

    public ReservationService(RoomRepository roomRepository, ReservationRepository reservationRepository, ReservationNumberGenerator generator) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.generator = generator;
    }

    public void reserve(Integer roomNumber, String guestName) {
        Optional<RoomEntity> optionalRoomEntity = roomRepository.findById(roomNumber);
        RoomEntity roomEntity = optionalRoomEntity.orElseThrow(() -> new IllegalStateException("Room %d does not exist".formatted(roomNumber)));
        Room room = roomEntity.toDomain();
        Reservation reservation = room.reserve(generator, guestName);
        ReservationEntity reservationEntity = ReservationEntity.fromDomain(reservation);
        roomEntity.setAvailable(room.isAvailable());
        roomRepository.save(roomEntity);
        reservationRepository.save(reservationEntity);
    }


    public void cancel(Long reservationId) {

        if (!reservationRepository.existsById(reservationId)) {
            throw new IllegalStateException("Reservation " + reservationId + " does not exist");
        }


        reservationRepository.deleteById(reservationId);
    }


}
