package com.robosh.parser;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

import com.robosh.entities.Phone;

public class PhoneInputParser implements Parser {

  @Override
  public Phone parse(String input) {
    input = input.replaceAll(REMOVE_SPACES, " ").trim();
    String[] stringParameters = input.split("\\s");
    return formSmartphone(stringParameters);
  }

  private Phone formSmartphone(String[] data) {
    try {
      if (data.length != 8) {
        throw new IllegalArgumentException();
      }
      return Phone.newBuilder()
          .name(data[0])
          .diagonal(parseFloat(data[1]))
          .memory(parseInt(data[2]))
          .weight(parseInt(data[3]))
          .camera(parseBoolean(data[4]))
          .build();
    } catch (Exception ex) {
      throw new IllegalArgumentException("Failed to parse data");
    }
  }
}
