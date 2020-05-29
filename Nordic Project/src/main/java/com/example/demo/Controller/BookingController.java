package com.example.demo.Controller;

import com.example.demo.Model.Bookings.Booking;
import com.example.demo.Model.Bookings.BookingHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookingController {

    BookingHandler bookingHandler = new BookingHandler();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bookings", bookingHandler.readAll());
        return "index";
    }

    @GetMapping("/cancel")
    public String cancel() {
        return "cancel";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @PostMapping("/bookingtemp/create-booking")
    public String create(@ModelAttribute("booking") Booking booking)
    {
        bookingHandler.create(booking);
        return "redirect:/";
    }


}
