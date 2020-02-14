package com.robosh.controller;

import com.robosh.entities.Smartphone;
import com.robosh.parser.Parser;
import com.robosh.parser.SmartphoneInputParser;
import com.robosh.service.DbService;
import com.robosh.service.proxy.ProxySmartphoneDbService;
import java.util.List;

public class SmartphoneController {

  private Parser parser;
  private DbService smartphoneDbService;

  public SmartphoneController() {
    parser = new SmartphoneInputParser();
    smartphoneDbService = new ProxySmartphoneDbService();
  }


  public Smartphone postSmartphone(String input) {
    Smartphone smartphone = (Smartphone) parser.parse(input);
    smartphoneDbService.save(smartphone);
    return smartphone;
  }

  public List<Smartphone> getSmartphones() {
    return smartphoneDbService.findAll();
  }

}
