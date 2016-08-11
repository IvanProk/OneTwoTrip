package com.example;

import java.util.Random;

/**
 * Created by boris on 11.08.16.
 */
public class SpiralPrinter {
    private int size;

    public SpiralPrinter(int n) {
        size = 2 * n - 1;
    }

    public void print() {
        int[][] array = initRandomArray(size);
        System.out.println("Initial array");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.format(" %2d", array[i][j]);
            System.out.print("\n");
        }

        System.out.println("Spiral printed");
        spiralPrint(array);
    }

    private int[][] initRandomArray(int n) {
        Random rand = new Random();
        int[][] array = new int[2 * n - 1][2 * n - 1];
        for (int i = 0; i < 2 * n - 1; i++)
            for (int j = 0; j < 2 * n - 1; j++) {
                array[i][j] = rand.nextInt(100);
            }
        return array;
    }

    private void spiralPrint(int[][] array) {
        int levl;
        int c = size/2;
        int x,y;
        x = y = c;
        for (levl = 1; c+levl <= size; levl++) {

            for(; y>=c-levl && y >= 0; y--)     // go left
                System.out.format(" %2d",array[x][y] );
            if(x == 0 && y <=0)
                break;

            for(x++,y++; x<=c+levl && x < size; x++)  // go down
                System.out.format(" %2d", array[x][y] );
            for(x--,y++; y<=c+levl ; y++)        // go right
                System.out.format(" %2d", array[x][y]);
            for(x--,y--; x>=c-levl ;x--)     // go up
                System.out.format(" %2d",array[x][y] );
            x++;
            y--;

        }
    }

}