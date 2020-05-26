package com.example.demo.Controller;

import com.example.demo.Model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class HomeController {

    Customers customers = new Customers();
    Bookings bookings = new Bookings();
    Motorhomes motorhomes = new Motorhomes();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bookings", bookings.readAll());
        return "index";
    }

    @GetMapping("/booking")
    public String booking() {
        return "booking";
    }

    @GetMapping("/cancel")
    public String cancel() {
        return "cancel";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/showcustomer")
    public String showcustomer(Model model) {
        model.addAttribute("customers", customers.readAll());
        return "showcustomer";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("booking", new Booking());
        return "create";
    }

    @PostMapping("/create")
    public String createBooking(HttpServletRequest request)
    {
        String bookingDate = request.getParameter("bookingDate");
        String split[] = bookingDate.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        LocalDate startDate = LocalDate.of(year, month, day);
        String bookingEndDate = request.getParameter("bookingEndDate");
        String split2[] = bookingEndDate.split("-");
        int year2 = Integer.parseInt(split2[0]);
        int month2 = Integer.parseInt(split2[1]);
        int day2 = Integer.parseInt(split2[2]);
        LocalDate endDate = LocalDate.of(year2, month2, day2);
        String pickup = request.getParameter("pickup");
        String dropoff = request.getParameter("dropoff");
        String phoneNr = request.getParameter("customerPhone");
        int realPhoneNr = Integer.parseInt(phoneNr);
        String idMotor = request.getParameter("IdMotorhome");
        int realIdMotor = Integer.parseInt(idMotor);
        bookings.create(startDate, endDate, pickup, dropoff, realPhoneNr, realIdMotor);
        return "redirect:/";

    }

    @GetMapping("/cc")
    public String cc(Model model) {
        model.addAttribute("customers", new Customer());
        return "cc";
    }

    @PostMapping("/cc")
    public String create(HttpServletRequest request) {
        String fName = request.getParameter("customerFname");
        String lName = request.getParameter("customerLname");
        String phoneNr = request.getParameter("customerPhone");
        int realPhoneNr = Integer.parseInt(phoneNr);
        String email = request.getParameter("customerEmail");
        customers.create(realPhoneNr, fName, lName, email);
        return "redirect:/showcustomer";
    }

    @GetMapping("/motorhome")
    public String createMotorhome(Model model) {
        model.addAttribute("motorhome", new Motorhome());
        return "motorhome";
    }

    @PostMapping("/motorhome")
    public String createMotorhome(HttpServletRequest request) {
        String type = request.getParameter("Type");
        String brand = request.getParameter("Brand");
        String model = request.getParameter("Model");
        String size = request.getParameter("Size");
        int realSize = Integer.parseInt(size);
        String status = request.getParameter("Status");
        motorhomes.create(type, brand, model, realSize, status);
        return "redirect:/";
    }
}