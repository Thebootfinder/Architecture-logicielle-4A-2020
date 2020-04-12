package com.esiea.tp4A;

import java.util.HashSet;
import java.util.Set;


import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.PlanetMap;
import com.esiea.tp4A.domain.Position;

public class Mars implements PlanetMap {

    private Map Coord;
    private Set<Position> obstacles = new HashSet<>();
    private Set<Rover> roverss = new HashSet<>();
    private boolean check;

    public Mars(int SizeMap) {
        Coord = new Map(SizeMap/2, (((SizeMap/2) - 1)*-1), SizeMap/2, (((SizeMap/2) - 1)*-1));
    }
    
    @Override
    public Set<Position> obstaclePositions() {
        return null;
    }

    public void geneObstacles(int numberofObstacle){
        Init init = new Init();
        PositionPoint point;
        if (numberofObstacle >= 0) {
            while(obstacles.size() <= numberofObstacle){
                do {
                    point = new PositionPoint(init.getRint(Coord.getMaxX(), Coord.getMinX()), init.getRint(Coord.getMaxY(), Coord.getMinY()),this);
                    Position obstacle = new Position.FixedPosition(point.getX(),point.getY(), Direction.NORTH);
                    this.check = obstacles.add(obstacle);
                } while(!check);
            }
        }
    }

    public void destroyObstacle(int x, int y) {
        obstacles.removeIf(position -> position.getX() == x && position.getY() == y);
        roverss.removeIf(rover -> rover.getPosition().getX() == x && rover.getPosition().getY() == y);
    }

    public boolean IsObstacleThere(int x, int y) {
        return Stream.concat(roverss.stream().map(Rover::getPosition),
            obstacles.stream())
            .anyMatch(p -> p.getX() == x && p.getY() == y);
    }

    public Map getCoordinates() {
        return Coord;
    }

    public void setObstacles(Set<Position> obstacles) {
        this.obstacles = obstacles;
    }

    public boolean addRov(Rover rover) {
        return roverss.add(rover);
    }

        
}
