package test;

import domain.Wall;
import service.PaintBottleService;
import service.PaintBottles;
import service.WallService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ApplicationTest {
    public static void main(String[] args) {

        List<Wall> walls = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            walls.add(getWall(i));
        }

        WallService wallService = new WallService();
        try {
            double paintInLiters = wallService.calculatePaintAmount(walls);

            PaintBottleService bottleService = new PaintBottleService();
            Map<PaintBottles, Integer> litersAmountNeeded = bottleService.calculateBottleAmount(paintInLiters);
            bottleService.printAmount(litersAmountNeeded);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static Wall getWall(int wallNumber) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(wallNumber + "ª parede:");
            System.out.println("Digite a largura da parede:");
            double wallWidth = sc.nextDouble();
            System.out.println("Digite a altura da parede:");
            double wallHeight = sc.nextDouble();
            System.out.println("Digite a quantidade de janelas:");
            int wallWindowsNumber = sc.nextInt();
            System.out.println("Digite a quantidade de portas:");
            int wallDoorsNumber = sc.nextInt();

            final Wall wall = new Wall(wallWidth, wallHeight, wallWindowsNumber, wallDoorsNumber);

            try {
                wall.validate();
                return wall;
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Digite os parâmetros novamente.");
            }
        }
    }
}
