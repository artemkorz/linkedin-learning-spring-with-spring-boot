package com.artemkorzanov.lil.learningspring.data.repository;

import com.artemkorzanov.lil.learningspring.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findReservationByReservationDate(Date date);
}
