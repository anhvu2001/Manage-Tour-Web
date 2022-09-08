/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.service.imlp;

import com.ndav.pojos.Typetour;
import com.ndav.repository.TypetourRepository;
import com.ndav.service.TypetourService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class TypetourServiceImlp implements TypetourService {
    @Autowired
    private TypetourRepository typetourRepository;

    @Override
    public List<Typetour> getTypetours() {
        return this.typetourRepository.getTypetour();
    }

}
