
package services;

import models.Book;
import java.util.*;

public class BookManager {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book b){ books.add(b); }

    public void displayBooks(){
        if(books.isEmpty()){
            System.out.println("No books available.");
            return;
        }
        for(Book b : books) System.out.println(b);
    }

    public void editBook(String title, Scanner sc){
        for(Book b : books){
            if(b.getTitle().equalsIgnoreCase(title)){
                System.out.print("New Title: ");
                String nt = sc.nextLine();
                System.out.print("New Author: ");
                String na = sc.nextLine();
                System.out.print("New Genre: ");
                String ng = sc.nextLine();
                System.out.print("New Year: ");
                int ny = sc.nextInt();
                sc.nextLine();
                b.update(nt, na, ng, ny);
                System.out.println("Book updated.");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void deleteBook(String title){
        Iterator<Book> it = books.iterator();
        while(it.hasNext()){
            if(it.next().getTitle().equalsIgnoreCase(title)){
                it.remove();
                System.out.println("Book deleted!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void searchBooks(String keyword){
        boolean found = false;
        for(Book b : books){
            if(b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
               b.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
               b.getGenre().toLowerCase().contains(keyword.toLowerCase())){
                System.out.println(b);
                found = true;
            }
        }
        if(!found) System.out.println("No matching books.");
    }

    public void sortMenu(Scanner sc){
        System.out.println("Sort by: 1) Title 2) Author 3) Genre 4) Year");
        int c = sc.nextInt(); sc.nextLine();
        switch(c){
            case 1:
                books.sort(Comparator.comparing(Book::getTitle));
                break;
            case 2:
                books.sort(Comparator.comparing(Book::getAuthor));
                break;
            case 3:
                books.sort(Comparator.comparing(Book::getGenre));
                break;
            case 4:
                books.sort(Comparator.comparingInt(Book::getYear));
                break;
            default:
                System.out.println("Invalid choice.");
        }
        System.out.println("Sorted successfully.");
        displayBooks();
    }

    public ArrayList<Book> getBooks(){ return books; }
}
