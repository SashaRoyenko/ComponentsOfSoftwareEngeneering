package com.robosh.entities;

import com.robosh.annotations.TestAnnotation;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Smartphone extends Phone {
    private float frequency;
    private int cores;
    private int ram;

    @Builder
    @SuppressWarnings("squid:S00107")
    public Smartphone(String name, int weight, float diagonal, int memory, boolean camera,
                      float frequency, int cores, int ram) {
        super(name, weight, diagonal, memory, camera);
        this.frequency = frequency;
        this.cores = cores;
        this.ram = ram;
    }

}
