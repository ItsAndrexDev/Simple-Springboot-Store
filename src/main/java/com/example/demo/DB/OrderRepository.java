package com.example.demo.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
