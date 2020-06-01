package com.example.demo.Controller;

import com.example.demo.Model.Customers.Customer;
import com.example.demo.Model.Customers.CustomerHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    CustomerHandler customerHandler = new CustomerHandler();

    @GetMapping("/customertemp/show-customer")
    public String showcustomer(Model model) {
        model.addAttribute("customers", customerHandler.readAll());
        return "/customertemp/show-customer";
    }

    @GetMapping("/customertemp/create-customer")
    public String createCustomer(Model model) {
        model.addAttribute("customers", new Customer());
        return "/customertemp/create-customer";
    }

    @PostMapping("/customertemp/create-customer")
    public String createCustomer(@ModelAttribute("customers") Customer customer) {
        customerHandler.create(customer);
        return "redirect:/customertemp/show-customer";
    }
}
