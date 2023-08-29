package com.springrest.springrest.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springrest.springrest.entities.Load;

public interface LoadDao extends JpaRepository<Load, Long> {
  List<Load> findByShipperId(long shipperId);
}
