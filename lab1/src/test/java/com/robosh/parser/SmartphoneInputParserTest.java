package com.robosh.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.robosh.entities.Smartphone;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SmartphoneInputParserTest {

  private SmartphoneInputParser parser;

  SmartphoneInputParserTest() {
    this.parser = new SmartphoneInputParser();
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "Xiaomi 8 2.2 8 6.2 64 120 true",
      "Xiaomi 8  2.2  8  6.2  64 120   true",
      "  Xiaomi 8 2.2 8 6.2 64 120 true",
      "  Xiaomi   8 2.2 8 6.2   64    120   true    "
  })
  void shouldReturnSmartphoneObjectAfterParsing(String input) {
    Smartphone expected = getSmartphone();
    Smartphone result = parser.parse(input);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "Xiaomi 8 2,2 8 6.2 64 120 true",
      "Xiaomi 8  2. 2  8  6.2  64 120   tre",
      "  Xiaomi 8 2.2 8 dsf6.2 64 sdfsdf120 true  sfsdff",
      "  Xiaomi   8 2.2 8 df 6.2   64    120   true   dsfsdf ",
      "Xiaomi 8 2. 2 8 6.2 64 120 true",
  })
  void shouldThrowExceptionWhenIncorrectParseData(String input) {
    assertThrows(IllegalArgumentException.class, () -> parser.parse(input));
  }

  private Smartphone getSmartphone() {
    return Smartphone.builder()
        .name("Xiaomi")
        .memory(64)
        .camera(true)
        .cores(8)
        .diagonal(6.2f)
        .frequency(2.2f)
        .ram(8)
        .weight(120)
        .build();
  }

}