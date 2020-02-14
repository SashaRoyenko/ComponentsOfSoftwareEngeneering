package com.robosh.parser;


import static java.lang.Boolean.parseBoolean;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

import com.robosh.entities.Smartphone;

public class SmartphoneInputParser implements Parser {

  @Override
  public Smartphone parse(String input) {
    input = input.replaceAll(REMOVE_SPACES, " ").trim();
    String[] stringParameters = input.split("\\s");
    return formSmartphone(stringParameters);
  }

  private Smartphone formSmartphone(String[] data) {
    try {
      if (data.length != 8) {
        throw new IllegalArgumentException();
      }
      return Smartphone.builder()
          .name(data[0])
          .cores(parseInt(data[1]))
          .frequency(parseFloat(data[2]))
          .ram(parseInt(data[3]))
          .diagonal(parseFloat(data[4]))
          .memory(parseInt(data[5]))
          .weight(parseInt(data[6]))
          .camera(parseBoolean(data[7]))
          .build();
    } catch (Exception ex) {
      throw new IllegalArgumentException("Failed to parse data");
    }
  }

}
