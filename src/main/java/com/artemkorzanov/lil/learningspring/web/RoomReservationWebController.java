package com.artemkorzanov.lil.learningspring.web;

import com.artemkorzanov.lil.learningspring.business.domain.RoomReservation;
import com.artemkorzanov.lil.learningspring.business.service.ReservationService;
import com.artemkorzanov.lil.learningspring.data.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationWebController {
    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public  String gerReservations(@RequestParam(value = "date", required = false) String dateString, Model model) {
        Date date = DateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservations);
        return "reservations";
    }
}
