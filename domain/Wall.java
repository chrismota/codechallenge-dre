package domain;

public class Wall {
    private final double width;
    private final double height;
    private final int windowAmount;
    private final int doorAmount;
    public Wall(double width, double height, int windowAmount, int doorAmount) {
        this.width = width;
        this.height = height;
        this.windowAmount = windowAmount;
        this.doorAmount = doorAmount;
    }

    public void validate(){
        checkWallHeight();
        checkWallArea();
    }

    public void checkWallHeight() {
        if (this.doorAmount > 0) {
            if (this.height < 2.20) {
                throw new IllegalStateException("Altura da parede precisa ser 30cm maior que altura da porta");
            }
        }
    }

    public void checkWallArea() {
        double wallArea = getWallArea();
        if (wallArea < 1 || wallArea > 50) {
            throw new IllegalStateException("Área da parede precisa ser entre 1 até 50 metros quadrados.");
        }
    }

    public double getWallArea() {
        return width * height;
    }

    public double calculateRemovableArea(){
        double windowArea = windowAmount * (2.00 * 1.20);
        double doorArea = doorAmount * (0.80 * 1.90);
        return windowArea + doorArea;
    }

    public double calculatePaintableArea(double wallArea, double removableArea) {
        return wallArea - removableArea;
    }

}