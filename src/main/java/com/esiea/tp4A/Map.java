package com.esiea.tp4A;

public class Map {
    
    private final int MinX;
    private final int MaxX;
    private final int MinY;
    private final int MaxY;
    

    public Map(int MaxX, int MinX, int MaxY, int MinY) {
       
        this.MinX = MinX;
        this.MaxX = MaxX;
        this.MinY = MinY;
        this.MaxY = MaxY;
    }

    public int getMaxX() {
        return MaxX;
    }

    public int getMinX() {
        return MinX;
    }

    public int getMaxY() {
        return MaxY;
    }

    public int getMinY() {
        return MinY;
    }
}