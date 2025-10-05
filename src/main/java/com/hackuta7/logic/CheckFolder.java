package com.hackuta7.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class CheckFolder {

    // This makes sure the path considered is both a valid path and a valid directory
    public boolean validPathDirectory(String path){
        File folder = new File(path);
        if(folder.exists() && folder.isDirectory()){
            return true;
        }
        return false;
    }





}
