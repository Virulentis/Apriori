import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReadFile {

    public static ArrayList<ArrayList<Integer>> readFile(File fileRead) throws FileNotFoundException {
        Scanner sc = new Scanner(fileRead);
        ArrayList<ArrayList<Integer>> dataMap = new ArrayList<>();
        sc.nextInt();
        int itemInLine = 0;
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


//        System.out.println(dataMap.toString());
        return dataMap;
    }
}
