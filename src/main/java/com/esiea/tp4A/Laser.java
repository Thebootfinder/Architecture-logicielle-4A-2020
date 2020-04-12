package com.esiea.tp4A;

import com.esiea.tp4A.domain.Direction;
import static com.esiea.tp4A.domain.Direction.*;

import static com.esiea.tp4A.domain.Direction.*;

public class Laser {
    private final Mars mars;
    private int range;

    public Laser(Mars mars, int range) {
        this.mars = mars;
        this.range = range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void shot(Direction direction, Moving pos) {
        switch(direction) {
            case NORTH: shotNorth(pos); break;
            case SOUTH: shotSouth(pos); break;
            case EAST: shotEast(pos); break;
            case WEST: shotWest(pos); break;
            default: break;
        }
    }

    private void shotNorth(Moving pos) {
        PositionPoint point = new PositionPoint(pos.getX(), pos.getY(), mars);
        for(int i = 0; i < this.range; i++) {
            if(!(point.checkNextPositionY(NORTH))) {
                this.mars.destroyObstacle(point.getX(), point.getY_Forward());
            }
        }
    }

    private void shotSouth(Moving pos) {
        PositionPoint point = new PositionPoint(pos.getX(), pos.getY(), mars);
        for(int i = 0; i < this.range; i++) {
            if(!(point.checkNextPositionY(SOUTH))) {
                this.mars.destroyObstacle(point.getX(), point.getY_Back());
            }
        }
    }

    private void shotEast(Moving pos) {
        PositionPoint point = new PositionPoint(pos.getX(), pos.getY(), mars);
        for(int i = 0; i < this.range; i++) {
            if(!(point.checkNextPositionX(EAST))) {
                this.mars.destroyObstacle(point.getX_Forward(), point.getY());
            }
        }
    }

    private void shotWest(Moving pos) {
        PositionPoint point = new PositionPoint(pos.getX(), pos.getY(), mars);
        for(int i = 0; i < this.range; i++) {
            if(!(point.checkNextPositionX(WEST))) {
                this.mars.destroyObstacle(point.getX_Back(), point.getY());
            }
        }
    }
}
