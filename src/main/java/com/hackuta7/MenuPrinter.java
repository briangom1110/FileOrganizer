package com.hackuta7;

public class MenuPrinter{
    public void printMainMenu(){
        System.out.println("\n===File Organizer Menu===");
        System.out.println("1. Organize Files");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
    }
    public void printSortingMenu(){
        System.out.println("\nChoose your sorting options:");
        System.out.println("1. Alphabetical order");
        System.out.println("2. By Size");
        System.out.println("3. By date");
        System.out.println("4. By File type");
        System.out.print("Enter your choice: ");
    }
}