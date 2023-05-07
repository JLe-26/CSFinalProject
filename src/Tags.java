import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Tags {
    ArrayList<String> tags;

    public Tags(String[] files2) throws FileNotFoundException {
        tags = new ArrayList<>();
        for (String file: files2){
            CSVReader reader = new CSVReader();
            FileReader input = new FileReader(file);
            ArrayList<String[]> myEntries = reader.read(input);
            for (String[] tokens : myEntries){
                String tag = tokens[0];
                tags.add(tag);
            }
        }
    }

    public int getTagSize(){
        return tags.size();
    }

    public ArrayList<String> getTags(){
        return this.tags;
    }

}
