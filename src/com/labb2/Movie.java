package com.labb2;

public class Movie extends Video {
    private String director;
    private String genre;
    private String year;
    private double rating;
    private static int movieCount = 0;

    public Movie(String title, int duration, String director, String genre, String year, double rating) {
        super(title, duration);
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        movieCount++; // Ökar med ett varje gång ett Movie-objekt skapas
    }

    public static int getMovieCount() {
        return movieCount;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }
}
