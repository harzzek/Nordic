package com.example.demo.Controller;

import com.example.demo.Model.Customers.Customer;
import com.example.demo.Model.Customers.CustomerHandler;
import com.example.demo.Model.Motorhomes.MotorhomeHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {

    CustomerHandler customerHandler = new CustomerHandler();
    Customer customer;
    MotorhomeHandler motorhomeHandler;

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
    public String createCustomer(HttpServletRequest request) {
        String fName = request.getParameter("customerFname");
        String lName = request.getParameter("customerLname");
        String phoneNr = request.getParameter("customerPhone");
        int realPhoneNr = Integer.parseInt(phoneNr);
        String email = request.getParameter("customerEmail");
        customerHandler.create(realPhoneNr, fName, lName, email);
        return "redirect:/customertemp/show-customer";
    }
}
