package org.cpueng.se2122;

public class Car {
    
    // In Java, attributes are "Instance-level" variables that belong to a non-Main class.

    public static final String ALL_BRAND = "NO NAME BRAND";

    // a public constant attribute
    public String BRAND = "Honda";

    // a public attribute 
    public String carPublicAttribute;

    // a protected attribute
    protected String youCanInheritMe;

    // a default or package level attribute.
    String carPackageAttribute;

    // When an attribute has "static" in it, then it's no longer a valid definition of an attribute.  It is
    // now considered a "class-level variable"
    // these variables can be accessed without instantiating a class into object.
    public static String iAmAClassVariable = "class-level variable";
    
    // private attributes
    private String name;
    private String modelId;
    private String colour;
    private String type;
    private float maxSpeed;
    private float fuelCapacity;

    // No args (or params) constructor
    public Car() {
    }

    // Constructor with args (or params)
    public Car(String name, String modelId, String colour, String type, float maxSpeed, float fuelCapacity) {
        setName(name);
        setModelId(modelId);
        setColour(colour);
        setType(type);
        setMaxSpeed(maxSpeed);
        setFuelCapacity(fuelCapacity);
    }

    // Operation (or "method" or "behaviour", is a public or protected function that's part of a non-main class)
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void accelerate(int pedalPressure) {
        // This operation is too large, so we break it down using "functions".
        injectFuel(pedalPressure);
        increaseEngineRevolution();
    }

    // A behaviour that can be inherited by subclasses.
    protected void activateLowFuelWarning() {

    }

    // A normal function (a private "behaviour" or "method" or "operation").  We call this a "function" because 
    // "private operations" are usually used to breakdown a large non-private operation.  For example, if a 
    // non-private operation body is too large, then we break it apart into smaller functions.
    private void injectFuel(int pedalPressure) {
        //
    }

    // Another normal function.
    private void increaseEngineRevolution() {
        
    }
}
