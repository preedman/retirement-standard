package com.reedmanit.retirement.standard.service;

import com.reedmanit.retirement.standard.data.Retirementtype;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RetirementTypeRepository extends JpaRepository<Retirementtype, Long> {

    // Basic query methods
    @Query("SELECT r FROM Retirementtype r")
    List<Retirementtype> findAllRetirementTypes();

    Page<Retirementtype> findAll(Pageable pageable);

    Optional<Retirementtype> findById(Long id);

    // Search by description
   // @Query("SELECT r FROM Retirementtype r WHERE LOWER(r.description) LIKE LOWER(CONCAT('%', :description, '%'))")
    //List<Retirementtype> findByDescriptionContainingIgnoreCase(@Param("description") String description);

    // Find all retirement types ordered by description
    //@Query("SELECT r FROM Retirementtype r ORDER BY r.description")
    //List<Retirementtype> findAllOrderByDescription();

    // Check if retirement type is in use
    //@Query("SELECT COUNT(b) > 0 FROM Budgetstandard b WHERE b.retirementtype.id = :retirementTypeId")
    //boolean hasBudgetStandards(@Param("retirementTypeId") Long retirementTypeId);
}
