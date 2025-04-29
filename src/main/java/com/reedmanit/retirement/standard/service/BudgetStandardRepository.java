package com.reedmanit.retirement.standard.service;

import com.reedmanit.retirement.standard.data.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetStandardRepository extends JpaRepository<Budgetstandard, Long> {

    // Basic findAll methods
    @Query("SELECT b FROM Budgetstandard b")
    List<Budgetstandard> findAllBudgetStandards();

    Page<Budgetstandard> findAll(Pageable pageable);

    // Single filter methods
    Page<Budgetstandard> findByLifestyleId(Long lifestyleId, Pageable pageable);

    @Query("SELECT b FROM Budgetstandard b WHERE b.category.id = :categoryId")
    Page<Budgetstandard> findByCategoryId(Long categoryId, Pageable pageable);

    @Query("SELECT b FROM Budgetstandard b WHERE b.retirementtype.id = :retirementTypeId")
    Page<Budgetstandard> findByRetirementTypeId(Long retirementTypeId, Pageable pageable);

    // Double filter combinations
    @Query("SELECT b FROM Budgetstandard b WHERE b.lifestyle.id = :lifestyleId AND b.category.id = :categoryId")
    Page<Budgetstandard> findByLifestyleIdAndCategoryId(Long lifestyleId, Long categoryId, Pageable pageable);

    @Query("SELECT b FROM Budgetstandard b WHERE b.lifestyle.id = :lifestyleId AND b.retirementtype.id = :retirementTypeId")
    Page<Budgetstandard> findByLifestyleIdAndRetirementTypeId(Long lifestyleId, Long retirementTypeId, Pageable pageable);

    @Query("SELECT b FROM Budgetstandard b WHERE b.category.id = :categoryId AND b.retirementtype.id = :retirementTypeId")
    Page<Budgetstandard> findByCategoryIdAndRetirementTypeId(Long categoryId, Long retirementTypeId, Pageable pageable);

    // Triple filter combination
    @Query("SELECT b FROM Budgetstandard b WHERE b.lifestyle.id = :lifestyleId " +
            "AND b.category.id = :categoryId " +
            "AND b.retirementtype.id = :retirementTypeId")
    Page<Budgetstandard> findByLifestyleIdAndCategoryIdAndRetirementTypeId(
            Long lifestyleId, Long categoryId, Long retirementTypeId, Pageable pageable);

    // Methods to get filter options
    @Query("SELECT DISTINCT b.lifestyle FROM Budgetstandard b ORDER BY b.lifestyle.description")
    List<Lifestyle> findAllLifestyles();

    @Query("SELECT DISTINCT b.category FROM Budgetstandard b ORDER BY b.category.description")
    List<Category> findAllCategories();

    @Query("SELECT DISTINCT b.retirementtype FROM Budgetstandard b ORDER BY b.retirementtype.description")
    List<Retirementtype> findAllRetirementTypes();

    // Optional: Advanced search methods with dynamic date ranges
    @Query("SELECT b FROM Budgetstandard b WHERE " +
            "(:lifestyleId IS NULL OR b.lifestyle.id = :lifestyleId) AND " +
            "(:categoryId IS NULL OR b.category.id = :categoryId) AND " +
            "(:retirementTypeId IS NULL OR b.retirementtype.id = :retirementTypeId) AND " +
            "(:startDate IS NULL OR b.startdate >= :startDate) AND " +
            "(:endDate IS NULL OR b.enddate <= :endDate)")
    Page<Budgetstandard> findWithFilters(
            Long lifestyleId,
            Long categoryId,
            Long retirementTypeId,
            java.util.Date startDate,
            java.util.Date endDate,
            Pageable pageable);

    // Add this method if you don't already have it
    Optional<Budgetstandard> findById(Long id);

}



