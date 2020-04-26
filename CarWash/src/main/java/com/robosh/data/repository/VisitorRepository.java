package com.robosh.data.repository;

import com.robosh.data.entity.user.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

}
