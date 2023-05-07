import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        String[] files = {"src/BookTest.csv"};
        Library bookLibrary = new Library(files);

//        String[] files2 = {"src/CommonWords.csv"};
//        Tags commonWords = new Tags(files2);
//        ArrayList<String> tags = commonWords.getTags(); // contains all the words from the CommonWords csv file

        ArrayList<Book> library = bookLibrary.getLibrary(); // contains all the books from the Book csv file
        LinkedBinarySearchTreeBook<ArrayList<Book>> booksOrganized = OrganizeBooks.organizeTitle(library); // tree of library books sorted by title
        LinkedBinarySearchTreeBook<ArrayList<Book>> autOrganized = OrganizeBooks.organizeAuthor(library); // tree of library books sorted by author
        LinkedBinarySearchTreeBook<ArrayList<Book>> catOrganized = OrganizeBooks.organizeCategories(library); // tree of library books sorted by category

        ArrayList<Book> titles = SearchBooks.titleSearch("Gilead", library, booksOrganized); // searches for a book by a given title
        System.out.println(titles.get(0)); // prints the first book in the array returned by titleSearch

        ArrayList<Book> authors = SearchBooks.authorSearch("Marilynne Robinson", library, autOrganized); // searches for a book by a given author
        System.out.println(authors.get(0)); // prints the first book in the array returned by authorSearch

        ArrayList<Book> categories = SearchBooks.categorySearch("Fiction", library, catOrganized); // searches for a book by a given author
        System.out.println(categories.get(0)); // prints the first book in the array returned by categorySearch

//        ArrayList<Book> tags2 = SearchBooks.tagSearch("the", tags, booksOrganized);
//        System.out.println(tags2.get(0));
    }

}
