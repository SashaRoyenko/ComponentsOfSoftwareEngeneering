package com.robosh.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Getter
public class Phone implements PhoneImpl {

  protected String name;
  protected int weight;
  protected float diagonal;
  protected int memory;
  protected boolean camera;

  public static Builder newBuilder() {
    return new Phone().new Builder();
  }

  public class Builder {

    private Builder() {

    }

    public Builder name(String name) {
      Phone.this.name = name;
      return this;
    }

    public Builder weight(int weight) {
      Phone.this.weight = weight;
      return this;
    }

    public Builder diagonal(float diagonal) {
      Phone.this.diagonal = diagonal;
      return this;
    }

    public Builder memory(int memory) {
      Phone.this.memory = memory;
      return this;
    }

    public Builder camera(boolean camera) {
      Phone.this.camera = camera;
      return this;
    }

    public Phone build() {
      return Phone.this;
    }

  }

}
