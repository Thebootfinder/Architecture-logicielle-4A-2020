package com.esiea.tp4A;

import com.esiea.tp4A.domain.Direction;

public class Laser {
    private final Mars mars;
    private int range;

    public Laser(Mars mars, int range) {
        this.mars = mars;
        this.range = range;
    }

    public void shot(Direction dir, Moving pos) {
        switch(dir) {
            case NORTH: shotNorth(pos); break;
            case SOUTH: shotSouth(pos); break;
            case EAST: shotEast(pos); break;
            case WEST: shotNorth(pos); break;
            default: break;
        }
    }

    private void shotNorth(Moving pos) {
        PositionPoint point = new PositionPoint(pos.getX(), pos.getY(), mars);
        for(int i = 0; i < this.range; i++) {
            /* détection d'obstacle */
            /* destruction d'obstacle si détecté */
        }
    }

    private void shotSouth(Moving pos) {
        PositionPoint point = new PositionPoint(pos.getX(), pos.getY(), mars);
        for(int i = 0; i < this.range; i++) {
            /* détection d'obstacle */
            /* destruction d'obstacle si détecté */
        }
    }

    private void shotEast(Moving pos) {
        PositionPoint point = new PositionPoint(pos.getX(), pos.getY(), mars);
        for(int i = 0; i < this.range; i++) {
            /* détection d'obstacle */
            /* destruction d'obstacle si détecté */
        }
    }

    private void shotWest(Moving pos) {
        PositionPoint point = new PositionPoint(pos.getX(), pos.getY(), mars);
        for(int i = 0; i < this.range; i++) {
            /* détection d'obstacle */
            /* destruction d'obstacle si détecté */
        }
    }
}
