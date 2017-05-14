package ru.kimdo;

import java.io.IOException;

class Painter {

    int length = 40;
    int height = 40;

    public Painter (int length, int height){
        this.length = length;
        this.height = height;
    }

    void paint(Cell[][] cells){

// 		String command = (isWindows) ? "cls" : "clear";
// 		Runtime.getRuntime().exec(command);


 		Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("clear");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for(int q = 0; q < 100; q++)
//            System.out.println();

        for (int i = 0; i < length; i++){
            for (int j = 0; j < height; j++) {
                if (cells[i][j].getConsist()) {
                    System.out.print("0");
                } else System.out.print(" ");
            }
            System.out.println();
            }
        }

    void setFild(){

    }

    int getFildX(){
         return length;
    }

    int getFildY(){
        return height;
    }
    }