package com.robosh.service.proxy;

import com.robosh.dao.SmartphoneDao;
import com.robosh.entities.Smartphone;
import com.robosh.service.DbService;
import com.robosh.service.implementation.SmartphoneDbServiceImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxySmartphoneDbService implements DbService {

  private SmartphoneDbServiceImpl smartphoneDbService;
  private SmartphoneDao smartphoneDao;

  public ProxySmartphoneDbService() {
    smartphoneDbService = new SmartphoneDbServiceImpl();
    this.smartphoneDao = new SmartphoneDao();
  }


  @Override
  public void save(Smartphone smartphone) {
    log.info("Start saving data");
    smartphoneDbService.save(smartphone);
    log.info("Data has been saved successfully");
  }

  @Override
  public List<Smartphone> findAll() {
    log.info("Start extracting data");
    List<Smartphone> smartphoneList = smartphoneDbService.findAll();
    log.info("Extracted [{}] elements", smartphoneList.size());
    return smartphoneList;
  }
}
