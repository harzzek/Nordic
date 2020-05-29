package com.example.demo.Controller;

import com.example.demo.Model.Bookings.Booking;
import com.example.demo.Model.Customers.Customer;
import com.example.demo.Model.Customers.CustomerHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {

    CustomerHandler customerHandler = new CustomerHandler();
    Customer customer;

    @GetMapping("/customertemp/show-customer")
    public String showcustomer(Model model) {
        model.addAttribute("customers", customerHandler.readAll());
        return "/customertemp/show-customer";
    }

    @GetMapping("/customertemp/create-customer")
    public String cc(Model model) {
        model.addAttribute("customers", new Customer());
        return "/customertemp/create-customer";
    }

    @PostMapping("/customertemp/create-customer")
    public String create(HttpServletRequest request) {
        String fName = request.getParameter("customerFname");
        String lName = request.getParameter("customerLname");
        String phoneNr = request.getParameter("customerPhone");
        int realPhoneNr = Integer.parseInt(phoneNr);
        String email = request.getParameter("customerEmail");
        customerHandler.create(realPhoneNr, fName, lName, email);
        return "redirect:/customertemp/show-customer";
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
            return "redirect:/";
    }

    @GetMapping("/bookingtemp/create-booking")
    public String create(Model model) {
        Booking booking = new Booking();
        booking.setCustomerPhone(customer.getCustomerPhone());
        model.addAttribute("booking", booking);
        return "/bookingtemp/create-booking";
    }
}