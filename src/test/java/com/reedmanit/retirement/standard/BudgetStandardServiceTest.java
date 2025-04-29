package com.reedmanit.retirement.standard;

import com.reedmanit.retirement.standard.dao.BudgetStandardDao;
import com.reedmanit.retirement.standard.data.Budgetstandard;
import com.reedmanit.retirement.standard.service.BudgetStandardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BudgetStandardServiceTest {

    @Autowired
    private BudgetStandardService budgetStandardService;

    @Test
    public void findAll() {
        System.out.println("BudgetStandardService.findAll Test");
        List<BudgetStandardDao> listOfBudgetStandards = budgetStandardService.findAllBudgets();
        assertThat(listOfBudgetStandards.size()).isEqualTo(124);

        for (BudgetStandardDao budgetstandard : listOfBudgetStandards) {
            System.out.println(budgetstandard.getId() + " " + "Item " + budgetstandard.getItem() + " " + budgetstandard.getLifestyle());
        }

    }
}
