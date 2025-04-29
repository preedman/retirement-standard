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
@Table(name = "yearbudget")
@NamedQueries({
    @NamedQuery(name = "Yearbudget.findAll", query = "SELECT y FROM Yearbudget y"),
    @NamedQuery(name = "Yearbudget.findById", query = "SELECT y FROM Yearbudget y WHERE y.id = :id"),
    @NamedQuery(name = "Yearbudget.findByYearamount", query = "SELECT y FROM Yearbudget y WHERE y.yearamount = :yearamount"),
    @NamedQuery(name = "Yearbudget.findByStartdate", query = "SELECT y FROM Yearbudget y WHERE y.startdate = :startdate"),
    @NamedQuery(name = "Yearbudget.findByEnddate", query = "SELECT y FROM Yearbudget y WHERE y.enddate = :enddate")})
public class Yearbudget implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "yearamount")
    private Double yearamount;
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @JoinColumn(name = "lifestyle", referencedColumnName = "id")
    @ManyToOne
    private com.reedmanit.retirement.standard.data.Lifestyle lifestyle;
    @JoinColumn(name = "retirementtype", referencedColumnName = "id")
    @ManyToOne
    private com.reedmanit.retirement.standard.data.Retirementtype retirementtype;

    public Yearbudget() {
    }

    public Yearbudget(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Lifestyle getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(Lifestyle lifestyle) {
        this.lifestyle = lifestyle;
    }

    public Retirementtype getRetirementtype() {
        return retirementtype;
    }

    public void setRetirementtype(Retirementtype retirementtype) {
        this.retirementtype = retirementtype;
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
        if (!(object instanceof Yearbudget)) {
            return false;
        }
        Yearbudget other = (Yearbudget) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.reedmanit.retirementdata.Yearbudget[ id=" + id + " ]";
    }
    
}
