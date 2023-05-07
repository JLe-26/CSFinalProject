import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        String[] files = {"src/Book1.csv"};
        Library bookLibrary = new Library(files);

        ArrayList<Book> library = bookLibrary.getLibrary(); // contains all the books from the Book csv file
        LinkedBinarySearchTreeBook<ArrayList<Book>> booksOrganized = OrganizeBooks.organizeTitle(library); // tree of library books sorted by title
        LinkedBinarySearchTreeBook<ArrayList<Book>> autOrganized = OrganizeBooks.organizeAuthor(library); // tree of library books sorted by author
        LinkedBinarySearchTreeBook<ArrayList<Book>> catOrganized = OrganizeBooks.organizeCategories(library); // tree of library books sorted by category

        ArrayList<Book> titles = SearchBooks.titleSearch("the nuclear age", library, booksOrganized); // searches for a book by a given title
        System.out.println(titles.get(0)); // prints the first book in the array returned by titleSearch
        System.out.println(titles.size());

        ArrayList<Book> authors = SearchBooks.authorSearch("tim o'brien", library, autOrganized); // searches for a book by a given author
        System.out.println(authors.get(0)); // prints the first book in the array returned by authorSearch

        ArrayList<Book> categories = SearchBooks.categorySearch("fantasy fiction", library, catOrganized); // searches for a book by a given author
        System.out.println(categories.get(5)); // prints the first book in the array returned by categorySearch

    }

}
