/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.ndav.pojos.Booktour;
import com.ndav.pojos.Pricetour;
import com.ndav.pojos.Tour;
import com.ndav.pojos.User;
import com.ndav.service.ImageService;
import com.ndav.service.TourService;
import com.ndav.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:messages.properties")
public class TourController {

    @Autowired
    private UserService userService;

    @Autowired
    private TourService tourService;

    @Autowired
    private ImageService imageService;

    @GetMapping("/tour/{tourId}")
    public String detail(Model model, @PathVariable(value = "tourId") long tourId, @PathVariable(value = "tourId") long iamgeIdtour) {
        model.addAttribute("tour", this.tourService.getTourById(tourId));
        model.addAttribute("imageid", this.imageService.getImageById(tourId));
        model.addAttribute("name", "welcome" + iamgeIdtour);
        model.addAttribute("image", this.imageService.getListImage(iamgeIdtour));
        model.addAttribute("booktour", new Booktour());
        return "tourDetail";
    }

    @PostMapping("/tour/{tourId}")
    public String addbooktour(Model model, @ModelAttribute(value = "booktour") Booktour booktour,
            @PathVariable(value = "tourId") long tourid,
            Principal principal,
            BindingResult rs) {
        User user = this.userService.getUserByUsername(principal.getName());
        Tour tour = this.tourService.getTourById(tourid);
        booktour.setUserid(user);
        booktour.setTourid(tour);
        if (rs.hasErrors()) {
            return "tourDetail";
        }
        if (this.tourService.addBookTour(booktour) == true) {
            return "redirect:/pay";
        }

        return "tourDetail";
    }
}
