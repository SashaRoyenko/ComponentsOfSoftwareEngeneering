package com.robosh.entities;

public interface PhoneImpl {
    String getName();

    int getWeight();

    float getDiagonal();

    int getMemory();

    boolean isCamera();

    void setName(String name);

    void setWeight(int weight);

    void setDiagonal(float diagonal);

    void setMemory(int memory);

    void setCamera(boolean camera);
}
