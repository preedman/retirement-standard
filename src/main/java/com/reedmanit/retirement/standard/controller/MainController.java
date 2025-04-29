package com.reedmanit.retirement.standard.controller;

import com.reedmanit.retirement.standard.dao.BudgetStandardDao;
import com.reedmanit.retirement.standard.data.Budgetstandard;
import com.reedmanit.retirement.standard.service.BudgetStandardRepository;
import com.reedmanit.retirement.standard.service.BudgetStandardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private BudgetStandardService budgetStandardService;

    public MainController(BudgetStandardService budgetStandardService) {
        this.budgetStandardService = budgetStandardService;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String goToMainPage(ModelMap model) {

        List<BudgetStandardDao> listOfBudgetStandards = budgetStandardService.findAllBudgets();

        model.addAttribute("listOfBudgetStandards", listOfBudgetStandards);

        logger.info("Going to main page");



        //model.put("name", getLoggedinUserName());
        return "main";
    }

    @RequestMapping("/main/{page}")
    public String budgetlist(@PathVariable("page") Integer page, Model model) {

        logger.info("Going to page " + page);
        Pageable pgable = PageRequest.of(page, 5);

        Page<Budgetstandard> doc = budgetStandardService.findAll(pgable);

        List<BudgetStandardDao> budgetstandards = new ArrayList<>();

        for (Budgetstandard budgetstandard : doc.getContent()) {
            BudgetStandardDao budgetStandardDao = new BudgetStandardDao();
            budgetStandardDao.setId(budgetstandard.getId());
            budgetStandardDao.setItem(budgetstandard.getItem().getDescription());
            budgetStandardDao.setLifestyle(budgetstandard.getLifestyle().getDescription());
            budgetStandardDao.setRetirementtype(budgetstandard.getRetirementtype().getDescription());
            budgetStandardDao.setCategory(budgetstandard.getCategory().getDescription());
            budgetStandardDao.setAmount(budgetstandard.getBudgetperweek().toString() + " per week");
            budgetStandardDao.setStartDate(budgetstandard.getStartdate().toString());
            budgetStandardDao.setEndDate(budgetstandard.getEnddate().toString());
        }



        model.addAttribute("listOfBudgetStandards", budgetstandards);
        model.addAttribute("curpage", page);
        model.addAttribute("totalpage", doc.getTotalPages());

        logger.info("Going to page " + page + " with " + doc.getContent().size() + " items");
        return "main";
    }

}
