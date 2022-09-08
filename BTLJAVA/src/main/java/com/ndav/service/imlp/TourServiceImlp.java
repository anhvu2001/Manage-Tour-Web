/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.service.imlp;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndav.pojos.Booktour;
import com.ndav.pojos.Comment;
import com.ndav.pojos.Pricetour;
import com.ndav.pojos.Tour;
import com.ndav.repository.TourRepository;
import com.ndav.service.TourService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class TourServiceImlp implements TourService {
    
    @Autowired
    private Cloudinary cloudinary;
    
    @Autowired
    private TourRepository tourRepository;
    
    @Override
    public List<Tour> getTours(Map<String, String> params, int page) {
        return this.tourRepository.getTours(params, page);
    }
    
    @Override
    public int countTour() {
        return this.tourRepository.countTour();
    }
    
    @Override
    public Tour getTourById(long id) {
        return this.tourRepository.getTourById(id);
    }
    
    @Override
    public boolean deleteTour(long id) {
        return this.tourRepository.deleteTour(id);
    }
    
    @Override
    public boolean addOrUpdate(Tour tour) {
        try {
            Map r = this.cloudinary.uploader().upload(tour.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            tour.setIamge((String) r.get("secure_url"));
            return this.tourRepository.addOrUpdate(tour);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    @Override
    public List<Comment> getComments(long tourId) {
        return this.tourRepository.getComments(tourId);
    }
    
    @Override
    public Comment addCommentTour(String content, long tourId) {
        return this.tourRepository.addCommentTour(content, tourId);
    }
    
    @Override
    public List<Pricetour> getPrice(long tourId) {
        return this.tourRepository.getPrice(tourId);
    }
    
    @Override
    public boolean addBookTour(Booktour booktour) {
        return this.tourRepository.addBookTour(booktour);
    }
    
}
