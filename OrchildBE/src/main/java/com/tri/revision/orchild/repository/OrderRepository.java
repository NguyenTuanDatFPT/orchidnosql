package com.tri.revision.orchild.repository;

import com.tri.revision.orchild.entity.Order;
import com.tri.revision.orchild.enums.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    Page<Order> findByUserId(String userId, Pageable pageable);
    Page<Order> findByStatus(OrderStatus status, Pageable pageable);
    // Removed JPA @Query method; implement filtering in service if needed
}
