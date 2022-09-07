package org.cpueng.se2122.polymorhism;

public class NormalKeyboard implements UserActions {
    private UserCharacter userCharacter;

    public NormalKeyboard() {
        
    }

    public NormalKeyboard(UserCharacter userCharacter) {
        setUserCharacter(userCharacter);
    }

    @Override
    public void setUserCharacter(UserCharacter userCharacter) {
        this.userCharacter = userCharacter;
    }

    @Override
    public void useVehicle(Vehicle vehicle) {
        // do something here before entering vehicle

        // entering vehicle
        userCharacter.enterVehicle(vehicle);
    }

    @Override
    public void exitVehicle() {
        // do something here before exiting vehicle

        // exiting vehicle
        userCharacter.exitVehicle();
    }

    @Override
    public void moveForward() {
        userCharacter.moveForward();
    }

    @Override
    public void moveBackward() {
        // TODO Auto-generated method stub
    }
}
