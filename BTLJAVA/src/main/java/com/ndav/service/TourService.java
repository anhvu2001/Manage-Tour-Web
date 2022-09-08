/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndav.service;

import com.ndav.pojos.Booktour;
import com.ndav.pojos.Comment;
import com.ndav.pojos.Pricetour;
import com.ndav.pojos.Tour;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface TourService {

    List<Tour> getTours(Map<String, String> params, int page);

    int countTour();

    boolean addOrUpdate(Tour tour);

    Tour getTourById(long id);

    boolean deleteTour(long id);

    List<Comment> getComments(long tourId);

    Comment addCommentTour(String content, long tourId);

    List<Pricetour> getPrice(long tourId);

    boolean addBookTour(Booktour booktour);

}
