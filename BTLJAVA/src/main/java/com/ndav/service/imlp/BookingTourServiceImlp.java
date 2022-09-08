/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.service.imlp;

import com.ndav.pojos.Booktour;
import com.ndav.repository.BookingTourRepository;
import com.ndav.service.BookingTourService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class BookingTourServiceImlp implements BookingTourService {

    @Autowired
    private BookingTourRepository bookingTourRepository;

    @Override
    public List<Booktour> getbooktourByUser(long userId) {
        return bookingTourRepository.getbooktourByUser(userId);
    }

}
