package org.cpueng.se2122.polymorhism;

public class UserCharacter {
    private Vehicle vehicle;
    private int defaultRunningSpeed = 10;
    private int currentSpeed = 0;

    public void enterVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void exitVehicle() {
        vehicle = null;
    }

    public boolean isInsideVehicle() {
        return (vehicle !=null);
    }

    public void moveForward() {
        if (isInsideVehicle()) {
            vehicle.accelerate();
            currentSpeed = vehicle.getForwardSpeed();
        } else {
            currentSpeed = defaultRunningSpeed;
        }
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }
}
