package com.esiea.tp4A;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.esiea.tp4A.domain.PlanetMap;
import com.esiea.tp4A.domain.Position;

public class Mars implements PlanetMap {

    private Map Coord;
    private Set<Position> obstacles = new HashSet<>();
    private Set<Rover> roverss = new HashSet<>();

    public Mars(int SizeMap) {
        Coord = new Map(SizeMap/2, (((SizeMap/2) - 1)*-1), SizeMap/2, (((SizeMap/2) - 1)*-1));
    }
    
    @Override
    public Set<Position> obstaclePositions() {
        // TODO Auto-generated method stub
        return null;
    }

    public void generationObstacles(int numb){
        if (numb >= 0) {
           /* while(obstacles.size() !=numb){
                Position obstacle = CreationRandomObstacle();
                obstacles.add(obstacle);
            }*/
        }
    }


    public boolean checkIfObstacle(int x, int y) {
        return Stream.concat(roverss.stream().map(Rover::getPosition),
            obstacles.stream())
            .anyMatch(p -> p.getX() == x && p.getY() == y);
    }

    public void destroyObstacle(int x, int y) {
        obstacles.removeIf(position -> position.getX() == x && position.getY() == y);
        roverss.removeIf(rover -> rover.getPosition().getX() == x && rover.getPosition().getY() == y);
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
