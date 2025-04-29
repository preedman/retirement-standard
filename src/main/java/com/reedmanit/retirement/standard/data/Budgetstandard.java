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
@Table(name = "budgetstandard")
@NamedQueries({
    @NamedQuery(name = "Budgetstandard.findAll", query = "SELECT b FROM Budgetstandard b"),
    @NamedQuery(name = "Budgetstandard.findById", query = "SELECT b FROM Budgetstandard b WHERE b.id = :id"),
    @NamedQuery(name = "Budgetstandard.findByBudgetperweek", query = "SELECT b FROM Budgetstandard b WHERE b.budgetperweek = :budgetperweek"),
    @NamedQuery(name = "Budgetstandard.findByStartdate", query = "SELECT b FROM Budgetstandard b WHERE b.startdate = :startdate"),
    @NamedQuery(name = "Budgetstandard.findByEnddate", query = "SELECT b FROM Budgetstandard b WHERE b.enddate = :enddate")})
public class Budgetstandard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "budgetperweek")
    private Double budgetperweek;
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @JoinColumn(name = "category", referencedColumnName = "id")
    @ManyToOne
    private Category category;
    @JoinColumn(name = "item", referencedColumnName = "id")
    @ManyToOne
    private Items item;
    @JoinColumn(name = "lifestyle", referencedColumnName = "id")
    @ManyToOne
    private Lifestyle lifestyle;
    @JoinColumn(name = "retirementtype", referencedColumnName = "id")
    @ManyToOne
    private Retirementtype retirementtype;

    public Budgetstandard() {
    }

    public Budgetstandard(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBudgetperweek() {
        return budgetperweek;
    }

    public void setBudgetperweek(Double budgetperweek) {
        this.budgetperweek = budgetperweek;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
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
        if (!(object instanceof Budgetstandard)) {
            return false;
        }
        Budgetstandard other = (Budgetstandard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.reedmanit.retirementdata.Budgetstandard[ id=" + id + " ]";
    }
    
}
