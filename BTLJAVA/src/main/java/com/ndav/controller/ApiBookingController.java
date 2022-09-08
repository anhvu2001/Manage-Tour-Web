/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.ndav.pojos.Booktour;
import com.ndav.pojos.User;
import com.ndav.service.BookingTourService;
import com.ndav.service.UserService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api")
public class ApiBookingController {
    @Autowired
    private BookingTourService bookingTourService;
     @Autowired
    private UserService userService;
    @GetMapping("/bookingtour")
    public ResponseEntity<List<Booktour>> getComments(Principal principal) {
        User user = this.userService.getUserByUsername(principal.getName());
        long ma = user.getId();
        return new ResponseEntity<>(this.bookingTourService.getbooktourByUser(ma), HttpStatus.OK);
    }
}
