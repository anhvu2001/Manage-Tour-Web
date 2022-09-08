/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.ndav.service.ImageService;
import javax.persistence.Query;
import com.ndav.service.TourService;
import com.ndav.service.TypetourService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:messages.properties")
public class HomeController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private Environment env;

    @Autowired
    private TourService tourService;

    @Autowired
    private TypetourService typetourService;

    @ModelAttribute
    public void commonAttr(Model model,HttpSession session) {
        model.addAttribute("listtypetour", this.typetourService.getTypetours());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
    }

    @RequestMapping("/")
    public String Home(Model model, @RequestParam Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("Countour", this.tourService.countTour());
        model.addAttribute("listtour", this.tourService.getTours(params, page));
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));

        return "index";
    }
   
    @RequestMapping("/hello/{name}")
    public String index1(Model model, @PathVariable(value="name") String name)
    {
        model.addAttribute("name", "welcome" + name);
        return "index";

    }
}
