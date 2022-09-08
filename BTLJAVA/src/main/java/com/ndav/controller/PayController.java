/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.ndav.pojos.User;
import com.ndav.service.BookingTourService;
import com.ndav.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:messages.properties")
public class PayController {

    @Autowired
    private BookingTourService bookingTourService;
    @Autowired
    private UserService userService;

    @RequestMapping("/pay")
    public String pay(Model model, Principal principal) {
        User user = this.userService.getUserByUsername(principal.getName());
        long ma = user.getId();
        model.addAttribute("booktour", this.bookingTourService.getbooktourByUser(ma));
        return "pay";
    }
}
