/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.ndav.pojos.Pricetour;
import com.ndav.service.TourService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api")
public class ApiPricetourController {
    @Autowired
    private TourService tourService;
    
   
    @GetMapping("/tours/{tourId}/prices")
    public ResponseEntity<List<Pricetour>> getComments(@PathVariable(value = "tourId") long id) {
        
        return new ResponseEntity<>(this.tourService.getPrice(id), HttpStatus.OK);
    }
}
