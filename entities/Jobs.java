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
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author kacper
 */
@Entity
@Table(name = "jobs")
@NamedQueries({
    @NamedQuery(name = "Jobs.findAll", query = "SELECT j FROM Jobs j"),
    @NamedQuery(name = "Jobs.findById", query = "SELECT j FROM Jobs j WHERE j.id = :id"),
    @NamedQuery(name = "Jobs.findByQueue", query = "SELECT j FROM Jobs j WHERE j.queue = :queue"),
    @NamedQuery(name = "Jobs.findByAttempts", query = "SELECT j FROM Jobs j WHERE j.attempts = :attempts"),
    @NamedQuery(name = "Jobs.findByReservedAt", query = "SELECT j FROM Jobs j WHERE j.reservedAt = :reservedAt"),
    @NamedQuery(name = "Jobs.findByAvailableAt", query = "SELECT j FROM Jobs j WHERE j.availableAt = :availableAt"),
    @NamedQuery(name = "Jobs.findByCreatedAt", query = "SELECT j FROM Jobs j WHERE j.createdAt = :createdAt")})
public class Jobs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "queue")
    private String queue;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "payload")
    private String payload;
    @Basic(optional = false)
    @NotNull
    @Column(name = "attempts")
    private short attempts;
    @Column(name = "reserved_at")
    private Integer reservedAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "available_at")
    private int availableAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    private int createdAt;

    public Jobs() {
    }

    public Jobs(Long id) {
        this.id = id;
    }

    public Jobs(Long id, String queue, String payload, short attempts, int availableAt, int createdAt) {
        this.id = id;
        this.queue = queue;
        this.payload = payload;
        this.attempts = attempts;
        this.availableAt = availableAt;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public short getAttempts() {
        return attempts;
    }

    public void setAttempts(short attempts) {
        this.attempts = attempts;
    }

    public Integer getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(Integer reservedAt) {
        this.reservedAt = reservedAt;
    }

    public int getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(int availableAt) {
        this.availableAt = availableAt;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
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
        if (!(object instanceof Jobs)) {
            return false;
        }
        Jobs other = (Jobs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsfcourse.entities.Jobs[ id=" + id + " ]";
    }
    
}
