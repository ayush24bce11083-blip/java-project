
package models;

public class Book {
    private String title;
    private String author;
    private int year;
    private String genre;

    public Book(String t, String a, int y, String g) {
        this.title = t;
        this.author = a;
        this.year = y;
        this.genre = g;
    }

    public void update(String t, String a, int y, String g) {
        this.title = t;
        this.author = a;
        this.year = y;
        this.genre = g;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public String getGenre() { return genre; }

    public String toFileString() {
        return title + "||" + author + "||" + year + "||" + genre;
    }

    public static Book fromFileString(String data) {
        String[] p = data.split("\\|\\|");
        if (p.length < 4) return null;
        return new Book(p[0], p[1], Integer.parseInt(p[2]), p[3]);
    }

    @Override
    public String toString() {
        return title + " | " + author + " | " + year + " | " + genre;
    }
}
