package com.emse.tb3pwme.labs.hotel.reservation;

import com.emse.tb3pwme.labs.hotel.reservation.persistence.ReservationRepository;
import com.emse.tb3pwme.labs.hotel.reservation.persistence.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ReservationIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    void shouldReserveRoom() throws Exception {
        mockMvc.perform(post("/api/reservations")
                        .param("roomNumber", "101")
                        .param("guestName", "John Doe"))
                .andExpect(status().isOk())
                .andExpect(content().string("Room reserved successfully"));
    }

}
