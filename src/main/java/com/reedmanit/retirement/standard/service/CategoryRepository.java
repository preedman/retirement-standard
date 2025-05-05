package com.reedmanit.retirement.standard.service;



import com.reedmanit.retirement.standard.data.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Basic query methods
    @Query("SELECT c FROM Category c")
    List<Category> findAllCategories();

    Page<Category> findAll(Pageable pageable);

    Optional<Category> findById(Long id);

    // Search by name (assuming Category has a name field)
 //   @Query("SELECT c FROM Category c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
   // List<Category> findByNameContainingIgnoreCase(@Param("name") String name);

    // Find all categories ordered by name
//    @Query("SELECT c FROM Category c ORDER BY c.name")
  //  List<Category> findAllOrderByName();

    // Check if category is in use
  //  @Query("SELECT COUNT(i) > 0 FROM Items i WHERE i.category.id = :categoryId")
   // boolean hasItems(@Param("categoryId") Long categoryId);
}
