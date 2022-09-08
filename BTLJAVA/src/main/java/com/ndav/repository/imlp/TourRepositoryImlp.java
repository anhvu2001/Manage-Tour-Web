/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.repository.imlp;

import com.ndav.pojos.Booktour;
import com.ndav.pojos.Comment;
import com.ndav.pojos.Pricetour;
import com.ndav.pojos.Tour;
import com.ndav.pojos.User;
import com.ndav.repository.TourRepository;
import com.ndav.repository.UserRepository;
import com.ndav.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
@PropertySource("classpath:messages.properties")
@Transactional
public class TourRepositoryImlp implements TourRepository {

    @Autowired
    private UserService userService;

    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Tour> getTours(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Tour> q = b.createQuery(Tour.class);
        Root root = q.from(Tour.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }

            String typetourid = params.get("typetourid");
            if (typetourid != null) {
                Predicate p = b.equal(root.get("typeidId"), Integer.parseInt(typetourid));
                predicates.add(p);
            }

            q.where(predicates.toArray(new Predicate[]{}));

        }

        q.orderBy(b.desc(root.get("id")), b.desc(root.get("name")));

        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public int countTour() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = session.createQuery("SELECT Count(*) FROM Tour");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public Tour getTourById(long id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Tour.class, id);
    }

    @Override
    public boolean deleteTour(long id) {
        {
            Session session = this.sessionFactory.getObject().getCurrentSession();

            try {
                Tour t = session.get(Tour.class, id);
                session.delete(t);
                return true;

            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }

        }
    }

    @Override
    public boolean addOrUpdate(Tour tour) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(tour);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Comment> getComments(long tourId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Comment> q = b.createQuery(Comment.class);
        Root root = q.from(Comment.class);
        q.select(root);

        q.where(b.equal(root.get("tourid"), tourId));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Comment addCommentTour(String content, long tourId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Comment c = new Comment();
        c.setContent(content);
        c.setTourid(this.getTourById(tourId));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = this.userService.getUserByUsername(authentication.getName());
        c.setUserid(this.userRepository.getUserByUsername(authentication.getName()));
//        c.setUserid(user);
        session.save(c);

        return c;
    }

    @Override
    public List<Pricetour> getPrice(long tourId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Pricetour> q = b.createQuery(Pricetour.class);
        Root root = q.from(Pricetour.class);
        q.select(root);

        q.where(b.equal(root.get("tourid"), tourId));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean addBookTour(Booktour booktour) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(booktour);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
}
