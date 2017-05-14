package ru.kimdo;

import java.util.Scanner;

public class Master {

    public static void main (String[] args){

//        System.out.print("Какой величины область? Введите сторону квадрата (10-180): ");
//        Scanner scanner = new Scanner(System.in);
//        int square = scanner.nextInt();
//
//        System.out.print("Введите паузу в милисекундах 1-2000: ");
//        int interrupt = scanner.nextInt();

        int length = 180;
        int height = 180;

        Painter painter = new Painter(length, height);
        Cell[][] cells = new Cell[painter.getFildX()][painter.getFildY()];

        for (int i = 0; i < painter.getFildX(); i++){
            for (int j = 0; j < painter.getFildY(); j++){
                cells[i][j] = new Cell();
                cells[i][j].setAddress(i,j);
                cells[i][j].randomConsist();
            }
        }

        while (true){
            painter.paint(cells);
            for (int i = 0; i < painter.getFildX(); i++){
                for (int j = 0; j < painter.getFildY(); j++){
                    cells[i][j].renewConsist(cells);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}