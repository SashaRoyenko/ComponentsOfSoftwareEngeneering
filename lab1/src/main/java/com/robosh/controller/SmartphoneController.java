package com.robosh.controller;

import com.robosh.entities.Smartphone;
import com.robosh.parser.Parser;
import com.robosh.parser.SmartphoneInputParser;
import com.robosh.service.DbSmartphoneService;
import java.util.List;

public class SmartphoneController {

  private Parser parser;
  private DbSmartphoneService smartphoneService;

  public SmartphoneController() {
    parser = new SmartphoneInputParser();
    smartphoneService = new DbSmartphoneService();
  }


  public Smartphone postSmartphone(String input) {
    Smartphone smartphone = (Smartphone) parser.parse(input);
    smartphoneService.saveSmartphone(smartphone);
    return smartphone;
  }

  public List<Smartphone> getSmartphones(){
    return smartphoneService.findAll();
  }

}
