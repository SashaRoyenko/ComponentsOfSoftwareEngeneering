package com.robosh.dao;

import com.robosh.entities.Smartphone;
import java.util.ArrayList;
import java.util.List;

public class SmartphoneDao {
  private final List<Smartphone> smartphoneList = new ArrayList<>();

  public List<Smartphone> getSmartphoneList(){
    return smartphoneList;
  }

  public void addSmartphone(Smartphone smartphone){
    smartphoneList.add(smartphone);
  }

}
