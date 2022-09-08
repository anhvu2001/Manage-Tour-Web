/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.service.imlp;

import com.ndav.repository.StatsRepository;
import com.ndav.service.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class StatsServiceImlp implements StatsService {
    @Autowired
    private StatsRepository statsRepository;
    
    @Override
    public List<Object[]> countTour() {
        return this.statsRepository.countTour();
    }
    
}
