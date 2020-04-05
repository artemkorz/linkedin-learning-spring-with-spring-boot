package com.artemkorzanov.lil.learningspring.data.repository;

import com.artemkorzanov.lil.learningspring.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findReservationByResDate(Date date);
}
