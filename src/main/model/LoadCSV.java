package com.example.popmental.model;

import java.io.*;
import java.io.File;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.function.IntFunction;

import static com.example.popmental.model.GetPathToFile.getPath;

public class LoadCSV {
    static String[][] csv_file_loaded;  // define 2D-Array

    // load CSV file into array by splitting lines by ","
    public static void main(String[] args) throws Exception {
        String path = getPath(); // calls method for dialog window to get path to file and saves it as a String in path
        csv_file_loaded = load_CSV_2_file(path); // loads file into csv_file_loaded calling the load_CSV_2_file

        /*
        // test print whole CSV file line by line as String
        for ( int i = 0; i < csv_file_loaded.length; i ++) {
            String[] arr = csv_file_loaded[i];
            System.out.println(Arrays.toString(arr));
        }
        // test print line 2 columns 0 and 1
        System.out.println(csv_file_loaded[2][0]);
        System.out.println(csv_file_loaded[2][1]);

         */
    }

    public static String[][] load_CSV_2_file(String path) throws Exception{
        try (var br = new BufferedReader(new FileReader(new File(path)))) {
            return br.lines().map(line -> line.split(",")).toArray((IntFunction<String[][]>) String[][]::new);
        }
    }
}
