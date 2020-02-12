package com.robosh.view;

import com.robosh.entities.Smartphone;
import java.util.List;

public class SmartphoneView {

  public void showMenu() {
    System.out.println("1. Add smartphone");
    System.out.println("2. Show all smartphone");
    System.out.println("0. Exit");
  }

  public void showSmartphone(List<Smartphone> smartphoneList) {
    if (smartphoneList.isEmpty()) {
      System.out.println("Database is empty");
    } else {
      for (Smartphone smartphone : smartphoneList) {
        showSmartphone(smartphone);
      }
    }
  }

  public void showSmartphone(Smartphone smartphone) {
    System.out.println("------------------------------------");
    System.out.println("Name: " + smartphone.getName());
    System.out.println("Cores: " + smartphone.getCores());
    System.out.println("Frequency: " + smartphone.getFrequency());
    System.out.println("Ram: " + smartphone.getRam());
    System.out.println("Diagonal: " + smartphone.getDiagonal());
    System.out.println("Memory: " + smartphone.getMemory());
    System.out.println("Weight: " + smartphone.getWeight());
    System.out.println("Camera: " + smartphone.isCamera());
    System.out.println("------------------------------------");
  }

  public void inputSmartphone() {
    System.out.println("Enter one by one in one row smartphone characteristic "
        + "(Name Cores Frequency Ram Diagonal Memory Weight Camera(true/false))");
  }

}
