package com.example.demo.Controller;

import com.example.demo.Model.Motorhomes.Motorhome;
import com.example.demo.Model.Motorhomes.MotorhomeHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

//Kodet af Emil

@Controller
public class MotorhomeController {

    MotorhomeHandler motorhomeHandler = new MotorhomeHandler();

    @GetMapping("/motorhometemp/create-motorhome")
    public String createMotorhome(Model model) {
        model.addAttribute("motorhome", new Motorhome());
        return "/motorhometemp/create-motorhome";
    }

    @PostMapping("/motorhometemp/create-motorhome")
    public String createMotorhome(@ModelAttribute("motorhome") Motorhome motorhome) {
        motorhomeHandler.create(motorhome);
        return "redirect:/motorhometemp/show-motorhome";
    }
    @GetMapping("/motorhometemp/show-motorhome")
    public String showmotorhome(Model model)
    {
        model.addAttribute("motorhomes", motorhomeHandler.readAll());
        return "/motorhometemp/show-motorhome";
    }


    @GetMapping("/motorhometemp/deletemotorhome")
    public String deletemotorhome(Model model, @RequestParam("id") int id) {
       model.addAttribute("motorhome", motorhomeHandler.read(id));
        //motorhomeHandler.delete(id);
        return "/motorhometemp/deletemotorhome";
    }

    @PostMapping("/motorhometemp/deletemotorhome")
    public String deletemotorhome(@ModelAttribute("motorhome")Motorhome motorhome)
    {
        motorhomeHandler.delete(motorhome.getIdMotorhome());
        return "redirect:/motorhometemp/show-motorhome";
    }
}
