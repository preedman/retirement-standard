package com.reedmanit.retirement.standard.service;

import com.reedmanit.retirement.standard.dao.BudgetStandardDao;
import com.reedmanit.retirement.standard.data.Budgetstandard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetStandardService {

    private BudgetStandardRepository budgetStandardRepository;

    public BudgetStandardService(BudgetStandardRepository budgetStandardRepository) {
        this.budgetStandardRepository = budgetStandardRepository;
    }

    public Page<Budgetstandard> findAll(Pageable pgble) {
        return budgetStandardRepository.findAll(pgble);
    }


    public List<BudgetStandardDao> findAllBudgets() {

        List<BudgetStandardDao> budgetstandards = new ArrayList<>();

        List<Budgetstandard> budgetstandardList = budgetStandardRepository.findAll();

        for (Budgetstandard budgetstandard : budgetstandardList) {
            BudgetStandardDao budgetStandardDao = new BudgetStandardDao();
            budgetStandardDao.setId(budgetstandard.getId());
            budgetStandardDao.setItem(budgetstandard.getItem().getDescription());
            budgetStandardDao.setLifestyle(budgetstandard.getLifestyle().getDescription());
            budgetStandardDao.setRetirementtype(budgetstandard.getRetirementtype().getDescription());
            budgetStandardDao.setCategory(budgetstandard.getCategory().getDescription());
            budgetStandardDao.setAmount(budgetstandard.getBudgetperweek().toString() + " per week");
            budgetStandardDao.setStartDate(budgetstandard.getStartdate().toString());
            budgetStandardDao.setEndDate(budgetstandard.getEnddate().toString());
            budgetstandards.add(budgetStandardDao);

        }

        return budgetstandards;

    }
}
