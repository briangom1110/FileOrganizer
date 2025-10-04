package com.hackuta7;

public class UIManager{
    private MenuPrinter menuprinter = new MenuPrinter();
    private CLIHandler cliHandler = new CLIHandler();

    public void startUI(){
        boolean running = true;
        while (running){
            menuprinter.printMainMenu();
            String choice = cliHandler.getUserInput();
            
            switch (choice){
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
    private void organizeFilesOption(){
        System.out.println("\nChoose your sorting options:");
        System.out.println("1. Alphabetical order");
        System.out.println("2. By Size");
        System.out.println("3. By date");
        System.out.println("4. By File type");
    
        String sortChoice=cliHandler.getUserInput();

        switch (sortChoice){
            case "1":
                System.out.println("Sorting alphabetically");
                break;
            case "2":
                System.out.println("Sorting by size");
                break;
            case "3":
                System.out.println("Sorting by date");
                break;
            case "4":
                System.out.println("Sorting by filetype");
                break;
            default:
                System.out.println("Invalid. Returning to main menu");
                break;
        }
    }
}
