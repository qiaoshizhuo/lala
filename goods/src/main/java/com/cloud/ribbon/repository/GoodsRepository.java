package com.cloud.ribbon.repository;

import com.cloud.ribbon.entity.product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<product, Long> {
}
