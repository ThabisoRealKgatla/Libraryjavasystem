package Assignment1;

public class Book {
    private String title;
    private boolean available;

    // boolean and the title
    public Book( String title)
    {
        this.title=title;
        this.available=true;
    }

    //getter method that allows you to retrieve the title of the book.
    public String gettitle()
    {
        return title;
    }

    //checks if the book is currently available for borrowing.
    public boolean isavailable()
    {
        return available;
    }

    // borrowBook method handles borrowing. 
    public void borrowBook()
    {
        if(available)
        {
            available = true;
            System.out.println(" Book " + title + " is available ");
            System.out.println("please return the book within 5 working days from 09:00 to 17:00");
            
        }
        else{

            System.out.println("Book " + title + " is not availble");
        }

    }
    
     //returnBook method handles returning the book.
     public void returnBook() 
      {
        if(!available)
        {
            available = false;
            System.out.println(" The Book "  + title + " has been seccesfully returned");
        }
        else{
            System.out.println("The book " + title + " has been succesfuly returned");

        }
     }

   
}
