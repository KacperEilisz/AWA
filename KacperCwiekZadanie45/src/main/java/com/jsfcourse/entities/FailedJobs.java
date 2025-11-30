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
@Table(name = "failed_jobs")
@NamedQueries({
    @NamedQuery(name = "FailedJobs.findAll", query = "SELECT f FROM FailedJobs f"),
    @NamedQuery(name = "FailedJobs.findById", query = "SELECT f FROM FailedJobs f WHERE f.id = :id"),
    @NamedQuery(name = "FailedJobs.findByUuid", query = "SELECT f FROM FailedJobs f WHERE f.uuid = :uuid"),
    @NamedQuery(name = "FailedJobs.findByFailedAt", query = "SELECT f FROM FailedJobs f WHERE f.failedAt = :failedAt")})
public class FailedJobs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "uuid")
    private String uuid;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "connection")
    private String connection;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
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
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "exception")
    private String exception;
    @Basic(optional = false)
    @NotNull
    @Column(name = "failed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date failedAt;

    public FailedJobs() {
    }

    public FailedJobs(Long id) {
        this.id = id;
    }

    public FailedJobs(Long id, String uuid, String connection, String queue, String payload, String exception, Date failedAt) {
        this.id = id;
        this.uuid = uuid;
        this.connection = connection;
        this.queue = queue;
        this.payload = payload;
        this.exception = exception;
        this.failedAt = failedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
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

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Date getFailedAt() {
        return failedAt;
    }

    public void setFailedAt(Date failedAt) {
        this.failedAt = failedAt;
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
        if (!(object instanceof FailedJobs)) {
            return false;
        }
        FailedJobs other = (FailedJobs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsfcourse.entities.FailedJobs[ id=" + id + " ]";
    }
    
}
