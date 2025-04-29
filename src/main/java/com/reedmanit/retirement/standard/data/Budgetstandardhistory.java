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
@Table(name = "budgetstandardhistory")
@NamedQueries({
    @NamedQuery(name = "Budgetstandardhistory.findAll", query = "SELECT b FROM Budgetstandardhistory b"),
    @NamedQuery(name = "Budgetstandardhistory.findById", query = "SELECT b FROM Budgetstandardhistory b WHERE b.id = :id"),
    @NamedQuery(name = "Budgetstandardhistory.findByItem", query = "SELECT b FROM Budgetstandardhistory b WHERE b.item = :item"),
    @NamedQuery(name = "Budgetstandardhistory.findByLifestyle", query = "SELECT b FROM Budgetstandardhistory b WHERE b.lifestyle = :lifestyle"),
    @NamedQuery(name = "Budgetstandardhistory.findByRetirementtype", query = "SELECT b FROM Budgetstandardhistory b WHERE b.retirementtype = :retirementtype"),
    @NamedQuery(name = "Budgetstandardhistory.findByBudgetperweek", query = "SELECT b FROM Budgetstandardhistory b WHERE b.budgetperweek = :budgetperweek"),
    @NamedQuery(name = "Budgetstandardhistory.findByCategory", query = "SELECT b FROM Budgetstandardhistory b WHERE b.category = :category"),
    @NamedQuery(name = "Budgetstandardhistory.findByStartdate", query = "SELECT b FROM Budgetstandardhistory b WHERE b.startdate = :startdate"),
    @NamedQuery(name = "Budgetstandardhistory.findByEnddate", query = "SELECT b FROM Budgetstandardhistory b WHERE b.enddate = :enddate")})
public class Budgetstandardhistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "item")
    private Integer item;
    @Column(name = "lifestyle")
    private Integer lifestyle;
    @Column(name = "retirementtype")
    private Integer retirementtype;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "budgetperweek")
    private Double budgetperweek;
    @Column(name = "category")
    private Integer category;
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;

    public Budgetstandardhistory() {
    }

    public Budgetstandardhistory(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
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

    public Double getBudgetperweek() {
        return budgetperweek;
    }

    public void setBudgetperweek(Double budgetperweek) {
        this.budgetperweek = budgetperweek;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
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
        if (!(object instanceof Budgetstandardhistory)) {
            return false;
        }
        Budgetstandardhistory other = (Budgetstandardhistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.reedmanit.retirementdata.Budgetstandardhistory[ id=" + id + " ]";
    }
    
}
