package com.example;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by boris on 11.08.16.
 */
public class FileWorker {
    private BufferedReader br;
    private Point dims = new Point(0, 0); // X - for rows, Y - for columns;
    private final String ONETWOTRIP = "onetwotrip";
    private String names[];
    private char[] letters;
    private Point[] indices;
    private Scanner scanner;

    public FileWorker(String filePath) {
        try {
            br = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        init();

    }

    public void searchInFile() {
        extractDims();
        findRequiredLetters();
        int i;
        for (i = 0; i < indices.length; i++)
            if (indices[i].x == -1 || indices[i].y == -1) {
                System.out.println("Imposible");
                return;
            }
        for (i = 0; i < letters.length; i++)
            System.out.println(letters[i] + " - (" + indices[i].x + "," + indices[i].y + ")");

    }

    private void extractDims() {

        String[] dimsInString = scanner.nextLine().split(" ");

        dims.x = Integer.parseInt(dimsInString[0]);
        dims.y = Integer.parseInt(dimsInString[1]);
    }

    private void init() {
        scanner = new Scanner(br);
        indices = new Point[ONETWOTRIP.length()];
        letters = new char[ONETWOTRIP.length()];

        for (int i = 0; i < indices.length; i++)
            indices[i] = new Point(-1, -1);

    }

    private void findRequiredLetters() {
        names = new String[dims.x];

        for (int i = 0; i < dims.x; i++) {
            names[i] = scanner.nextLine().toLowerCase();
            for (int j = 0; j < names[i].length(); j++)
                for (int k = 0; k < ONETWOTRIP.length(); k++)
                    if (indices[k].getX() == -1 && names[i].charAt(j) == ONETWOTRIP.charAt(k)) {
                        indices[k].setLocation(i, j);
                        letters[k] = names[i].charAt(j);
                    }
        }
    }


}
