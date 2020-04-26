package com.robosh.parser;

public class ParserFactory {

  private ParserFactory() {
  }

  public static Parser getSmartphoneInputParser() {
    return new SmartphoneInputParser();
  }

  public static Parser getPhoneInputParser() {
    return new PhoneInputParser();
  }

}
