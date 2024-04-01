package service;

import domain.Wall;

import java.util.List;

public class WallService {

    public double calculatePaintAmount(List<Wall> walls){
        double roomArea = 0;

        for (int i = 0; i < walls.size(); i++) {
            final Wall wall = walls.get(i);
            roomArea += getPaintableArea(wall);
        }

        return calculateAreaToLiters(roomArea);
    }

    private double getPaintableArea(Wall wall) {
        double wallArea = wall.getWallArea();
        double removableArea = wall.calculateRemovableArea();

        validatePaintableArea(wallArea, removableArea);

        return wall.calculatePaintableArea(wallArea, removableArea);
    }

    private void validatePaintableArea(double wallArea, double removableArea) {
        if (removableArea > (wallArea / 2)) {
            throw new IllegalStateException("O total de área das portas e janelas deve ser no máximo 50% da área da parede");
        }
    }

    private double calculateAreaToLiters(double roomArea) {
        return roomArea / 5;
    }
}
