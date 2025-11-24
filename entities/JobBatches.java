/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jsfcourse.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "job_batches")
@NamedQueries({
    @NamedQuery(name = "JobBatches.findAll", query = "SELECT j FROM JobBatches j"),
    @NamedQuery(name = "JobBatches.findById", query = "SELECT j FROM JobBatches j WHERE j.id = :id"),
    @NamedQuery(name = "JobBatches.findByName", query = "SELECT j FROM JobBatches j WHERE j.name = :name"),
    @NamedQuery(name = "JobBatches.findByTotalJobs", query = "SELECT j FROM JobBatches j WHERE j.totalJobs = :totalJobs"),
    @NamedQuery(name = "JobBatches.findByPendingJobs", query = "SELECT j FROM JobBatches j WHERE j.pendingJobs = :pendingJobs"),
    @NamedQuery(name = "JobBatches.findByFailedJobs", query = "SELECT j FROM JobBatches j WHERE j.failedJobs = :failedJobs"),
    @NamedQuery(name = "JobBatches.findByCancelledAt", query = "SELECT j FROM JobBatches j WHERE j.cancelledAt = :cancelledAt"),
    @NamedQuery(name = "JobBatches.findByCreatedAt", query = "SELECT j FROM JobBatches j WHERE j.createdAt = :createdAt"),
    @NamedQuery(name = "JobBatches.findByFinishedAt", query = "SELECT j FROM JobBatches j WHERE j.finishedAt = :finishedAt")})
public class JobBatches implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_jobs")
    private int totalJobs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pending_jobs")
    private int pendingJobs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "failed_jobs")
    private int failedJobs;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "failed_job_ids")
    private String failedJobIds;
    @Lob
    @Size(max = 16777215)
    @Column(name = "options")
    private String options;
    @Column(name = "cancelled_at")
    private Integer cancelledAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    private int createdAt;
    @Column(name = "finished_at")
    private Integer finishedAt;

    public JobBatches() {
    }

    public JobBatches(String id) {
        this.id = id;
    }

    public JobBatches(String id, String name, int totalJobs, int pendingJobs, int failedJobs, String failedJobIds, int createdAt) {
        this.id = id;
        this.name = name;
        this.totalJobs = totalJobs;
        this.pendingJobs = pendingJobs;
        this.failedJobs = failedJobs;
        this.failedJobIds = failedJobIds;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalJobs() {
        return totalJobs;
    }

    public void setTotalJobs(int totalJobs) {
        this.totalJobs = totalJobs;
    }

    public int getPendingJobs() {
        return pendingJobs;
    }

    public void setPendingJobs(int pendingJobs) {
        this.pendingJobs = pendingJobs;
    }

    public int getFailedJobs() {
        return failedJobs;
    }

    public void setFailedJobs(int failedJobs) {
        this.failedJobs = failedJobs;
    }

    public String getFailedJobIds() {
        return failedJobIds;
    }

    public void setFailedJobIds(String failedJobIds) {
        this.failedJobIds = failedJobIds;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Integer getCancelledAt() {
        return cancelledAt;
    }

    public void setCancelledAt(Integer cancelledAt) {
        this.cancelledAt = cancelledAt;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Integer finishedAt) {
        this.finishedAt = finishedAt;
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
        if (!(object instanceof JobBatches)) {
            return false;
        }
        JobBatches other = (JobBatches) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsfcourse.entities.JobBatches[ id=" + id + " ]";
    }
    
}
