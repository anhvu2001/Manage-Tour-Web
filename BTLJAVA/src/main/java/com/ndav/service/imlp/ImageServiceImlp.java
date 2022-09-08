/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.service.imlp;

import com.ndav.pojos.Image;
import com.ndav.repository.ImageRepository;
import com.ndav.service.ImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ImageServiceImlp implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

   

    @Override
    public Image getImageById(long id) {
        return this.imageRepository.getImageById(id);
    }

    @Override
    public List<Image> getListImage(long id) {
         return this.imageRepository.getListImage(id);
    }
    
    

    
}
