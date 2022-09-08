/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.ndav.pojos.Comment;
import com.ndav.pojos.Commentnews;
import com.ndav.service.NewsService;
import com.ndav.service.TourService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api")
public class ApiCommentController {
    @Autowired
    private TourService tourService;
    
    @Autowired
    private NewsService newsService;
    
    @GetMapping("/tours/{tourId}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable(value = "tourId") long id) {
        
        return new ResponseEntity<>(this.tourService.getComments(id), HttpStatus.OK);
    }
    
    
    
     @PostMapping(path = "/tours/{tourId}/comments", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params, @PathVariable(value = "tourId") long id) {
        String content = params.get("content");
        
        Comment c = this.tourService.addCommentTour(content, id);
        
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
    
    
    @GetMapping("/news/{newsId}/comments")
    public ResponseEntity<List<Commentnews>> getCommentnews(@PathVariable(value = "newsId") long id) {
        
        return new ResponseEntity<>(this.newsService.getCommentnews(id), HttpStatus.OK);
    }
    
    
    @PostMapping(path = "/news/{newsId}/comments", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Commentnews> addCommentNews(@RequestBody Map<String, String> params, @PathVariable(value = "newsId") long id) {
        String content = params.get("content");
        
        Commentnews c = this.newsService.addComment(content, id);
        
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
    
}
