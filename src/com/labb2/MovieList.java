package com.labb2;

import java.util.ArrayList;

public class MovieList {
    private ArrayList<Movie> myMovies;
    private ArrayList<Movie> myFavorites;

    public MovieList() {
        this.myMovies = new ArrayList<>();
        this.myFavorites = new ArrayList<>();
    }

    // Metod för att lägga till en ny film som samtidigt kollar att den inte redan finns
    public boolean addNewMovie(Movie movie) {
        if (findMovie(movie.getTitle()) >= 0) {
            return false;
        }
        myMovies.add(movie);
        return true;
    }

    // Metod för att lägga till en ny favorit
    public void addNewFavorite(Movie movie) {
        myFavorites.add(movie);
    }

    // Metod som skriver ut filmlistan
    public void showMovies() {
        System.out.println("Mina filmer:");
        for (int i = 0; i < myMovies.size(); i++) {
            System.out.println("\n" + (i + 1) + ". " + myMovies.get(i).getTitle() +
                    "\nRegissör: " + myMovies.get(i).getDirector() + " | " +
                    "Genre: " + myMovies.get(i).getGenre() + " | " +
                    "År: " + myMovies.get(i).getYear() + " | " +
                    "Längd: " + myMovies.get(i).getDuration() + " min | " +
                    "Betyg: " + myMovies.get(i).getRating());
        }
    }

    // Metod som skriver ut favoritlistan
    public void showFavorites() {
        System.out.println("Mina favoriter: " + myFavorites.size());
        for (int i = 0; i < myFavorites.size(); i++) {
            System.out.println("\n" + (i + 1) + ". " + myFavorites.get(i).getTitle() +
                    "\nRegissör: " + myFavorites.get(i).getDirector() + " | " +
                    "Genre: " + myFavorites.get(i).getGenre() + " | " +
                    "År: " + myFavorites.get(i).getYear() + " | " +
                    "Längd: " + myFavorites.get(i).getDuration() + " min | " +
                    "Betyg: " + myFavorites.get(i).getRating());
        }
    }

    // Metod som söker efter en film i myMovies genom att ange filmens titel
    private int findMovie(String movieTitle) {
        for (int i = 0; i < myMovies.size(); i++) {
            Movie movie = myMovies.get(i);
            if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                return i; // returnerar index
            }
        }
        return -1;
    }

    // Metod som söker efter en film i myMovies och returnerar ett Movie-objekt för specifik position
    public Movie queryMovie(String movieTitle) {
        int position = findMovie(movieTitle); // Anropar findMovie
        if (position >= 0) {
            return myMovies.get(position);
        }
        return null;
    }
}





  