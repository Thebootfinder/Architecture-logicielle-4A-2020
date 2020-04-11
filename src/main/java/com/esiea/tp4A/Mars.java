package com.esiea.tp4A;

import java.util.Set;

import com.esiea.tp4A.domain.PlanetMap;
import com.esiea.tp4A.domain.Position;

public class Mars implements PlanetMap {

    private Map Coord;

    public Mars(int SizeMap) {
        Coord = new Map(SizeMap/2, (((SizeMap/2) - 1)*-1), SizeMap/2, (((SizeMap/2) - 1)*-1));
    }

    @Override
    public Set<Position> obstaclePositions() {
        // TODO Auto-generated method stub
        return null;
    }

    public Map getCoordinates() {
        return Coord;
    }

        
        
}