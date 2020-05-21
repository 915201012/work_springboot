package com.demo.springboot.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@Controller
public class LoginController {

    @RequestMapping("/toLoginPage")
    public String toLoginPage(Model model) {
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }

    @RequestMapping("/header")
    public String testHeader() {
        return "header";
    }

    @RequestMapping("/footer")
    public String testFooter() {
        return "footer";
    }
}
