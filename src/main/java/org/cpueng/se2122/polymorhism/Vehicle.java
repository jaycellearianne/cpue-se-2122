package org.cpueng.se2122.polymorhism;

public abstract class Vehicle {
    private int currentSpeed = 0;
    private int damage = 0;

    public void accelerate() {
        if (isOperational()) {
            currentSpeed++;
        }
    }

    public int getForwardSpeed() {
        if (isOperational()) {
            return currentSpeed;
        }
        
        return 0;
    }

    public void increaseDamage() {
        damage++;
    }

    private boolean isOperational() {
        if (damage >= 100) {
            return false;
        }

        return true;
    }
}
