package example.hibernate.bean;

import java.time.LocalDate;
import java.util.Scanner;

import example.hibernet.enitities.Author;
import example.hibernet.enitities.Book;

public class MainClass {

	private static final AuthorDAO authorDAO = new AuthorDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Author and Book Management System ===");
            System.out.println("1. Add a new author with books");
            System.out.println("2. Retrieve an author by ID with books");
            System.out.println("3. Update an author and their books");
            System.out.println("4. Delete an author and their books");
            System.out.println("5. Display all authors and their books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addAuthorWithBooks(scanner);
                    break;
                case 2:
                    retrieveAuthorById(scanner);
                    break;
                case 3:
                    updateAuthor(scanner);
                    break;
                case 4:
                    deleteAuthor(scanner);
                    break;
                case 5:
                    displayAllAuthors();
                    break;
                case 0:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // 1. Add a new author with books
    private static void addAuthorWithBooks(Scanner scanner) {
        System.out.print("Enter author name: ");
        String name = scanner.nextLine();

        System.out.print("Enter author date of birth (YYYY-MM-DD): ");
        LocalDate dob = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter author country: ");
        String country = scanner.nextLine();

        Author author = new Author(auth_name, auth_dob, auth_country);

        System.out.print("Enter the number of books: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 1; i <= numBooks; i++) {
            System.out.println("Enter details for book " + i);
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Publication Year: ");
            int year = scanner.nextInt();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            Book book = new Book(book_title, year, price);
            author.addBook(book);
        }

        authorDAO.addAuthor(author);
        System.out.println("Author and books added successfully!");
    }

    // 2. Retrieve an author by ID with books
    private static void retrieveAuthorById(Scanner scanner) {
        System.out.print("Enter author ID: ");
        int id = scanner.nextInt();

        Author author = authorDAO.getAuthorById(id);
        if (author != null) {
            System.out.println("Author Details: ");
            System.out.println("ID: " + author.getId());
            System.out.println("Name: " + author.getName());
            System.out.println("Date of Birth: " + author.getDob());
            System.out.println("Country: " + author.getCountry());
            System.out.println("Books: ");
            for (Book book : author.getBooks()) {
                System.out.println(book);
            }
        } else {
            System.out.println("Author not found.");
        }
    }

    // 3. Update an author and their books
    private static void updateAuthor(Scanner scanner) {
        System.out.print("Enter author ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Author author = authorDAO.getAuthorById(id);
        if (author != null) {
            System.out.print("Enter new name (current: " + author.getName() + "): ");
            String name = scanner.nextLine();
            System.out.print("Enter new date of birth (YYYY-MM-DD) (current: " + author.getDob() + "): ");
            LocalDate dob = LocalDate.parse(scanner.nextLine());
            System.out.print("Enter new country (current: " + author.getCountry() + "): ");
            String country = scanner.nextLine();

            author.setName(name);
            author.setDob(dob);
            author.setCountry(country);

            System.out.println("Updating books...");
            for (Book book : author.getBooks()) {
                System.out.println("Current details of book: " + book);
                System.out.print("Enter new title (current: " + book.getTitle() + "): ");
                String title = scanner.nextLine();
                System.out.print("Enter new publication year (current: " + book.getPublicationYear() + "): ");
                int year = scanner.nextInt();
                System.out.print("Enter new price (current: " + book.getPrice() + "): ");
                double price = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                book.setTitle(title);
                book.setPublicationYear(year);
                book.setPrice(price);
            }

            authorDAO.updateAuthor(author);
            System.out.println("Author and books updated successfully!");
        } else {
            System.out.println("Author not found.");
        }
    }

    // 4. Delete an author and their books
    private static void deleteAuthor(Scanner scanner) {
        System.out.print("Enter author ID to delete: ");
        int id = scanner.nextInt();

        authorDAO.deleteAuthor(id);
        System.out.println("Author and their books deleted successfully!");
    }

    // 5. Display all authors and their books
    private static void displayAllAuthors() {
        System.out.println("All Authors and their Books: ");
        for (Author author : authorDAO.getAllAuthors()) {
            System.out.println("Author ID: " + author.getId());
            System.out.println("Name: " + author.getName());
            System.out.println("Date of Birth: " + author.getDob());
            System.out.println("Country: " + author.getCountry());
            System.out.println("Books: ");
            for (Book book : author.getBooks()) {
                System.out.println(book);
            }
            System.out.println();
        }
    }

}
