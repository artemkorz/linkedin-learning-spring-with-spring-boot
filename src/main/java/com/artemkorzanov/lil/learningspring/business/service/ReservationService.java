package com.artemkorzanov.lil.learningspring.business.service;

import com.artemkorzanov.lil.learningspring.business.domain.RoomReservation;
import com.artemkorzanov.lil.learningspring.data.entity.Guest;
import com.artemkorzanov.lil.learningspring.data.entity.Reservation;
import com.artemkorzanov.lil.learningspring.data.entity.Room;
import com.artemkorzanov.lil.learningspring.data.repository.GuestRepository;
import com.artemkorzanov.lil.learningspring.data.repository.ReservationRepository;
import com.artemkorzanov.lil.learningspring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(), roomReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.findReservationByResDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestID());
        });
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id));
        }
        return roomReservations;
    }
    public List<Guest> getHotelGuests() {
        Iterable<Guest> guests = guestRepository.findAll();
        List<Guest> guestList = new ArrayList<>();
        guests.forEach(guest -> guestList.add(guest));
        guestList.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest g1, Guest g2) {
                if(g1.getLastName() == g2.getLastName()) {
                    return g1.getFirstName().compareTo(g2.getFirstName());
                }
                return g1.getLastName().compareTo(g2.getLastName());
            }
        });
        return guestList;
    }
}
