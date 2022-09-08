/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "tour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tour.findAll", query = "SELECT t FROM Tour t"),
    @NamedQuery(name = "Tour.findById", query = "SELECT t FROM Tour t WHERE t.id = :id"),
    @NamedQuery(name = "Tour.findByName", query = "SELECT t FROM Tour t WHERE t.name = :name"),
    @NamedQuery(name = "Tour.findByDaystart", query = "SELECT t FROM Tour t WHERE t.daystart = :daystart"),
    @NamedQuery(name = "Tour.findByNumbersofday", query = "SELECT t FROM Tour t WHERE t.numbersofday = :numbersofday"),
    @NamedQuery(name = "Tour.findByIamge", query = "SELECT t FROM Tour t WHERE t.iamge = :iamge")})
public class Tour implements Serializable {

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull(message="{tour.name.nullErr}")
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "daystart")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy" , timezone = "VST")
    private Date daystart;
    @Column(name = "numbersofday")
    private Integer numbersofday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "iamge")
    private String iamge;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourid")
    @JsonIgnore
    private Set<Image> imageSet;
    @OneToMany(mappedBy = "tourid")
    @JsonIgnore
    private Set<Booktour> booktourSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourid")
    @JsonIgnore
    private Set<Comment> commentSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourid")
    @JsonIgnore
    private Set<Pricetour> pricetourSet;
    @JoinColumn(name = "typeid_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Typetour typeidId;

    @Transient
    private MultipartFile file;

    public Tour() {
    }

    public Tour(Long id) {
        this.id = id;
    }

    public Tour(Long id, String name, String iamge) {
        this.id = id;
        this.name = name;
        this.iamge = iamge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDaystart() {
        return daystart;
    }

    public void setDaystart(Date daystart) {
        this.daystart = daystart;
    }

    public Integer getNumbersofday() {
        return numbersofday;
    }

    public void setNumbersofday(Integer numbersofday) {
        this.numbersofday = numbersofday;
    }

    public String getIamge() {
        return iamge;
    }

    public void setIamge(String iamge) {
        this.iamge = iamge;
    }

    @XmlTransient
    public Set<Image> getImageSet() {
        return imageSet;
    }

    public void setImageSet(Set<Image> imageSet) {
        this.imageSet = imageSet;
    }

    @XmlTransient
    public Set<Booktour> getBooktourSet() {
        return booktourSet;
    }

    public void setBooktourSet(Set<Booktour> booktourSet) {
        this.booktourSet = booktourSet;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    @XmlTransient
    public Set<Pricetour> getPricetourSet() {
        return pricetourSet;
    }

    public void setPricetourSet(Set<Pricetour> pricetourSet) {
        this.pricetourSet = pricetourSet;
    }

    public Typetour getTypeidId() {
        return typeidId;
    }

    public void setTypeidId(Typetour typeidId) {
        this.typeidId = typeidId;
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
        if (!(object instanceof Tour)) {
            return false;
        }
        Tour other = (Tour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndav.pojos.Tour[ id=" + id + " ]";
    }

}
