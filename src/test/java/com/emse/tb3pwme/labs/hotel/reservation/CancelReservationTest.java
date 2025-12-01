package com.emse.tb3pwme.labs.hotel.reservation;

import com.emse.tb3pwme.labs.hotel.reservation.persistence.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

class CancelReservationTest {

    private static final Logger log = LoggerFactory.getLogger(CancelReservationTest.class);

    @Test
    void shouldCancelReservationById_WhenExists() {
        log.info("Starting test: should cancel reservation when it exists");

        ReservationRepository mockRepo = mock(ReservationRepository.class);
        when(mockRepo.existsById(1L)).thenReturn(true);

        ReservationService service = new ReservationService(null, mockRepo, null);

        log.debug("Calling cancel(1L) - expecting successful deletion");
        service.cancel(1L);

        verify(mockRepo, times(1)).deleteById(1L);
        log.info("Reservation 1 successfully cancelled in test");
    }

    @Test
    void shouldThrowException_WhenReservationDoesNotExist() {
        log.info("Starting test: should throw exception when reservation does not exist");

        ReservationRepository mockRepo = mock(ReservationRepository.class);
        when(mockRepo.existsById(99L)).thenReturn(false);

        ReservationService service = new ReservationService(null, mockRepo, null);

        log.debug("Calling cancel(99L) - expecting IllegalStateException");
        assertThatThrownBy(() -> service.cancel(99L))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Reservation 99 does not exist");

        log.warn("Expected exception thrown for reservation 99");

        verify(mockRepo, never()).deleteById(anyLong());
        log.info("Deletion correctly not performed for reservation 99");
    }
}
