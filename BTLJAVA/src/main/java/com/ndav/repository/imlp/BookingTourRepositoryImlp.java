/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.repository.imlp;

import com.ndav.pojos.Booktour;
import com.ndav.repository.BookingTourRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@PropertySource("classpath:messages.properties")
@Transactional
public class BookingTourRepositoryImlp implements BookingTourRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Booktour> getbooktourByUser(long userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Booktour> q = b.createQuery(Booktour.class);
        Root root = q.from(Booktour.class);
        q.select(root);

        q.where(b.equal(root.get("userid"), userId));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

}
