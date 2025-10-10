package com.emse.tb3pwme.labs.hotel.reservation.web;

import com.emse.tb3pwme.labs.hotel.reservation.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/reserve")
    public ResponseEntity<String> reserveRoom(@RequestParam Integer roomNumber, @RequestParam String guestName) {
        try {
            reservationService.reserve(roomNumber, guestName);
        } catch (IllegalStateException isex) {
            return ResponseEntity.badRequest().body(isex.getMessage());
        }
        return ResponseEntity.ok("Room reserved successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelReservation(@PathVariable Long id) {
        try {
            reservationService.cancel(id);
            return ResponseEntity.ok("Reservation " + id + " cancelled successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}