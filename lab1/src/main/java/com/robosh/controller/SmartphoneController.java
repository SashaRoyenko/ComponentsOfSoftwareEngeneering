package com.robosh.controller;

import com.robosh.entities.Smartphone;
import com.robosh.parser.Parser;
import com.robosh.parser.SmartphoneInputParser;
import com.robosh.service.DbSmartphoneService;
import com.robosh.view.SmartphoneView;
import java.util.Scanner;

public class SmartphoneController {

  private SmartphoneView view;
  private Parser parser;
  private DbSmartphoneService smartphoneService;
  private Scanner scanner = new Scanner(System.in);

  public SmartphoneController() {
    view = new SmartphoneView();
    parser = new SmartphoneInputParser();
    smartphoneService = new DbSmartphoneService();
  }

  public static void main(String[] args) {
    SmartphoneController smartphoneController = new SmartphoneController();
    smartphoneController.execute();
  }

  public void execute() {
    byte input = 0;
    do {
      view.showMenu();
      input = scanner.nextByte();
      switch (input) {
        case 1:
          saveSmartphone();
          break;
        case 2:
          view.showSmartphone(smartphoneService.findAll());
          break;
        default:
          break;
      }
    } while (input == 1 || input == 2);
  }

  private void saveSmartphone() {
    view.inputSmartphone();
    String input = scanner.useDelimiter("\n").next();
    Smartphone smartphone = (Smartphone) parser.parse(input);
    smartphoneService.saveSmartphone(smartphone);
    view.showSmartphone(smartphone);
  }

}
