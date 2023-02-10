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

        File file = null;
        int minSup = 0;


        if(args.length != 2 )
        {
            System.out.println("Please provide two arguments, the filepath and the minimum support threshold");
            System.exit(0);

        }
        else
        {
            minSup = Integer.parseInt(args[1]);
            if(minSup < 0 || minSup > 100)
            {
                System.out.println("Minimum support must be between 0-100");
                System.exit(0);
            }
            file = new File(args[0]);
        }


        startMine(file, minSup);

    }

    /**
     * The method starts the timer and the other methods to mine the dataset
     * once there is one or less items in the item list it will
     * stop the timer and call the method to write in the file
     *
     * @param filepath the file that has the mining dataset
     * @param minSup the minimum support threshold
     * @throws IOException
     */
    public static void startMine(File filepath, int minSup) throws IOException {
        Stopwatch sc = new Stopwatch();
        sc.start();

        ArrayList<ArrayList<Integer>> dataMap;
        ListOfItems itemList = new ListOfItems();


        dataMap = FileReadWrite.readFile(filepath);
        ListCreation.firstList(itemList, dataMap);
        ListOfItems.count(itemList, dataMap);
        ListOfItems.prune(itemList, minSup, dataMap);



        while(itemList.list.size() > 1)
        {
            Combinations.combinations(itemList);
            ListOfItems.count(itemList, dataMap);
            ListOfItems.prune(itemList, minSup, dataMap);

        }

        sc.stop();

        FileReadWrite.writeFile(itemList.itemsFound, itemList.output, sc.getSec());
    }
}