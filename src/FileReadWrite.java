import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReadWrite {

    /**
     * Reads through the file provided and returns the item order number,
     * as well as the order list  in datamap
     *
     * @param fileRead the file that contains the dataset and will be read
     * @return a formated dataset holding the item order number and order list
     * @throws FileNotFoundException
     */
    public static ArrayList<ArrayList<Integer>> readFile(File fileRead) throws FileNotFoundException {
        Scanner sc = new Scanner(fileRead);
        ArrayList<ArrayList<Integer>> dataMap = new ArrayList<>();
        sc.nextInt();
        int itemInLine;
        int count = 0;

        while(sc.hasNextInt())
        {
            sc.nextInt();
            itemInLine = sc.nextInt();
            dataMap.add(new ArrayList<>());
            for(int i = 0; i < itemInLine; i++)
            {
                dataMap.get(count).add(sc.nextInt());
            }
            count++;
        }

        return dataMap;
    }


    /**
     * creates a file and outputs the number of items,
     * the items and their count and the total runtime
     *
     * @param itemsFound the amount of items that were fount to be frequent
     * @param output a formated list of the items and their count
     * @param sec amount of seconds it took to complete the data mine
     * @throws IOException
     */
    public static void writeFile(int itemsFound, String output, long sec) throws IOException {
        File newFile = new File("Output.txt");
        try{
            FileWriter writer = new FileWriter(newFile);
            System.out.println("|FPs| = " + itemsFound + "\n Total Runtime: "+ sec + " sec" +"\n" + output);
            writer.write("|FPs| = " + itemsFound + "\n Total Runtime: "+ sec + " sec" +"\n" + output);

            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("file output not working");
        }




    }


}
