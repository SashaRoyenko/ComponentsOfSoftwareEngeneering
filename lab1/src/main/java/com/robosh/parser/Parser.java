package com.robosh.parser;

public interface Parser {
  String REMOVE_SPACES = "\\s+";
  Object parse(String input);
}
