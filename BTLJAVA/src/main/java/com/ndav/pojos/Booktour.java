/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.pojos;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "booktour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booktour.findAll", query = "SELECT b FROM Booktour b"),
    @NamedQuery(name = "Booktour.findById", query = "SELECT b FROM Booktour b WHERE b.id = :id"),
    @NamedQuery(name = "Booktour.findByNumberofadults", query = "SELECT b FROM Booktour b WHERE b.numberofadults = :numberofadults"),
    @NamedQuery(name = "Booktour.findByNumberofchildren", query = "SELECT b FROM Booktour b WHERE b.numberofchildren = :numberofchildren"),
    @NamedQuery(name = "Booktour.findByBookingdate", query = "SELECT b FROM Booktour b WHERE b.bookingdate = :bookingdate")})
public class Booktour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "numberofadults")
    private Integer numberofadults;
    @Column(name = "numberofchildren")
    private Integer numberofchildren;
    @Column(name = "bookingdate")
    @Temporal(TemporalType.DATE)
    private Date bookingdate = new Date();
    @JoinColumn(name = "tourid", referencedColumnName = "id")
    @ManyToOne
    private Tour tourid;
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne
    private User userid;

    public Booktour() {
    }

    public Booktour(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberofadults() {
        return numberofadults;
    }

    public void setNumberofadults(Integer numberofadults) {
        this.numberofadults = numberofadults;
    }

    public Integer getNumberofchildren() {
        return numberofchildren;
    }

    public void setNumberofchildren(Integer numberofchildren) {
        this.numberofchildren = numberofchildren;
    }

    public Date getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(Date bookingdate) {
        this.bookingdate = bookingdate;
    }

    public Tour getTourid() {
        return tourid;
    }

    public void setTourid(Tour tourid) {
        this.tourid = tourid;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
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
        if (!(object instanceof Booktour)) {
            return false;
        }
        Booktour other = (Booktour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndav.pojos.Booktour[ id=" + id + " ]";
    }
    
}
