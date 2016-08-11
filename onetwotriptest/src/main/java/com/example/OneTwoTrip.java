package com.example;

public class OneTwoTrip {
    public static String FILE_PATH = "input.txt";


    public static void main(String[] args) {

        System.out.println("Exercise 1:");
        FileWorker fworker = new FileWorker(FILE_PATH);
        fworker.searchInFile();

        System.out.println("Exercise 2:");
        SpiralPrinter sprinter = new SpiralPrinter(3);
        sprinter.print();
    }
}


