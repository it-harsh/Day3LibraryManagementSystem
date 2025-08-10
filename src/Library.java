import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added successfully.");
    }

    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
        System.out.println("Book removed if existed.");
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        books.forEach(System.out::println);
    }

    public void searchBook(String title) {
        books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .forEach(System.out::println);
    }

    public void addUser(String name) {
        users.add(new User(name));
        System.out.println("User added successfully.");
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }
        users.forEach(System.out::println);
    }

    public List<User> getUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
            return null;
        }
        return users;
    }

    public void borrowBook(int userId, int bookId) {
        User user = findUser(userId);
        Book book = findBook(bookId);

        if (user != null && book != null && book.isAvailable()) {
            if (user.borrowBook(book)) {
                System.out.println("Book borrowed successfully.");
            }
        } else {
            System.out.println("Borrow failed. Book may be unavailable.");
        }
    }

    public void returnBook(int userId, int bookId) {
        User user = findUser(userId);
        Book book = findBook(bookId);

        if (user != null && book != null && user.getBorrowedBooks().contains(book)) {
            user.returnBook(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Return failed.");
        }
    }

    private User findUser(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    private Book findBook(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

}
