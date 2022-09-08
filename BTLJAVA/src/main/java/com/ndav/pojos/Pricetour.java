/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "pricetour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pricetour.findAll", query = "SELECT p FROM Pricetour p"),
    @NamedQuery(name = "Pricetour.findById", query = "SELECT p FROM Pricetour p WHERE p.id = :id"),
    @NamedQuery(name = "Pricetour.findByPrice", query = "SELECT p FROM Pricetour p WHERE p.price = :price")})
public class Pricetour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @JoinColumn(name = "tourid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tour tourid;
    @JoinColumn(name = "customerid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Typecustomer customerid;

    public Pricetour() {
    }

    public Pricetour(Long id) {
        this.id = id;
    }

    public Pricetour(Long id, int price) {
        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Tour getTourid() {
        return tourid;
    }

    public void setTourid(Tour tourid) {
        this.tourid = tourid;
    }

    public Typecustomer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Typecustomer customerid) {
        this.customerid = customerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pricetour)) {
            return false;
        }
        Pricetour other = (Pricetour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndav.pojos.Pricetour[ id=" + id + " ]";
    }
    
}
