package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaintBottleService {
    private final List<PaintBottles> orderedBottles;

    public PaintBottleService() {
        this.orderedBottles = PaintBottles.getBottlesOrdered();
    }
    public PaintBottleService(List<PaintBottles> orderedBottles) {
        this.orderedBottles = PaintBottles.getBottlesOrdered();
    }

    public Map<PaintBottles, Integer> calculateBottleAmount(double litersAmount) {
        Map<PaintBottles, Integer> litersAmountNeeded = new HashMap<>();

        for (PaintBottles bottle : orderedBottles) {
            if (litersAmount >= bottle.getLiters()) {
                int num = (int) (litersAmount / bottle.getLiters());
                litersAmount -= num * bottle.getLiters();
                litersAmountNeeded.put(bottle, num);
            }
        }

        if (litersAmount > 0) {
            Integer quantity = litersAmountNeeded.get(PaintBottles.TINY);
            litersAmountNeeded.put(PaintBottles.TINY, quantity != null ? quantity + 1 : 1);
        }

        return litersAmountNeeded;
    }

    public void printAmount(Map<PaintBottles, Integer> litersAmountNeeded) {
        orderedBottles.forEach((bottle) -> {
            Integer quantity = litersAmountNeeded.get(bottle);
            if (quantity != null) {
                System.out.println("Lata de " + bottle.getLiters() + "l: " + quantity);
            }
        });
    }
}
