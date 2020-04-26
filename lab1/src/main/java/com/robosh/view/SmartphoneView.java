package com.robosh.view;

import com.robosh.controller.SmartphoneController;
import com.robosh.enam.Request;
import com.robosh.entities.Smartphone;
import java.util.List;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SmartphoneView {

  private final SmartphoneController smartphoneController;
  private Scanner scanner = new Scanner(System.in);
//  private static volatile SmartphoneView instance;

//  public static SmartphoneView getInstance() {
//    if (instance == null) {
//      synchronized (SmartphoneView.class) {
//        if (instance == null) {
//          instance = new SmartphoneView(smart);
//        }
//      }
//    }
//    return instance;
//  }


  void showMenu() {
    System.out.println("1. Add smartphone");
    System.out.println("2. Show all smartphone");
    System.out.println("0. Exit");
  }

  void showSmartphone(List<Smartphone> smartphoneList) {
    if (smartphoneList.isEmpty()) {
      System.out.println("Database is empty");
    } else {
      for (Smartphone smartphone : smartphoneList) {
        showSmartphone(smartphone);
      }
    }
  }

  void showSmartphone(Smartphone smartphone) {
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

  private void inputSmartphone() {
    System.out.println("Enter one by one in one row smartphone characteristic "
        + "(Name Cores Frequency Ram Diagonal Memory Weight Camera(true/false))");
  }

  public void render() {
    try {
      byte input;
      do {
        showMenu();
        input = scanner.nextByte();
        switch (input) {
          case 1:
            addSmartphoneComponent();
            break;
          case 2:
            showSmartphoneComponent();
            break;
          default:
            break;
        }
      } while (input == 1 || input == 2);
    } catch (Exception e) {
      String message = !e.getMessage().isEmpty() ? "Something went wrong" : e.getMessage();
      System.out.println(message);
    }
  }

  private void addSmartphoneComponent() {
    inputSmartphone();
    String smartphoneFeaturesInput = scanner.useDelimiter("\n").next();
    Smartphone smartphone = (Smartphone) smartphoneController
        .executeRequest(Request.POST, "/smartphone", smartphoneFeaturesInput);
    showSmartphone(smartphone);
  }

  private void showSmartphoneComponent() {
    List<Smartphone> smartphoneList = (List<Smartphone>) smartphoneController
        .executeRequest(Request.GET, "/smartphone", null);
    showSmartphone(smartphoneList);
  }

}
