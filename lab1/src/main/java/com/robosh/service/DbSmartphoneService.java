package com.robosh.service;

import com.robosh.dao.SmartphoneDao;
import com.robosh.entities.Smartphone;
import java.util.List;

public class DbSmartphoneService {

  private SmartphoneDao smartphoneDao;

  public DbSmartphoneService() {
    smartphoneDao = new SmartphoneDao();
  }

  public void saveSmartphone(Smartphone smartphone) {
    smartphoneDao.addSmartphone(smartphone);
  }

  public List<Smartphone> findAll() {
    return smartphoneDao.getSmartphoneList();
  }

}
