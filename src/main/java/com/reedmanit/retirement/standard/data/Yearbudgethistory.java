/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reedmanit.retirement.standard.data;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author preed
 */
@Entity
@Table(name = "yearbudgethistory")
@NamedQueries({
    @NamedQuery(name = "Yearbudgethistory.findAll", query = "SELECT y FROM Yearbudgethistory y"),
    @NamedQuery(name = "Yearbudgethistory.findById", query = "SELECT y FROM Yearbudgethistory y WHERE y.id = :id"),
    @NamedQuery(name = "Yearbudgethistory.findByLifestyle", query = "SELECT y FROM Yearbudgethistory y WHERE y.lifestyle = :lifestyle"),
    @NamedQuery(name = "Yearbudgethistory.findByRetirementtype", query = "SELECT y FROM Yearbudgethistory y WHERE y.retirementtype = :retirementtype"),
    @NamedQuery(name = "Yearbudgethistory.findByYearamount", query = "SELECT y FROM Yearbudgethistory y WHERE y.yearamount = :yearamount"),
    @NamedQuery(name = "Yearbudgethistory.findByStartdate", query = "SELECT y FROM Yearbudgethistory y WHERE y.startdate = :startdate"),
    @NamedQuery(name = "Yearbudgethistory.findByEnddate", query = "SELECT y FROM Yearbudgethistory y WHERE y.enddate = :enddate")})
public class Yearbudgethistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "lifestyle")
    private Integer lifestyle;
    @Column(name = "retirementtype")
    private Integer retirementtype;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "yearamount")
    private Double yearamount;
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;

    public Yearbudgethistory() {
    }

    public Yearbudgethistory(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(Integer lifestyle) {
        this.lifestyle = lifestyle;
    }

    public Integer getRetirementtype() {
        return retirementtype;
    }

    public void setRetirementtype(Integer retirementtype) {
        this.retirementtype = retirementtype;
    }

    public Double getYearamount() {
        return yearamount;
    }

    public void setYearamount(Double yearamount) {
        this.yearamount = yearamount;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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
        if (!(object instanceof Yearbudgethistory)) {
            return false;
        }
        Yearbudgethistory other = (Yearbudgethistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.reedmanit.retirementdata.Yearbudgethistory[ id=" + id + " ]";
    }
    
}
