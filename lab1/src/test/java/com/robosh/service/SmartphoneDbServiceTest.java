package com.robosh.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.robosh.entities.Smartphone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SmartphoneDbServiceTest {

  private Smartphone smartphone;
  private SmartphoneService smartphoneService;

  @BeforeEach
  void init() {
    smartphone = getSmartphone();
    smartphoneService = new SmartphoneService(smartphone);
  }

  @ParameterizedTest
  @CsvSource({"2,128", "1,64", "3,192"})
  void shouldIncreaseSmartphoneMemory(int input, int expected) {
    smartphoneService.increaseMemory(input);
    assertEquals(expected, smartphone.getMemory());
  }

  @ParameterizedTest
  @ValueSource(ints = {-5, -4, 0})
  void shouldThrowExceptionWhenParameterLowerOrEqualZero(int input) {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> smartphoneService.increaseMemory(input));
    assertEquals("Number of increase can't be <= 0", exception.getMessage());
  }

  private Smartphone getSmartphone() {
    return Smartphone.builder()
        .name("Xiaomi")
        .memory(64)
        .camera(true)
        .cores(8)
        .diagonal(15.6f)
        .frequency(2)
        .ram(4)
        .weight(160)
        .build();
  }
}
