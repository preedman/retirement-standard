package com.reedmanit.retirement.standard.service;

import com.reedmanit.retirement.standard.data.Items;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {

    // Basic query methods
    @Query("SELECT i FROM Items i")
    List<Items> findAllItems();

    Page<Items> findAll(Pageable pageable);

    Optional<Items> findById(Long id);

    // Search by description
    @Query("SELECT i FROM Items i WHERE LOWER(i.description) LIKE LOWER(CONCAT('%', :description, '%'))")
    List<Items> findByDescriptionContainingIgnoreCase(@Param("description") String description);

    // Find items by category
    @Query("SELECT i FROM Items i WHERE i.category.id = :categoryId")
    List<Items> findByCategoryId(@Param("categoryId") Long categoryId);

    // Find all items ordered by description (useful for dropdowns)
    @Query("SELECT i FROM Items i ORDER BY i.description")
    List<Items> findAllOrderByDescription();

    // Find active items (if you have an active flag)
   //@Query("SELECT i FROM Items i WHERE i.active = true ORDER BY i.description")
   // List<Items> findActiveItems();

    // Find items by multiple categories
    @Query("SELECT i FROM Items i WHERE i.category.id IN :categoryIds")
    List<Items> findByCategoryIds(@Param("categoryIds") List<Long> categoryIds);

    // Count items by category
    @Query("SELECT COUNT(i) FROM Items i WHERE i.category.id = :categoryId")
    Long countByCategoryId(@Param("categoryId") Long categoryId);
}

