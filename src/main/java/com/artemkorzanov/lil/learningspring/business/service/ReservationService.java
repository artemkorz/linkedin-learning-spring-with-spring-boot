package com.artemkorzanov.lil.learningspring.business.service;

import com.artemkorzanov.lil.learningspring.business.domain.RoomReservation;
import com.artemkorzanov.lil.learningspring.data.repository.GuestRepository;
import com.artemkorzanov.lil.learningspring.data.repository.ReservationRepository;
import com.artemkorzanov.lil.learningspring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(Date date) {
        return null;
    }
}
