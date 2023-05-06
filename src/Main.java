import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        String[] files = {"src/BookTest.csv"};
        Library bookLibrary = new Library(files);
        ArrayList<Book> library = bookLibrary.getLibrary(); // contains all the books from the csv file
        LinkedBinarySearchTreeBook<ArrayList<Book>> booksOrganized = OrganizeBooks.organizeTitle(library);
        LinkedBinarySearchTreeBook<ArrayList<Book>> autOrganized = OrganizeBooks.organizeAuthor(library);
        //OrganizeBooks.organizeAuthor(library);
        //OrganizeBooks.organizeCategories(library);
        ArrayList<Book> titles = SearchBooks.titleSearch("Gilead", library, booksOrganized);
        // need to make toLowercase so that it won't result in an error if the user types in lowercase
        System.out.println(titles.get(0));

        ArrayList<Book> authors = SearchBooks.authorSearch("Marilynne Robinson", library, autOrganized);
        // error saying that this.data is null in authorsearch and organizeauthor
        System.out.println(authors.get(0));

    }

}
