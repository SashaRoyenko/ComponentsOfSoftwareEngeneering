package com.robosh.view;

import com.robosh.controller.SmartphoneController;
import com.robosh.entities.Smartphone;
import java.util.List;
import java.util.Scanner;

public class SmartphoneView {

  private SmartphoneController smartphoneController = new SmartphoneController();
  private Scanner scanner = new Scanner(System.in);
  private static volatile SmartphoneView instance;

  private SmartphoneView() {

  }

  public static SmartphoneView getInstance() {
    if (instance == null) {
      synchronized (SmartphoneView.class) {
        if (instance == null) {
          instance = new SmartphoneView();
        }
      }
    }
    return instance;
  }


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

  public static void main(String[] args) {
    SmartphoneView view = SmartphoneView.getInstance();
    view.render();
  }

  public void render() {
    byte input;
    do {
      showMenu();
      input = scanner.nextByte();
      switch (input) {
        case 1:
          inputSmartphone();
          String smartphoneFeaturesInput = scanner.useDelimiter("\n").next();
          try {
            Smartphone smartphone = smartphoneController.postSmartphone(smartphoneFeaturesInput);
            showSmartphone(smartphone);
          } catch (Exception e) {
            System.out.println("Error 500");
          }
          break;
        case 2:
          List<Smartphone> smartphones = smartphoneController.getSmartphones();
          showSmartphone(smartphones);
          break;
        default:
          break;
      }
    } while (input == 1 || input == 2);
  }

}
