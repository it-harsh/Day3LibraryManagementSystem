import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Preload some books
        library.addBook("The Alchemist", "Paulo Coelho");
        library.addBook("1984", "George Orwell");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("The Hobbit", "J.R.R. Tolkien");

        // Preload some users
        library.addUser("Alice");
        library.addUser("Bob");
        library.addUser("Charlie");

        int choice;

        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. List Books");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Add User");
            System.out.println("6. List Users");
            System.out.println("7. Borrow Book");
            System.out.println("8. Return Book");
            System.out.println("9. List of Borrowed Books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    library.addBook(title, author);
                }
                case 2 -> {
                    System.out.print("Enter book ID to remove: ");
                    int bookId = sc.nextInt();
                    library.removeBook(bookId);
                }
                case 3 -> library.listBooks();
                case 4 -> {
                    System.out.print("Enter title to search: ");
                    String searchTitle = sc.nextLine();
                    library.searchBook(searchTitle);
                }
                case 5 -> {
                    System.out.print("Enter user name: ");
                    String name = sc.nextLine();
                    library.addUser(name);
                }
                case 6 -> library.listUsers();
                case 7 -> {
                    System.out.print("Enter user ID: ");
                    int userId = sc.nextInt();
                    System.out.print("Enter book ID: ");
                    int bookId = sc.nextInt();
                    library.borrowBook(userId, bookId);
                }
                case 8 -> {
                    System.out.print("Enter user ID: ");
                    int userId = sc.nextInt();
                    System.out.print("Enter book ID: ");
                    int bookId = sc.nextInt();
                    library.returnBook(userId, bookId);
                }
                case 9 -> {
                    library.getUsers().forEach(u -> System.out.println(u.getId()+" : "+u.getName()+" : "+u.getBorrowedBooks()));
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
