package com.project.inventory.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.inventory.stockmanagement.model.StockDetail;

@Repository
public interface StockRepository extends JpaRepository<StockDetail,Long> {

}
