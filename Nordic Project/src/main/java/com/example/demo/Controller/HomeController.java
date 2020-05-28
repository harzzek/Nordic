package com.example.demo.Controller;

import com.example.demo.Model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Controller
public class HomeController {

    Customers customers = new Customers();
    Bookings bookings = new Bookings();
    Motorhomes motorhomes = new Motorhomes();
    Customer customer;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bookings", bookings.readAll());
        return "index";
    }
    //testLOL213

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
        String type = request.getParameter("type");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String size = request.getParameter("size");
        int realSize = Integer.parseInt(size);
        String status = request.getParameter("status");
        motorhomes.create(type, brand, model, realSize, status);
        return "redirect:/showmotorhome";
    }
    @GetMapping("/showmotorhome")
    public String showmotorhome(Model model)
    {
        model.addAttribute("motorhomes", motorhomes.readAll());
        return "showmotorhome";
    }

    @GetMapping("/verify")
    public String verify(Model model)
    {
        model.addAttribute("customer", new Customer());
        return "verify";
    }

    @PostMapping("/verify")
    public String verify(@ModelAttribute("customer") Customer customer, Model model)
    {
        int phoneNr = customer.getCustomerPhone();
        if(customers.read(phoneNr) != null)
        {
            this.customer = customers.read(phoneNr);
            model.addAttribute("customer", customer);
            return "redirect:/create";
        } else
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Booking booking = new Booking();
        booking.setCustomerPhone(customer.getCustomerPhone());
        model.addAttribute("booking", booking);
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("booking") Booking booking, HttpServletRequest request)
    {
        bookings.create(booking);
        return "redirect:/";
    }

    @GetMapping("/deletemotorhome")
    public String deletemotorhome(@RequestParam("id") int id) {
        motorhomes.delete(id);
        return "redirect:/showmotorhome";
    }

//    @PostMapping("/deletemotorhome")
//    public String deletemotorhome(HttpServletRequest request)
//    {
//        String id = request.getParameter("idMotorhome");
//        motorhomes.delete(Integer.parseInt(id));
//        return "redirect:/showmotorhome";
//    }


}