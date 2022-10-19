package com.melita.ordertakingapi.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductCategoryRepository extends JpaRepository<OrderProductCategory, Integer> {
}
