package com.robosh.service;

import com.robosh.annotations.TestAnnotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class ReflectionService {

  private Object object;

  public String getClassName() {
    return object.getClass().getSimpleName();
  }

  public String getSuperClassName() {
    return object.getClass().getSuperclass().getSimpleName();
  }

  public List<String> getParametersOfMethods() {
    return Arrays.stream(object.getClass().getMethods())
        .map(method ->
            method.getReturnType().getName() + " " + method.getName() + " " + Arrays
                .toString(method.getParameterTypes()))
        .collect(Collectors.toList());
  }

  @SneakyThrows
  public void invokeMethodMarkedWithAnnotation(Class annotation, int parameter) {
    for (Method method : object.getClass().getMethods()) {
      if (method.isAnnotationPresent(TestAnnotation.class)) {
        method.invoke(object, parameter);
      }
    }
  }

}
