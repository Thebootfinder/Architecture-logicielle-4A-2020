package com.esiea.tp4A;

import com.esiea.tp4A.domain.*;

public class Rover implements MarsRover {

	private Moving moving;
	final private Mars mars;
	final private Laser laser;

    public Rover(Moving moving, Mars mars) {
        this.moving = moving;
        this.mars = mars;
        this.laser = new Laser(mars,10);
        /* default range = 10, une fonction doit pouvoir la modifier */
    }

    @Override
    public Position move(String commands){
        if(!commands.isEmpty()) {
            for (char command : commands.toCharArray()) {
                executeCommand(command);
            }
            return moving;
        } else {
            return Position.of(0, 0, Direction.NORTH);
        }
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

    @Override
    public MarsRover initialize(Position position) {
        PositionPoint point = new PositionPoint(position.getX(), position.getY(), mars);
        moving = new Moving(point, Direction.NORTH);
        return this;
    }
    @Override
    public MarsRover configureLaserRange(int range) {
        laser.setRange(range);
        return this;
    }
}
