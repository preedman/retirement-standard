package com.reedmanit.retirement.standard.controller;

import com.reedmanit.retirement.standard.data.Budgetstandard;
import com.reedmanit.retirement.standard.service.*;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public class BudgetStandardController {

    @Autowired
    private BudgetStandardRepository budgetStandardRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LifestyleRepository lifestyleRepository;

    @Autowired
    private RetirementTypeRepository retirementTypeRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());





    @RequestMapping(value = "/budgetstandards", method = RequestMethod.GET)
    public String listBudgetStandards(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Long lifestyleId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long retirementTypeId,
            Model model) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Budgetstandard> budgetStandardsPage;

        // Apply filters based on which parameters are present
        if (lifestyleId != null && categoryId != null && retirementTypeId != null) {
            budgetStandardsPage = budgetStandardRepository.findByLifestyleIdAndCategoryIdAndRetirementTypeId
            (lifestyleId, categoryId, retirementTypeId, pageRequest);
        } else if (lifestyleId != null && categoryId != null) {
            budgetStandardsPage = budgetStandardRepository
                    .findByLifestyleIdAndCategoryId(lifestyleId, categoryId, pageRequest);
        } else if (lifestyleId != null && retirementTypeId != null) {
            budgetStandardsPage = budgetStandardRepository.findByLifestyleIdAndRetirementTypeId
                    (lifestyleId, retirementTypeId, pageRequest);
        } else if (categoryId != null && retirementTypeId != null) {
            budgetStandardsPage = budgetStandardRepository.findByCategoryIdAndRetirementTypeId
                    (categoryId, retirementTypeId, pageRequest);
        } else if (lifestyleId != null) {
            budgetStandardsPage = budgetStandardRepository
                    .findByLifestyleId(lifestyleId, pageRequest);
        } else if (categoryId != null) {
            budgetStandardsPage = budgetStandardRepository
                    .findByCategoryId(categoryId, pageRequest);
        } else if (retirementTypeId != null) {
            budgetStandardsPage = budgetStandardRepository.findByRetirementTypeId(retirementTypeId, pageRequest);

        } else {
            budgetStandardsPage = budgetStandardRepository.findAll(pageRequest);
        }

        // Add all necessary attributes to the model
        model.addAttribute("budgetStandards", budgetStandardsPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", budgetStandardsPage.getTotalPages());
        model.addAttribute("totalItems", budgetStandardsPage.getTotalElements());

        // Add filter options
        model.addAttribute("lifestyles", budgetStandardRepository.findAllLifestyles());
        model.addAttribute("categories", budgetStandardRepository.findAllCategories());
        model.addAttribute("retirementTypes", budgetStandardRepository.findAllRetirementTypes());

        // Add selected filter values
        model.addAttribute("selectedLifestyle", lifestyleId);
        model.addAttribute("selectedCategory", categoryId);
        model.addAttribute("selectedRetirementType", retirementTypeId);

        return "budgetstandards"; // name of your JSP file
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("budgetStandard", new Budgetstandard());
        addFormAttributes(model);
        return "budgetStandardForm";
    }



    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Budgetstandard budgetStandard = budgetStandardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid budget standard Id:" + id));
        model.addAttribute("budgetStandard", budgetStandard);
        addFormAttributes(model);
        return "budgetStandardForm";
    }

    @PostMapping("/save")
    public String saveBudgetStandard(@Valid @ModelAttribute("budgetStandard") Budgetstandard budgetStandard,
                                     BindingResult result, Model model) {

        if (result.hasErrors()) {
            logger.info(result.getAllErrors().toString());
            addFormAttributes(model);
            return "budgetStandardForm";
        }

        budgetStandardRepository.save(budgetStandard);
        return "redirect:/budgetstandards";
    }

    private void addFormAttributes(Model model) {
       // model.addAttribute("lifestyles", budgetStandardRepository.findAllLifestyles());
        model.addAttribute("lifestyles", lifestyleRepository.findAllLifestyles());
      //  model.addAttribute("categories", budgetStandardRepository.findAllCategories());
        model.addAttribute("categories", categoryRepository.findAllCategories());
    //        model.addAttribute("retirementTypes", budgetStandardRepository.findAllRetirementTypes());
        model.addAttribute("retirementTypes", retirementTypeRepository.findAllRetirementTypes());
        // You'll need to add a method to get all items
        model.addAttribute("items", itemsRepository.findAll());
    }




}