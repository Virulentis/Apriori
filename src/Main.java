import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {


    /**
     * sends the file arg to file reader and the minsup to the prune methods
     * also reiterates methods until the dataset is mined
     *
     * @param args command line arguments
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        File f;
        int minSup;
        ArrayList<ArrayList<Integer>> dataMap;
        ListOfItems itemList = new ListOfItems();

        if(args.length != 2 )
        {
//            System.out.println("Please provide two arguments, the filepath and the minimum support threshold");
//            System.exit(0);
            minSup = 20;
            f = new File("D:\\java\\473\\Apriori2\\src\\Datasets\\data.txt");

        }
        else
        {
            minSup = Integer.parseInt(args[1]);
            f = new File(args[0]);
        }


        dataMap = ReadFile.readFile(f);
        ListCreation.firstList(itemList, dataMap);
        CountItems.count(itemList, dataMap);
        CountItems.prune(itemList, minSup);


        while(itemList.list.size() > 1)
        {
            Combinations.permiations(itemList);
            CountItems.count(itemList, dataMap);
            CountItems.prune(itemList, minSup);
        }

        System.out.println("\n|FPs| = " + itemList.itemsFound + "\n" + itemList.output);

    }
}