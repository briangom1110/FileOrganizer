package com.hackuta7.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class FileOrganizer {
    private List<File> content;
    private CheckFolder checkFolder;

    public FileOrganizer() {
        this.content = new ArrayList<>();
    }

    public List<File> folderItems(String path) {
        File files = new File(path);
        File[] list = files.listFiles();

        if (list == null) {
            System.out.println("Empty directory;");
        }

        if (this.content.size() > 0) {
            this.content.clear();
        }

        for (int i = 0; i < list.length; i++) {
            this.content.add(list[i]);
        }
        return content;
    }


    public Stream<File> sortByName() {
        return this.content.stream()
                .sorted((x, y) -> x.getName().compareToIgnoreCase(y.getName()));
    }

    public Stream<File> sortByFileSize() {
        return this.content.stream()
                .sorted(Comparator.comparingLong(File::length));
    }

    public Stream<File> sortByFileType() {
        return this.content.stream()
                .sorted((x, y) -> {
                    String filename1 = x.getName();
                    String filename2 = y.getName();

                    // Getting the postion of the last . for the filetypes
                    // For examples the . in  notes.txt
                    int position1 = filename1.lastIndexOf('.');
                    int position2 = filename1.lastIndexOf('.');

                    // Holds the name of the extension as a string
                    String extension1;
                    String extension2;

                    // if the positon = -1 it means there isn't an extension to the file
                    // it is returning -1 because it is never found.
                    if (position1 == -1) {
                        extension1 = "";
                    } else {
                        // This gets the file name from the position after the dot.
                        // Only getting the txt from .txt is what it is doing (Example).
                        extension1 = filename1.substring(position1 + 1).toLowerCase();
                    }

                    if (position2 == -1) {
                        extension2 = "";
                    } else {
                        extension2 = filename1.substring(position1 + 1).toLowerCase();
                    }
                    // Comparing the types of both extensions
                    return extension1.compareToIgnoreCase(extension2);
                });
    }


}
