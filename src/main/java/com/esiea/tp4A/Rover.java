package com.esiea.tp4A;

import com.esiea.tp4A.domain.*;

public class Rover implements MarsRover {
	

	final Moving moving;
	final private Mars mars;
	final private Laser laser;


    public Rover(Moving moving, Mars mars) {
        this.moving = moving;
        this.mars = mars;
        this.laser = new Laser(mars,1);
        /* default range = 1, une fonction doit pouvoir la modifier */

    }

    @Override
    public Position move(String commands){
        for (char command : commands.toCharArray()) {
            executeCommand(command);
        }
        return moving;
    }

    private void executeCommand(char command) {
        switch(command) {
            case 'l': moving.rotateLeft(); break;
            case 'r': moving.rotateRight(); break;
            case 'f': moving.goForward(); break;
            case 'b': moving.goBackward(); break;
            case 's': laser.shot(moving.getDirection(), moving); break;
            default: System.out.println("Not a valid command. Please try again"); break;
        }
    }

    public Moving getPosition() { return moving; }

    public Mars getMars() { return mars; }
}
