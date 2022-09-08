/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndav.pojos.News;
import com.ndav.pojos.Tour;
import com.ndav.service.NewsService;
import com.ndav.service.StatsService;
import com.ndav.service.TourService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
@PropertySource("classpath:messages.properties")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StatsService statsService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private TourService tourService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/tours")
    public String managetour(Model model) {
        model.addAttribute("tour", new Tour());
        return "adminTour";
    }

    @GetMapping("/news")
    public String managenews(Model model) {
        model.addAttribute("news", new News());
        return "adminNews";
    }

    @PostMapping("/tours")
    public String addTour(Model model, @ModelAttribute(value = "tour") Tour tour, BindingResult rs) {
        if (rs.hasErrors()) {
            return "";
        } else {
            if (this.tourService.addOrUpdate(tour) == true) {
                return "redirect:/";
            }

        }
        return "adminTour";
    }

    @PostMapping("/news")
    public String addNews(Model model, @ModelAttribute(value = "news") News news, BindingResult rs) {
        if (rs.hasErrors()) {
            return "adminNews";
        } else {
            if (this.newsService.addOrUpdateNews(news) == true) {
                return "redirect:/";
            }

        }
        return "adminNews";
    }

    @GetMapping("/stats")
    public String stats(Model model) {
        model.addAttribute("tourStats", this.statsService.countTour());
        return "stats";
    }
}
