package com.esiea.tp4A;

import com.esiea.tp4A.domain.*;

public class Rover implements MarsRover {
	
<<<<<<< HEAD
	final Moving moving;
	final private Mars mars;
	final private Laser laser;
=======
    private Moving moving;
    private Mars mars;
>>>>>>> master

    public Rover(Moving moving, Mars mars) {
        this.moving = moving;
        this.mars = mars;
<<<<<<< HEAD
        this.laser = new Laser(mars,1);
        /* default range = 1, une fonction doit pouvoir la modifier */
=======
>>>>>>> master
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
