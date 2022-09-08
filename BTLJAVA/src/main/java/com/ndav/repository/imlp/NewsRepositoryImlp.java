/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.repository.imlp;

import com.ndav.pojos.Commentnews;
import com.ndav.pojos.News;
import com.ndav.repository.NewsRepository;
import com.ndav.repository.UserRepository;
import com.ndav.service.UserService;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class NewsRepositoryImlp implements NewsRepository {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<News> getListNews() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From News");
        return q.getResultList();
    }

    @Override
    public News getNewsById(long id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(News.class, id);
    }

    @Override
    public boolean deleteNews(long id) {
        {
            Session session = this.sessionFactory.getObject().getCurrentSession();

            try {
                News n = session.get(News.class, id);
                session.delete(n);
                return true;

            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }

        }
    }

    @Override
    public boolean addOrUpdateNews(News news) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.flush();
            session.save(news);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Commentnews> getCommentnews(long newsid) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Commentnews> q = b.createQuery(Commentnews.class);
        Root root = q.from(Commentnews.class);
        q.select(root);

        q.where(b.equal(root.get("newsid"), newsid));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Commentnews addComment(String content, long newsid) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Commentnews c = new Commentnews();
        c.setContent(content);
        c.setNewsid(this.getNewsById(newsid));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        c.setUserid(this.userRepository.getUserByUsername(authentication.getName()));

        session.save(c);

        return c;
    }
}
