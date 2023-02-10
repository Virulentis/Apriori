import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileReadWrite {

    /**
     * Reads through the file provided and returns the item order number,
     * as well as the order in datamap
     *
     * @param fileRead the file that contains the dataset and will be read
     * @return
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


    public static void writeFile(int itemsFound, String output) throws IOException {
        File newFile = new File("Output.txt");
        FileWriter writer = new FileWriter(newFile);
        System.out.println();
        writer.write("\n|FPs| = " + itemsFound + "\n" + output);



    }


}
