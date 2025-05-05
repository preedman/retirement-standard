
package com.reedmanit.retirement.standard.service;

import com.reedmanit.retirement.standard.data.Lifestyle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LifestyleRepository extends JpaRepository<Lifestyle, Long> {

    // Basic query methods
    @Query("SELECT l FROM Lifestyle l")
    List<Lifestyle> findAllLifestyles();

    Page<Lifestyle> findAll(Pageable pageable);

    Optional<Lifestyle> findById(Long id);

    // Search by description
   // @Query("SELECT l FROM Lifestyle l WHERE LOWER(l.description) LIKE LOWER(CONCAT('%', :description, '%'))")
   // List<Lifestyle> findByDescriptionContainingIgnoreCase(@Param("description") String description);

    // Find all lifestyles ordered by description
    //@Query("SELECT l FROM Lifestyle l ORDER BY l.description")
    //List<Lifestyle> findAllOrderByDescription();

    // Check if lifestyle is in use
    //@Query("SELECT COUNT(b) > 0 FROM Budgetstandard b WHERE b.lifestyle.id = :lifestyleId")
    //boolean hasBudgetStandards(@Param("lifestyleId") Long lifestyleId);
}