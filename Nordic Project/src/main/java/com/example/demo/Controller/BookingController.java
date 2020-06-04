package com.example.demo.Controller;

import com.example.demo.Model.Bookings.Booking;
import com.example.demo.Model.Bookings.BookingHandler;
import com.example.demo.Model.Customers.Customer;
import com.example.demo.Model.Customers.CustomerHandler;
import com.example.demo.Model.Motorhomes.Motorhome;
import com.example.demo.Model.Motorhomes.MotorhomeHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//Kodet af Hans Christian

@Controller
public class BookingController {

    BookingHandler bookingHandler = new BookingHandler();
    MotorhomeHandler motorhomeHandler = new MotorhomeHandler();
    CustomerHandler customerHandler = new CustomerHandler();
    Customer customer;
    Booking booking;

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

    @GetMapping("/bookingtemp/verify")
    public String verify(Model model)
    {
        model.addAttribute("customer", new Customer());
        return "/bookingtemp/verify";
    }

    @PostMapping("/bookingtemp/verify")
    public String verify(@ModelAttribute("customer") Customer customer, Model model)
    {
        int phoneNr = customer.getCustomerPhone();
        if(customerHandler.read(phoneNr) != null)
        {
            this.customer = customerHandler.read(phoneNr);
            model.addAttribute("customer", customer);
            return "redirect:/bookingtemp/create-booking";
        } else
            return "redirect:/customertemp/create-customer";
    }

    @GetMapping("/bookingtemp/create-booking")
    public String create(Model model) {
        Booking booking = new Booking();
        booking.setCustomerPhone(customer.getCustomerPhone());
        model.addAttribute("booking", booking);
        return "/bookingtemp/create-booking";
    }

    @PostMapping("/bookingtemp/create-booking")
    public String create(@ModelAttribute("booking") Booking booking)
    {
        this.booking = booking;
        return "redirect:/bookingtemp/availablemotorhomes";
    }

    @GetMapping("/bookingtemp/availablemotorhomes")
    public String availableMotorhomes(Model model)
    {
        if( motorhomeHandler.findAvailable(booking) != null)
        {
            model.addAttribute("motorhomes", motorhomeHandler.findAvailable(booking));
            model.addAttribute("motorhome", new Motorhome());
            return "/bookingtemp/availablemotorhomes";
        } else
            return "/bookingtemp/create-booking";

    }

    @PostMapping("/bookingtemp/availablemotorhomes")
    public String availableMotorhomes(@ModelAttribute("motorhome") Motorhome motorhome)
    {
        booking.setIdMotorhome(motorhome.getIdMotorhome());
        Booking booking1 = booking;
        bookingHandler.create(booking1);
        return "redirect:/";
    }


}
