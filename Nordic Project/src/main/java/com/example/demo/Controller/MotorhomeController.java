package com.example.demo.Controller;

import com.example.demo.Model.Motorhomes.Motorhome;
import com.example.demo.Model.Motorhomes.MotorhomeHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MotorhomeController {

    MotorhomeHandler motorhomeHandler = new MotorhomeHandler();

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


    @GetMapping("/deletemotorhome")
    public String deletemotorhome(@RequestParam("id") int id) {
        motorhomeHandler.delete(id);
        return "redirect:/show-motorhome";
    }
}
