package com.robosh.service.proxy;

import com.robosh.entities.Smartphone;
import com.robosh.service.DbService;
import com.robosh.service.implementation.SmartphoneDbServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProxySmartphoneDbService implements DbService {

  private final SmartphoneDbServiceImpl smartphoneDbService;

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
