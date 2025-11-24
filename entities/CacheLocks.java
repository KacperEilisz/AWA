/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jsfcourse.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "cache_locks")
@NamedQueries({
    @NamedQuery(name = "CacheLocks.findAll", query = "SELECT c FROM CacheLocks c"),
    @NamedQuery(name = "CacheLocks.findByKey", query = "SELECT c FROM CacheLocks c WHERE c.key = :key"),
    @NamedQuery(name = "CacheLocks.findByOwner", query = "SELECT c FROM CacheLocks c WHERE c.owner = :owner"),
    @NamedQuery(name = "CacheLocks.findByExpiration", query = "SELECT c FROM CacheLocks c WHERE c.expiration = :expiration")})
public class CacheLocks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "key")
    private String key;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "owner")
    private String owner;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiration")
    private int expiration;

    public CacheLocks() {
    }

    public CacheLocks(String key) {
        this.key = key;
    }

    public CacheLocks(String key, String owner, int expiration) {
        this.key = key;
        this.owner = owner;
        this.expiration = expiration;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (key != null ? key.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CacheLocks)) {
            return false;
        }
        CacheLocks other = (CacheLocks) object;
        if ((this.key == null && other.key != null) || (this.key != null && !this.key.equals(other.key))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsfcourse.entities.CacheLocks[ key=" + key + " ]";
    }
    
}
