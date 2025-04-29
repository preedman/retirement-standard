/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reedmanit.retirement.standard.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author preed
 */
@Entity
@Table(name = "retirementtype")
@NamedQueries({
    @NamedQuery(name = "Retirementtype.findAll", query = "SELECT r FROM Retirementtype r"),
    @NamedQuery(name = "Retirementtype.findById", query = "SELECT r FROM Retirementtype r WHERE r.id = :id"),
    @NamedQuery(name = "Retirementtype.findByDescription", query = "SELECT r FROM Retirementtype r WHERE r.description = :description")})
public class Retirementtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "retirementtype")
    private Collection<Budgetstandard> budgetstandardCollection;
    @OneToMany(mappedBy = "retirementtype")
    private Collection<Yearbudget> yearbudgetCollection;

    public Retirementtype() {
    }

    public Retirementtype(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Budgetstandard> getBudgetstandardCollection() {
        return budgetstandardCollection;
    }

    public void setBudgetstandardCollection(Collection<Budgetstandard> budgetstandardCollection) {
        this.budgetstandardCollection = budgetstandardCollection;
    }

    public Collection<Yearbudget> getYearbudgetCollection() {
        return yearbudgetCollection;
    }

    public void setYearbudgetCollection(Collection<Yearbudget> yearbudgetCollection) {
        this.yearbudgetCollection = yearbudgetCollection;
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
        if (!(object instanceof Retirementtype)) {
            return false;
        }
        Retirementtype other = (Retirementtype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.reedmanit.retirementdata.Retirementtype[ id=" + id + " ]";
    }
    
}
