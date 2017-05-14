package ru.kimdo;

import java.util.Random;

class Cell {
    private	int i;
    private	int j;
    private	boolean consistensSelf;

    boolean getConsist(){
        return consistensSelf;
    }

    void renewConsist(Cell[][] cells){
        //Основные правила клеточного автомата
        //int myInt = (myBoolean) ? 1 : 0;
        int u = 0, l = 0, r = 0, d = 0;
        if (i == 0 && j == 0) {
            r = (cells[i + 1][j].getConsist()) ? 1 : 0;
            d = (cells[i][j + 1].getConsist()) ? 1 : 0;
        } else if (i == 0 && j != cells[j].length - 1) {
            u = (cells[i][j - 1].getConsist()) ? 1 : 0;
            r = (cells[i + 1][j].getConsist()) ? 1 : 0;
            d = (cells[i][j + 1].getConsist()) ? 1 : 0;
        } else if (i == 0 && j == cells[j].length - 1) {
            u = (cells[i][j - 1].getConsist()) ? 1 : 0;
            r = (cells[i + 1][j].getConsist()) ? 1 : 0;
        } else if (i != cells[i].length - 1 && j == 0) {
            l = (cells[i - 1][j].getConsist()) ? 1 : 0;
            r = (cells[i + 1][j].getConsist()) ? 1 : 0;
            d = (cells[i][j + 1].getConsist()) ? 1 : 0;
        } else if (i != cells[i].length - 1 && j == cells[j].length - 1) {
            u = (cells[i][j - 1].getConsist()) ? 1 : 0;
            l = (cells[i - 1][j].getConsist()) ? 1 : 0;
            r = (cells[i + 1][j].getConsist()) ? 1 : 0;
        } else if (i == cells[i].length - 1 && j == 0) {
            l = (cells[i - 1][j].getConsist()) ? 1 : 0;
            d = (cells[i][j + 1].getConsist()) ? 1 : 0;
        } else if (i == cells[i].length - 1 && j != cells[j].length - 1) {
            u = (cells[i][j - 1].getConsist()) ? 1 : 0;
            l = (cells[i - 1][j].getConsist()) ? 1 : 0;
            d = (cells[i][j + 1].getConsist()) ? 1 : 0;
        } else if (i == cells[i].length - 1 && j == cells[j].length - 1) {
            u = (cells[i][j - 1].getConsist()) ? 1 : 0;
            l = (cells[i - 1][j].getConsist()) ? 1 : 0;
        } else {
            u = (cells[i][j - 1].getConsist()) ? 1 : 0;
            l = (cells[i - 1][j].getConsist()) ? 1 : 0;
            r = (cells[i + 1][j].getConsist()) ? 1 : 0;
            d = (cells[i][j + 1].getConsist()) ? 1 : 0;
        }
        int status = u + l + r + d;

        if (this.consistensSelf){
            switch (status){
                case 0:
                case 1:
                case 4:
                    this.consistensSelf = false;
                    break;
                case 2:
                case 3:
                    break;
            }
        } else {
            if (status == 3) this.consistensSelf = true;
        }
    }

    void setAddress(int i, int j){
        this.i = i;
        this.j = j;
    }

    void randomConsist(){
        Random random = new Random();
        int x = random.nextInt(2);
        switch (x){
            case 0:
                this.consistensSelf = false;
                break;
            case 1:
                this.consistensSelf = true;
                break;
        }

    }
}