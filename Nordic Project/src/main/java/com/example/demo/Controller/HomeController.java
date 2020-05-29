package com.example.demo.Controller;

import com.example.demo.Model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    CustomerHandler customerHandler = new CustomerHandler();
    BookingHandler bookingHandler = new BookingHandler();
    MotorhomeHandler motorhomeHandler = new MotorhomeHandler();
    Customer customer;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bookings", bookingHandler.readAll());
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

    @GetMapping("/show-customer")
    public String showcustomer(Model model) {
        model.addAttribute("customers", customerHandler.readAll());
        return "show-customer";
    }

    @GetMapping("/create-customer")
    public String cc(Model model) {
        model.addAttribute("customers", new Customer());
        return "create-customer";
    }

    @PostMapping("/create-customer")
    public String create(HttpServletRequest request) {
        String fName = request.getParameter("customerFname");
        String lName = request.getParameter("customerLname");
        String phoneNr = request.getParameter("customerPhone");
        int realPhoneNr = Integer.parseInt(phoneNr);
        String email = request.getParameter("customerEmail");
        customerHandler.create(realPhoneNr, fName, lName, email);
        return "redirect:/show-customer";
    }

    @GetMapping("/create-motorhome")
    public String createMotorhome(Model model) {
        model.addAttribute("motorhome", new Motorhome());
        return "create-motorhome";
    }

    @PostMapping("/create-motorhome")
    public String createMotorhome(HttpServletRequest request) {
        String type = request.getParameter("type");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String size = request.getParameter("size");
        int realSize = Integer.parseInt(size);
        String status = request.getParameter("status");
        motorhomeHandler.create(type, brand, model, realSize, status);
        return "redirect:/show-motorhome";
    }
    @GetMapping("/show-motorhome")
    public String showmotorhome(Model model)
    {
        model.addAttribute("motorhomes", motorhomeHandler.readAll());
        return "show-motorhome";
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
        if(customerHandler.read(phoneNr) != null)
        {
            this.customer = customerHandler.read(phoneNr);
            model.addAttribute("customer", customer);
            return "redirect:/create-booking";
        } else
        return "redirect:/";
    }

    @GetMapping("/create-booking")
    public String create(Model model) {
        Booking booking = new Booking();
        booking.setCustomerPhone(customer.getCustomerPhone());
        model.addAttribute("booking", booking);
        return "create-booking";
    }

    @PostMapping("/create-booking")
    public String create(@ModelAttribute("booking") Booking booking, HttpServletRequest request)
    {
        bookingHandler.create(booking);
        return "redirect:/";
    }

    @GetMapping("/deletemotorhome")
    public String deletemotorhome(@RequestParam("id") int id) {
        motorhomeHandler.delete(id);
        return "redirect:/show-motorhome";
    }

//    @PostMapping("/deletemotorhome")
//    public String deletemotorhome(HttpServletRequest request)
//    {
//        String id = request.getParameter("idMotorhome");
//        motorhomeHandler.delete(Integer.parseInt(id));
//        return "redirect:/showmotorhome";
//    }


}