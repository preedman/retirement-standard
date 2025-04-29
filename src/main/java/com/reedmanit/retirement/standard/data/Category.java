/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reedmanit.retirement.standard.data;

import com.reedmanit.retirement.standard.data.Budgetstandard;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author preed
 */
@Entity
@Table(name = "category")
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findById", query = "SELECT c FROM Category c WHERE c.id = :id"),
    @NamedQuery(name = "Category.findByDescription", query = "SELECT c FROM Category c WHERE c.description = :description")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "category")
    private Collection<Budgetstandard> budgetstandardCollection;
    @OneToMany(mappedBy = "category")
    private Collection<com.reedmanit.retirement.standard.data.Items> itemsCollection;

    public Category() {
    }

    public Category(Long id) {
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

    public Collection<com.reedmanit.retirement.standard.data.Items> getItemsCollection() {
        return itemsCollection;
    }

    public void setItemsCollection(Collection<com.reedmanit.retirement.standard.data.Items> itemsCollection) {
        this.itemsCollection = itemsCollection;
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
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.reedmanit.retirementdata.Category[ id=" + id + " ]";
    }
    
}
