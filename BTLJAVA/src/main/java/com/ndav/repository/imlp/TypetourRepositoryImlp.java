/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.repository.imlp;

import com.ndav.pojos.Typetour;
import com.ndav.repository.TypetourRepository;
import java.util.List;
import javax.persistence.Query;
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
public class TypetourRepositoryImlp implements TypetourRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Typetour> getTypetour() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Typetour");
        return q.getResultList();
    }

}
