package org.cpueng.se2122.polymorhism;

public class MyGame {

    private UserActions controller;
    private Player myPlayer;

    public void initializeGame(String controllerType) {
        if (controllerType.equals("Advanced")) {
            controller = new AdvancedGamerKeyboard();

        } else if (controllerType.equals("Basic")) {
            controller = new NormalKeyboard();

        }

        myPlayer = new Player();
        myPlayer.giveUserActionsController(controller);
    }
}
