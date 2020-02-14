package com.robosh.entities;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(callSuper = true)
public class Smartphone extends Phone {
    private float frequency;
    private int cores;
    private int ram;

    @lombok.Builder
    @SuppressWarnings("squid:S00107")
    public Smartphone(String name, int weight, float diagonal, int memory, boolean camera,
                      float frequency, int cores, int ram) {
        super(name, weight, diagonal, memory, camera);
        this.frequency = frequency;
        this.cores = cores;
        this.ram = ram;
    }

}
