package com.softplan.challenge.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServerLogUtil {

    public static String readLine(long offset, String file) {
        String strLine = null;
        DataInputStream in = null;
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(new File(file));

            // Get the object of DataInputStream
            in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            br.skip(offset);
            strLine = br.readLine();
        } catch (Exception e) {// Catch exception if any
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strLine;
    }
}
