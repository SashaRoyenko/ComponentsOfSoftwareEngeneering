package com.robosh.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.robosh.annotations.TestAnnotation;
import com.robosh.entities.Smartphone;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReflectionDbServiceTest {

  private Smartphone smartphone;
  private ReflectionService reflectionService;

  @BeforeEach
  private void init() {
    smartphone = getSmartphone();
  }

  @Test
  void shouldReturnClassName() {
    reflectionService = new ReflectionService(smartphone);
    assertEquals("Smartphone", reflectionService.getClassName());
  }

  @Test
  void shouldReturnSuperclassName() {
    reflectionService = new ReflectionService(smartphone);
    assertEquals("Phone", reflectionService.getSuperClassName());
  }

  @Test
  void shouldReturnMethodsParameters() {
    reflectionService = new ReflectionService(smartphone);
    List<String> result = reflectionService.getParametersOfMethods();
    assertFalse(result.isEmpty());
  }

  @Test
  @SneakyThrows
  void shouldIncreaseMemoryTwice() {
    reflectionService = new ReflectionService(new SmartphoneService(smartphone));
    reflectionService.invokeMethodMarkedWithAnnotation(TestAnnotation.class, 2);
    assertEquals(128, smartphone.getMemory());

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