package com.robosh.service.implementation;

import com.robosh.dao.SmartphoneDao;
import com.robosh.entities.Smartphone;
import com.robosh.service.DbService;
import java.util.List;

public class SmartphoneDbServiceImpl implements DbService {

  private SmartphoneDao smartphoneDao;

  public SmartphoneDbServiceImpl(SmartphoneDao smartphoneDao) {
    this.smartphoneDao = smartphoneDao;
  }

  public SmartphoneDbServiceImpl() {
    smartphoneDao = new SmartphoneDao();
  }

  public void save(Smartphone smartphone) {
    smartphoneDao.addSmartphone(smartphone);
  }

  public List<Smartphone> findAll() {
    return smartphoneDao.getSmartphoneList();
  }

}
