package org.cpueng.se2122;

/*
 * Create a robot class with the following properties:
 * - name
 * - model number
 * - type
 * - walk speed
 * - jump height
 * - weaponized (true or false)
 * - health
 * 
 * and with the following behaviour:
 * - walk
 * - selectTarget
 * - talk
 * - jump
 * - announce model number
 */

public class Robot {
    private String name;
    private String modelNumber;
    private String type;
    private int walkSpeed;
    private int jumpHeight;
    private boolean weaponized;
    private int health;

    public Robot() {

    }

    public Robot(String name, String modelNumber, String type) {
        
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setWalkSpeed(int walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public int getWalkSpeed() {
        return walkSpeed;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setIsWeaponized(boolean weaponized) {
        this.weaponized = weaponized;
    }

    public boolean isWeaponized() {
        return weaponized;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void walk() {

    }

    public void selectTarget(int x, int y) {

    }

    public void talk(String message) {

    }

    public void jump() {

    }

    public void announceModelNumber() {

    }
}
