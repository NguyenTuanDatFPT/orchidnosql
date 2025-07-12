package com.tri.revision.orchild.repository;

import com.tri.revision.orchild.entity.Orchid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrchidRepository extends MongoRepository<Orchid, String> {
    Page<Orchid> findByIsNaturalTrue(Pageable pageable);
    Page<Orchid> findByNameContainingIgnoreCaseAndIsNaturalTrue(String name, Pageable pageable);
    Page<Orchid> findByNameContainingIgnoreCase(String name, Pageable pageable);
    // Removed JPA @Query method; implement filtering in service if needed
}
