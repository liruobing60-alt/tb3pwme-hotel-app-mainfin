package com.emse.tb3pwme.labs.hotel.reservation;

import com.emse.tb3pwme.labs.hotel.reservation.domain.Reservation;
import com.emse.tb3pwme.labs.hotel.reservation.domain.ReservationNumberGenerator;
import com.emse.tb3pwme.labs.hotel.reservation.domain.Room;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoomTest {

    @Test
    void shouldMakeReservation() {
        // given
        Room room = new Room(101, 2, true);


        ReservationNumberGenerator generator = new ReservationNumberGenerator() {
            @Override
            public Long getNextReservationNumber() {
                return 1001L;
            }
        };

        Reservation reservation = room.reserve(generator, "Alice");

        assertThat(reservation).isNotNull();
        assertThat(reservation.getGuestName()).isEqualTo("Alice");
        assertThat(reservation.getNumber()).isEqualTo(1001L);
        assertThat(reservation.getRoom()).isEqualTo(room);
        assertThat(room.isAvailable()).isFalse();
    }

    @Test
    void shouldFailToReserveRoom() {

        Room room = new Room(102, 1, false);

        ReservationNumberGenerator generator = new ReservationNumberGenerator() {
            @Override
            public Long getNextReservationNumber() {
                return 1002L;
            }
        };

        assertThatThrownBy(() -> room.reserve(generator, "Bob"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("unavailable");
    }
}
