import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalTime;

public class Library {
    private String address;
    private List<Book> books;
 
   
    public Library(String address) {
        this.address = address;
        this.books = new ArrayList<>();
    }

    //method for adding the books
    public void addBook(Book book) {
        books.add(book);
    }

    //method for printing available books in the library
    public void printAvailableBooks() {
        System.out.println("Available books at " + address + ":");
        for (Book book : books) {
            if (book.isavailable()) {
                System.out.println("- " + book.gettitle());
            }
        }
    }
//method for borrowing the select available book
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.gettitle().equals(title)) {
                book.borrowBook();
                return;
            }
        }
      
    }
//method for returning the borrowed book
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.gettitle().equals(title)) {
                book.returnBook();
                return;
            }
        }
    }
    //main method
    public static void main(String[] args) {
      
      //Introducing scanner so that the user can prompt options
        Scanner scanner = new Scanner(System.in);
        
        //operation time for the library using real time(in 24 hour format)
        LocalTime time = LocalTime.now();
        if(time.getHour()<9||time.getHour()>17){
            System.out.println("Library is closed");
        }else{

        // Creating libraries
        Library library1 = new Library("Mountain Caves Library Mankweng");
        Library library2 = new Library("Mountain Caves Library Polokwane");

        // Adding books to libraries
        library1.addBook(new Book("Java Programming"));
        library1.addBook(new Book("Advance calculus"));
        library1.addBook(new Book("Data Structures and Algorithms"));

        library2.addBook(new Book("Linear Programming"));
        library2.addBook(new Book("Dynamic Physics"));
        library2.addBook(new Book("Artificial Intelligence"));

         // Printing available libraries
    System.out.println("Welcome to Mountain cave library:"); 
    System.out.println("1. Mountain cave Mankweng library ");
    System.out.println("2. Mountain cave Polokwane library " );
    System.out.println("Enter the  number of the library of your choice :");

    // Choosing the library
    Library selectedLibrary = null;
    int libraryChoice = scanner.nextInt();
    if (libraryChoice == 1) {
        selectedLibrary = library1;
    } else if (libraryChoice == 2) {
        selectedLibrary = library2;
    } else {
        System.out.println("Invalid library choice.");
        scanner.close();
        return;
    }
        
        // Printing available books in the selected library
        selectedLibrary.printAvailableBooks();

        // Prompting user to borrow or return a book
        scanner.nextLine(); // Consume newline character
        System.out.println("Do you want to borrow or return a book? (borrow/return):");
        String action = scanner.nextLine();

        if (action.equalsIgnoreCase("borrow")) {
            // Prompting user to borrow a book
            System.out.println("Enter the title of the book you want to borrow:");
            String bookTitle = scanner.nextLine();

            // Borrowing the book
            selectedLibrary.borrowBook(bookTitle);
        } else if (action.equalsIgnoreCase("return")) {
            // Prompting user to return a book
            System.out.println("Enter the title of the book you want to return:");
            String bookTitle = scanner.nextLine();

            // Returning the book
            selectedLibrary.returnBook(bookTitle);
        } else {
            System.out.println("Invalid action.");
        }

        scanner.close();
    }
    }
}