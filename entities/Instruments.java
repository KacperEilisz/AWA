/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jsfcourse.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author kacper
 */
@Entity
@Table(name = "instruments")
@NamedQueries({
    @NamedQuery(name = "Instruments.findAll", query = "SELECT i FROM Instruments i"),
    @NamedQuery(name = "Instruments.findById", query = "SELECT i FROM Instruments i WHERE i.id = :id"),
    @NamedQuery(name = "Instruments.findByName", query = "SELECT i FROM Instruments i WHERE i.name = :name"),
    @NamedQuery(name = "Instruments.findByImagePath", query = "SELECT i FROM Instruments i WHERE i.imagePath = :imagePath"),
    @NamedQuery(name = "Instruments.findByPrice", query = "SELECT i FROM Instruments i WHERE i.price = :price"),
    @NamedQuery(name = "Instruments.findByInstrumentType", query = "SELECT i FROM Instruments i WHERE i.instrumentType = :instrumentType"),
    @NamedQuery(name = "Instruments.findByAddedAt", query = "SELECT i FROM Instruments i WHERE i.addedAt = :addedAt"),
    @NamedQuery(name = "Instruments.findByAddedBy", query = "SELECT i FROM Instruments i WHERE i.addedBy = :addedBy")})
public class Instruments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "image_path")
    private String imagePath;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "instrumentType")
    private String instrumentType;
    @Column(name = "addedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedAt;
    @Column(name = "addedBy")
    private Integer addedBy;

    public Instruments() {
    }

    public Instruments(Long id) {
        this.id = id;
    }

    public Instruments(Long id, String name, String imagePath, double price, String instrumentType) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
        this.instrumentType = instrumentType;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    public Integer getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Integer addedBy) {
        this.addedBy = addedBy;
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
        if (!(object instanceof Instruments)) {
            return false;
        }
        Instruments other = (Instruments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsfcourse.entities.Instruments[ id=" + id + " ]";
    }
    
}
