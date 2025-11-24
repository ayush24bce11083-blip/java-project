
import java.util.*;
import services.LibraryManager;
import services.FileHandler;
import models.Book;

public class Main {
    public static void main(String[] args) throws Exception {
        LibraryManager manager = new LibraryManager();
        manager.getBooks().addAll(FileHandler.loadBooks());

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Library Book Manager ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Edit Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Search Book");
            System.out.println("6. Sort Books");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Title: ");
                    String t = sc.nextLine();
                    System.out.print("Author: ");
                    String a = sc.nextLine();
                    System.out.print("Year: ");
                    int y = sc.nextInt(); sc.nextLine();
                    System.out.print("Genre: ");
                    String g = sc.nextLine();
                    manager.addBook(new Book(t, a, y, g));
                    FileHandler.saveBooks(manager.getBooks());
                    break;

                case 2:
                    manager.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter title to edit: ");
                    manager.editBook(sc.nextLine(), sc);
                    FileHandler.saveBooks(manager.getBooks());
                    break;

                case 4:
                    System.out.print("Enter title to delete: ");
                    manager.deleteBook(sc.nextLine());
                    FileHandler.saveBooks(manager.getBooks());
                    break;

                case 5:
                    System.out.print("Enter keyword: ");
                    manager.searchBook(sc.nextLine());
                    break;

                case 6:
                    manager.sortMenu(sc);
                    FileHandler.saveBooks(manager.getBooks());
                    break;

                case 7:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
