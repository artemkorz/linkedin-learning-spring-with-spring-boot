package com.artemkorzanov.lil.learningspring.data.repository;

import com.artemkorzanov.lil.learningspring.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {
}
