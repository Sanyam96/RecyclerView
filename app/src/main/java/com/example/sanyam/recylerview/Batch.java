package com.example.sanyam.recylerview;

/**
 * Created by sanyam on 22/7/16.
 */
public class Batch {
    String name;
    int strength;

    public Batch(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
