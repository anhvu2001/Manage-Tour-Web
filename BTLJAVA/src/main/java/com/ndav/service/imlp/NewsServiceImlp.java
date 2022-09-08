/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.service.imlp;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndav.pojos.Commentnews;
import com.ndav.pojos.News;
import com.ndav.repository.NewsRepository;
import com.ndav.service.NewsService;
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
public class NewsServiceImlp implements NewsService {

    @Autowired
    private Cloudinary cloudinary;
    
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> getListNews() {
        return this.newsRepository.getListNews();
    }

    @Override
    public News getNewsById(long id) {
        return this.newsRepository.getNewsById(id);
    }

    @Override
    public boolean deleteNews(long id) {
        return this.newsRepository.deleteNews(id);
    }

    @Override
    public boolean addOrUpdateNews(News news) {
       try {
            Map r = this.cloudinary.uploader().upload(news.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            news.setImage((String) r.get("secure_url"));
            return this.newsRepository.addOrUpdateNews(news);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Commentnews> getCommentnews(long newsid) {
        return this.newsRepository.getCommentnews(newsid);
    }

    @Override
    public Commentnews addComment(String content, long newsid) {
        return this.newsRepository.addComment(content, newsid);
    }

}
