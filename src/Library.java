public class Library {
    String name;
    int year;
    Book[] books;

    Library(Book[] books) {
        this.books = books;
    }

    void addBook(Book book) {
        Book[] newBooks = new Book[books.length + 1];
    }

    void removeBook(Book book) {
        Book[] newBooks = new Book[books.length - 1];
        int j = 0;
        for (Book value : books) {
            if (value != book) {
                newBooks[j] = value;
                j++;
            }
        }
        books = newBooks;
    }

    void displayBooks() {
        for (Book book : books) {
            System.out.println(book.displayInfo());
        }
    }
}
