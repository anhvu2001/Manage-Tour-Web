/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.ndav.repository.NewsRepository;
import com.ndav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
@ControllerAdvice
public class NewsController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private NewsRepository newsRepository;

    @RequestMapping("/news")
    public String tintuc(Model model) {
        String username = "admin14";
        model.addAttribute("userinfo",this.userService.getUserByUsername(username));
        model.addAttribute("listnews", this.newsRepository.getListNews());
        return "news";
    }
    
    
    @GetMapping("/news/{newsId}")
    public String chitiettintuc(Model model, @PathVariable(value = "newsId") long newsId){
        model.addAttribute("detailnews",this.newsRepository.getNewsById(newsId));
        return "newsDetail";
    }
}
