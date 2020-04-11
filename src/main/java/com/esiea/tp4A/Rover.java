package com.esiea.tp4A;

import com.esiea.tp4A.domain.*;

public class Rover implements MarsRover {
	
    final Moving moving;
    

    public Rover(Moving moving) {
        this.moving = moving;
    }

    @Override
    public Moving move(String commands){
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
        }
    }
}
