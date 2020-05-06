package com.robosh.data.repository;

import com.robosh.data.entity.WashService;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WashServiceRepository extends JpaRepository<WashService, Long> {

  List<WashService> findAllByIdIn(List<Long> ids);
}
