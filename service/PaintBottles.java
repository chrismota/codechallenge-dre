package service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum PaintBottles {
    BIG(18.5),
    MEDIUM(3.6),
    SMALL(2.5),
    TINY(0.5);

    private final double liters;

    PaintBottles(double liters) {
        this.liters = liters;
    }
    public double getLiters() {
        return liters;
    }

    public static List<PaintBottles> getBottlesOrdered(){
        return Arrays.stream(PaintBottles.values()).sorted((Comparator.comparingDouble(PaintBottles::getLiters)).reversed()).toList();
    }
}
