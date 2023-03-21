package com.example.popmental.model;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class GetPathToFile {

    public static void main(String[] args) {
        String path = getPath();        // testcall for the getPath method
        System.out.println("This is the path to Nicolaus: " + path + " ,perhaps.");     // print result of path method
    }
    public static String getPath() {
        //FileFilter csv_filter = new FileNameExtensionFilter("CSV_Files", ".csv", ".CSV");   // theoretical filter for CSV files doesn't work
        JFileChooser chooser = new JFileChooser();      // create new FileChooser instance named chooser
        //chooser.addChoosableFileFilter(csv_filter);       // set filter doesn't work
        int result = chooser.showOpenDialog(null);      // creates new window with choose dialog and returns option chosen
        if (result == JFileChooser.APPROVE_OPTION) {        // compares result if option was approved
            File selectedFile = chooser.getSelectedFile();      // creates File class as selectedFile and sets the file from chooser
            return selectedFile.getAbsolutePath();      // returns absolute path to file as String
        }
        return null;       //if file choose is interrupted the method returns null please intercept
    }
}
