package com.robosh.service.implementation;

import com.robosh.dao.SmartphoneDao;
import com.robosh.entities.Smartphone;
import com.robosh.service.DbService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmartphoneDbServiceImpl implements DbService {

  private final SmartphoneDao smartphoneDao;

  public void save(Smartphone smartphone) {
    smartphoneDao.addSmartphone(smartphone);
  }

  public List<Smartphone> findAll() {
    return smartphoneDao.getSmartphoneList();
  }

}
