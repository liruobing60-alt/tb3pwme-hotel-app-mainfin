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
/**
 * Service responsible for handling room reservations:
 * creating new reservations and cancelling existing ones.
 */
@Service
public class ReservationService {

    private final RoomRepository roomRepository;

    private final ReservationRepository reservationRepository;

    private final ReservationNumberGenerator generator;

    /**
     * Creates a new {@code ReservationService}.
     *
     * @param roomRepository        repository used to access room data
     * @param reservationRepository repository used to access reservation data
     * @param generator             generator used to create unique reservation numbers
     */
    public ReservationService(RoomRepository roomRepository, ReservationRepository reservationRepository, ReservationNumberGenerator generator) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.generator = generator;
    }
/**
     * Creates a reservation for the given room and guest.
     * <p>
     * Steps:
     * <ul>
     *     <li>Load the room entity from the database.</li>
     *     <li>Convert it to the domain {@link Room}.</li>
     *     <li>Use the domain logic to reserve the room.</li>
     *     <li>Store the new {@link Reservation} and update the room availability.</li>
     * </ul>
     *
     * @param roomNumber the number of the room to reserve
     * @param guestName  name of the guest who makes the reservation
     * @throws IllegalStateException if the room does not exist
     *                               or if the room is not available
     */
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

 /**
     * Cancels a reservation by its identifier.
     * <p>
     * If the reservation does not exist, an {@link IllegalStateException} is thrown.
     *
     * @param reservationId identifier of the reservation to cancel
     * @throws IllegalStateException if the reservation does not exist
     */
    public void cancel(Long reservationId) {

        if (!reservationRepository.existsById(reservationId)) {
            throw new IllegalStateException("Reservation " + reservationId + " does not exist");
        }


        reservationRepository.deleteById(reservationId);
    }


}
