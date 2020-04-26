package com.robosh.service;

import com.robosh.annotations.TestAnnotation;
import com.robosh.entities.Smartphone;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SmartphoneService {

  private final Smartphone smartphone;

  @TestAnnotation
  public void increaseMemory(int numberOfIncrease) {

    if (numberOfIncrease <= 0) {
      throw new IllegalArgumentException("Number of increase can't be <= 0");
    }

    int updatedMemory = smartphone.getMemory() * numberOfIncrease;
    smartphone.setMemory(updatedMemory);
  }

}
