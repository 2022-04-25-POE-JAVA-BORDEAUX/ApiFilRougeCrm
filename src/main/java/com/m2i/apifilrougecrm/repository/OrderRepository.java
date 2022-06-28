package com.m2i.apifilrougecrm.repository;

import com.m2i.apifilrougecrm.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findAllByTypePresta(String typePresta);
}
