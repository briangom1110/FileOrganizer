package com.hackuta7;

import java.util.ArrayList;
import java.util.Scanner;

import com.hackuta7.logic.*;;

public class UIManager {
    private MenuPrinter menuprinter;
    //    private CLIHandler cliHandler;
    private Scanner scanner;
    private CheckFolder checkFolder;
    private FileOrganizer fileOrganizer;

    public UIManager() throws Exception {
//        this.cliHandler = new CLIHandler();
        this.menuprinter = new MenuPrinter();
        this.scanner = new Scanner(System.in);
        this.fileOrganizer = new FileOrganizer();
        this.checkFolder = new CheckFolder();
    }

    public void startUI() throws Exception {
        boolean running = true;


        while (running) {
            System.out.println("Enter file path");

            String input = scanner.nextLine();
            if ((checkFolder.validPathDirectory(input))) {
                this.fileOrganizer.folderItems(input);
            }else{
                System.out.println("Invalid directory. Input the path to the directory (pwd).");
                continue;
            }

            menuprinter.printMainMenu();
//            String choice = cliHandler.reader();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    organizeFilesOption();
                    break;
                case "2":
                    System.out.println("Exiting the menu...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again");
                    break;
            }
        }
    }

    //Sorting Options
    private void organizeFilesOption() throws Exception {
        System.out.println("\nChoose your sorting options:");
        System.out.println("1. Alphabetical order");
        System.out.println("2. By Size");
        System.out.println("3. By date");
        System.out.println("4. By File type");

//        String sortChoice=cliHandler.reader();
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                System.out.println("Sorting alphabetically");
                this.fileOrganizer.sortByNameInPlace();
                this.fileOrganizer.printFileContent();
                break;
            case "2":
                System.out.println("Sorting by size");
                this.fileOrganizer.sortByFileSizeInPlace();
                this.fileOrganizer.printFileContent();
                break;
            case "3":
                System.out.println("Sorting by filetype");
                this.fileOrganizer.sortByFileTypeInPlace();
                this.fileOrganizer.printFileContent();
                break;
            default:
                System.out.println("Invalid. Returning to main menu");
                break;
        }
    }
}
