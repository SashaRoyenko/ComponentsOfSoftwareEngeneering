package com.robosh.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.robosh.dao.SmartphoneDao;
import com.robosh.entities.Smartphone;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DbSmartphoneServiceTest {

  private DbSmartphoneService smartphoneService;

  @Mock
  private SmartphoneDao smartphoneDao;

  @BeforeEach
  void init() {
    smartphoneService = new DbSmartphoneService(smartphoneDao);
  }

  @Test
  void shouldReturnAllSmartphone() {
    when(smartphoneDao.getSmartphoneList()).thenReturn(getSmartphoneList());

    List<Smartphone> result = smartphoneService.findAll();
    List<Smartphone> expected = getSmartphoneList();
    assertEquals(expected, result);
    verify(smartphoneDao).getSmartphoneList();
  }

  @Test
  void shouldSaveSmartphone() {
    Smartphone smartphone = getSmartphoneList().get(0);
    smartphoneService.saveSmartphone(smartphone);
    verify(smartphoneDao).addSmartphone(smartphone);
  }

  List<Smartphone> getSmartphoneList() {
    List<Smartphone> smartphoneList = new ArrayList();
    smartphoneList.add(Smartphone.builder()
        .name("Xiaomi")
        .memory(64)
        .camera(true)
        .cores(8)
        .diagonal(5.6f)
        .frequency(2)
        .ram(4)
        .weight(160)
        .build());

    smartphoneList.add(Smartphone.builder()
        .name("Samsung")
        .memory(512)
        .camera(true)
        .cores(8)
        .diagonal(6.9f)
        .frequency(4)
        .ram(16)
        .weight(200)
        .build());

    return smartphoneList;
  }
}