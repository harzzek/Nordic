package com.example.demo.Controller;

import com.example.demo.Model.Bookings;
import com.example.demo.Model.Customers;
import com.example.demo.Model.Motorhomes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    Customers customers = new Customers();
    Bookings bookings = new Bookings();
    Motorhomes motorhomes = new Motorhomes();

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("bookings", bookings.readAll());
        return "index";
    }

    @GetMapping("/booking")
    public String booking()
    {
        return "booking";
    }

    @GetMapping("/cancel")
    public String cancel() { return "cancel"; }

    @GetMapping("/about")
    public String about()
    {
        return "about";
    }

    @GetMapping("/create")
    public String create()
    {
        return "create";
    }
    //test
    @GetMapping("/cc")
    public String cc(Model model) {
        model.addAttribute("customers", new Customers().create());
        return "cc";
    }
    @PostMapping("/cc")
    public String create(HttpServletRequest request)  {
        String fName = request.getParameter("customerFname");
        String lName = request.getParameter("customerLname");
        String phoneNr = request.getParameter("customerPhone");
        int realPhoneNr = Integer.parseInt(phoneNr);
        String email = request.getParameter("customerEmail");
        customers.create(realPhoneNr, fName, lName, email);
        return "redirect:/";
    }

}