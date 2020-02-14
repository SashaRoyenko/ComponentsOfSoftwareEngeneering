package com.robosh.handlers;

import static org.junit.jupiter.api.Assertions.*;

import com.robosh.entities.Phone;
import com.robosh.entities.PhoneImpl;
import java.lang.reflect.Proxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyInvocationHandlerTest {

  private Phone phone;

  @BeforeEach
  void init(){
    phone = getPhone();
  }

  @Test
  void shouldThrowExceptionWhenSetMethodIsCall() {
    ClassLoader classLoader = Phone.class.getClassLoader();
    Class<?>[] interfaces = Phone.class.getInterfaces();
    MyInvocationHandler invocationHandler = new MyInvocationHandler(phone);
    PhoneImpl proxyPhone = (PhoneImpl) Proxy
        .newProxyInstance(classLoader, interfaces, invocationHandler);
    assertThrows(UnsupportedOperationException.class, () -> {
      proxyPhone.setName("Huawei");
    });
  }

  private Phone getPhone() {
    return Phone.newBuilder()
        .name("Nokia")
        .weight(200)
        .camera(true)
        .diagonal(5.2f)
        .memory(16)
        .build();
  }
}