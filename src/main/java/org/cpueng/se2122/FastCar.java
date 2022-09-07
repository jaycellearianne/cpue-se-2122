package org.cpueng.se2122;

public class FastCar extends Car {

    private String brand = new Car().ALL_BRAND;

    public FastCar() {
        Car myCar = new Car();
        brand = myCar.ALL_BRAND;

        String myInheritance = youCanInheritMe;
    }
}
