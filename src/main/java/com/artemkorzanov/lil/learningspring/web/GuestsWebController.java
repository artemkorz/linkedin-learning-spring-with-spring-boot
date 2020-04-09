package com.artemkorzanov.lil.learningspring.web;

import com.artemkorzanov.lil.learningspring.business.service.ReservationService;
import com.artemkorzanov.lil.learningspring.data.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestsWebController {
    private final ReservationService reservationService;

    @Autowired
    public GuestsWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getGuests(Model model) {
        List<Guest> guestList = reservationService.getHotelGuests();
        model.addAttribute("hotelGuests", guestList);
        return "guests";
    }

}
