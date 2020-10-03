package com.labb2;

import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static MovieList myMovies = new MovieList();
    private static MovieList myFavorites = new MovieList();

    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("Välkommen!");
        printOptions();

        // While-loopen körs så länge användaren inte väljer att avsluta programmet
        while (!exit) {
            System.out.println("\nVälj (Tryck 5 för att visa val): ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    myMovies.showMovies();
                    break;
                case 2:
                    addNewMovie();
                    break;
                case 3:
                    myFavorites.showFavorites();
                    break;
                case 4:
                    addNewFavorite();
                    break;
                case 5:
                    printOptions();
                    break;
                case 6:
                    System.out.println("Stänger av...");
                    exit = true;
                    break;
            }
        }
    }

    // Metod som låter användaren lägga till en ny film i filmlistan. Användarens input tas in med en scanner.
    private static void addNewMovie() {
        System.out.print("Skriv in filmens titel: ");
        String title = input.nextLine();
        System.out.print("Skriv in filmens speltid (min): ");
        int duration = input.nextInt();
        input.nextLine();
        System.out.print("Skriv in regissörens namn: ");
        String director = input.nextLine();
        System.out.print("Skriv in filmens genre: ");
        String genre = input.nextLine();
        System.out.print("Skriv in filmens produktionsår: ");
        String year = input.nextLine();
        System.out.print("Skriv in filmens betyg (1-5): ");
        double rating = input.nextDouble();
        Movie newMovie = new Movie(title, duration, director, genre, year, rating);
        if(myMovies.addNewMovie(newMovie)) {
            System.out.println("\nNy film tillagd: " + title);
        } else {
            System.out.println("\nKan inte lägga till, " + title + " finns redan.");
        }
    }

    // Metod som låter användaren lägga till en ny film i favoritlistan
    private static void addNewFavorite() {
        if(Movie.getMovieCount() >= 1) {
            myMovies.showMovies();
            System.out.print("\nSkriv in titeln på filmen du vill lägga till som favorit: ");
            String movieTitle = input.nextLine();
            Movie existingMovieRecord = myMovies.queryMovie(movieTitle);
            if(existingMovieRecord == null) {
                System.out.println("Kan inte hitta filmen.");
            } else {
                myFavorites.addNewFavorite(existingMovieRecord);
                System.out.println(existingMovieRecord.getTitle() + " har gjorts till favorit.");
            }
        } else {
            System.out.println("Inga filmer hittades.");
        }
    }

    // Metod som skriver ut huvudmenyn
    private static void printOptions() {
        System.out.println("\n1. Visa filmlista" +
                "\n2. Lägg till ny film" +
                "\n3. Visa favoriter" +
                "\n4. Lägg till i favoriter" +
                "\n5. Visa alternativ" +
                "\n6. Stäng av");
    }
}

