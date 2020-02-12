package com.robosh.entities;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Getter
public class Phone implements PhoneImpl{
    protected String name;
    protected int weight;
    protected float diagonal;
    protected int memory;
    protected boolean camera;
}
