
package services;

import models.Book;
import java.io.*;
import java.util.*;

public class FileHandler {
    public static void saveBooks(ArrayList<Book> books) throws Exception {
        FileWriter fw = new FileWriter("books.txt");
        for (Book b : books) fw.write(b.toFileString() + "\n");
        fw.close();
    }

    public static ArrayList<Book> loadBooks() throws Exception {
        ArrayList<Book> books = new ArrayList<>();
        File f = new File("books.txt");
        if (!f.exists()) return books;

        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            Book b = Book.fromFileString(sc.nextLine());
            if (b != null) books.add(b);
        }
        sc.close();
        return books;
    }
}
