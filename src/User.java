import java.util.ArrayList;
import java.util.List;

public class User {
    private static int idCounter = 1;
    private int id;
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();
    private static final int MAX_BORROW_LIMIT = 3; // Borrow limit

    public User(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() >= MAX_BORROW_LIMIT) {
            System.out.println("Borrow limit reached! (Max " + MAX_BORROW_LIMIT + " books)");
            return false;
        }
        borrowedBooks.add(book);
        book.setAvailable(false);
        return true;
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setAvailable(true);
    }

    @Override
    public String toString() {
        return id + " | " + name + " | Borrowed: " + borrowedBooks.size() + " book(s)";
    }
}
