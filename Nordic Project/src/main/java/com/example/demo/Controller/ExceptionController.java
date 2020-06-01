package com.example.demo.Controller;

import com.example.demo.Model.ExceptionPackage.CustomerException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;

import java.util.Locale;

@Controller
public class ExceptionController {

//    @GetMapping("/error")
//    public String handleError(Exception ex)
//    {
//        return "error";
//    }
}
