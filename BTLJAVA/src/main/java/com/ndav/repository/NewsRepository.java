/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndav.repository;

import com.ndav.pojos.Commentnews;
import com.ndav.pojos.News;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NewsRepository {
    List<News> getListNews();
    News getNewsById(long id);
    boolean deleteNews(long id);
    boolean addOrUpdateNews(News news);
    List<Commentnews> getCommentnews(long newsid);
    Commentnews addComment(String content, long newsid);
}
