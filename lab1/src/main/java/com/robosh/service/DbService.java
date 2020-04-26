package com.robosh.service;

import com.robosh.entities.Smartphone;
import java.util.List;


public interface DbService {

  void save(Smartphone smartphone);

  List<Smartphone> findAll();
}
