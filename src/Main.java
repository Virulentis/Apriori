import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {


    /**
     * sends the file arg to file reader and the minsup to the go method
     * as well as starts the timer
     *
     * @param args command line arguments
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {

        File file;
        int minSup;


        if(args.length != 2 )
        {
//            System.out.println("Please provide two arguments, the filepath and the minimum support threshold");
//            System.exit(0);
            minSup = 20;
            file = new File("D:\\java\\473\\Apriori2\\src\\Datasets\\data.txt");

        }
        else
        {
            minSup = Integer.parseInt(args[1]);
            file = new File(args[0]);
        }


        startMine(file, minSup);


    }
    public static void startMine(File filepath, int minSup) throws IOException {
        ArrayList<ArrayList<Integer>> dataMap;
        ListOfItems itemList = new ListOfItems();

        dataMap = FileReadWrite.readFile(filepath);
        ListCreation.firstList(itemList, dataMap);
        CountItems.count(itemList, dataMap);
        CountItems.prune(itemList, minSup);


        while(itemList.list.size() > 1)
        {
            Combinations.combinations(itemList);
            CountItems.count(itemList, dataMap);
            CountItems.prune(itemList, minSup);
        }


        FileReadWrite.writeFile(itemList.itemsFound, itemList.output);
    }
}