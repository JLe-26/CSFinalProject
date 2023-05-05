import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        String[] files = {"src/Book1.csv"};
        ArrayList<Book> library = loadBooks(files);

        OrganizeBooks.organizeTitle(library);
        OrganizeBooks.organizeAuthor(library);
        OrganizeBooks.organizeCategories(library);

//        SearchBooks.titleSearch("Spider's Web", library);
//        SearchBooks.authorSearch("Charles Osborne");
//        SearchBooks.categorySearch("Fiction");

    }
// PUT COMMENTS FOR JEAN AND EVA
    public static ArrayList<Book> loadBooks(String[] files) throws FileNotFoundException {
        ArrayList<Book> library = new ArrayList<>();
        for (String file : files) {
            CSVReader reader = new CSVReader();
            FileReader input = new FileReader(file);
            ArrayList<String[]> myEntries = reader.read(input);
            for (String[] tokens : myEntries) {
                String ISBN10 = tokens[1];
                String title = tokens[2];
                String subtitle = tokens[3];
                String[] authors = tokens[4].split(";");
                String[] categories = tokens[5].split(";");
                String thumbnail = tokens[6];
                String description = tokens[7];
                int publish_year = 0;
                if (!tokens[8].equals("")) {
                    publish_year = Integer.parseInt(tokens[8]);
                }
                double average_rating = 0;
                if (!tokens[9].equals("")) {
                    average_rating = Double.parseDouble(tokens[9]);
                }
                int num_pages = 0;
                if (!tokens[10].equals("")) {
                    num_pages = Integer.parseInt(tokens[10]);
                }
                int ratings = 0;
                if (!tokens[11].equals("")) {
                    ratings = Integer.parseInt(tokens[11]);
                }
                Book myBook = new Book(ISBN10, title, subtitle, authors, categories, thumbnail, description, publish_year,
                        average_rating, num_pages, ratings);
                library.add(myBook);
            }
        }
        return library;
    }

}
