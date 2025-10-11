package com.emse.tb3pwme.labs.hotel.reservation;

import com.emse.tb3pwme.labs.hotel.reservation.persistence.ReservationRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

class CancelReservationTest {

    @Test
    void shouldCancelReservationById_WhenExists() {
        ReservationRepository mockRepo = mock(ReservationRepository.class);
        when(mockRepo.existsById(1L)).thenReturn(true);
        ReservationService service = new ReservationService(null, mockRepo, null);
        service.cancel(1L);
        verify(mockRepo, times(1)).deleteById(1L);
    }

    @Test
    void shouldThrowException_WhenReservationDoesNotExist() {
        ReservationRepository mockRepo = mock(ReservationRepository.class);
        when(mockRepo.existsById(99L)).thenReturn(false);
        ReservationService service = new ReservationService(null, mockRepo, null);
        assertThatThrownBy(() -> service.cancel(99L))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Reservation 99 does not exist");
        verify(mockRepo, never()).deleteById(anyLong());
    }
}
