package com.reedmanit.retirement.standard.dao;

public class BudgetStandardDao {

    private Long id;
    private String item;
    private String lifestyle;
    private String retirementtype;
    private String category;
    private String description;
    private String startDate;
    private String endDate;
    private String amount;

    public BudgetStandardDao() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(String lifestyle) {
        this.lifestyle = lifestyle;
    }

    public String getRetirementtype() {
        return retirementtype;
    }

    public void setRetirementtype(String retirementtype) {
        this.retirementtype = retirementtype;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
