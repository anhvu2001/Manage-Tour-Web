/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndav.repository;

import com.ndav.pojos.Booktour;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface BookingTourRepository {
      List<Booktour> getbooktourByUser(long userId);
}
