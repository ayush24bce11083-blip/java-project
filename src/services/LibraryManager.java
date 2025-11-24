
package services;

import models.Book;
import java.util.*;

public class LibraryManager {
    private ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getBooks() { return books; }

    public void addBook(Book b) {
        books.add(b);
        System.out.println("Book added.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : books) System.out.println(b);
    }

    public void editBook(String title, Scanner sc) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.print("New Title: ");
                String nt = sc.nextLine();
                if (nt.isEmpty()) nt = b.getTitle();

                System.out.print("New Author: ");
                String na = sc.nextLine();
                if (na.isEmpty()) na = b.getAuthor();

                System.out.print("New Year: ");
                int ny = sc.nextInt(); sc.nextLine();
                if (ny == 0) ny = b.getYear();

                System.out.print("New Genre: ");
                String ng = sc.nextLine();
                if (ng.isEmpty()) ng = b.getGenre();

                b.update(nt, na, ny, ng);
                System.out.println("Book updated.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void deleteBook(String title) {
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            if (it.next().getTitle().equalsIgnoreCase(title)) {
                it.remove();
                System.out.println("Book deleted.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchBook(String keyword) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("No match found.");
    }

    public void sortMenu(Scanner sc) {
        System.out.println("Sort by: 1) Title 2) Author 3) Year 4) Genre");
        int c = sc.nextInt(); sc.nextLine();

        switch(c) {
            case 1:
                books.sort(Comparator.comparing(Book::getTitle));
                break;
            case 2:
                books.sort(Comparator.comparing(Book::getAuthor));
                break;
            case 3:
                books.sort(Comparator.comparingInt(Book::getYear));
                break;
            case 4:
                books.sort(Comparator.comparing(Book::getGenre));
                break;
            default:
                System.out.println("Invalid.");
                return;
        }
        System.out.println("Sorted.");
        displayBooks();
    }
}
