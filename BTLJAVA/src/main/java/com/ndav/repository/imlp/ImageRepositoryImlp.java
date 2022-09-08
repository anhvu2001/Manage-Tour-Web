/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.repository.imlp;

import com.ndav.pojos.Image;
import com.ndav.repository.ImageRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class ImageRepositoryImlp implements ImageRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Image> getListImage(long id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Image> q = b.createQuery(Image.class);
        Root root = q.from(Image.class);
        q.select(root);
        q = q.where(b.equal(root.get("tourid"), id));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Image getImageById(long id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Image.class, id);
    }

}
