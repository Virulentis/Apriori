import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("D:\\java\\473\\Apriori2\\src\\Datasets\\data.txt");


        ArrayList<ArrayList<Integer>> dataMap =  new ArrayList<>();
        ListOfItems itemList = new ListOfItems();
        dataMap = ReadFile.readFile(f);
        itemList = ListCreation.firstList(itemList, dataMap);
        System.out.println(itemList.list.toString());


        Combinations.permiations(itemList);
        CountItems.count(itemList, dataMap);
        CountItems.prune(itemList, 20.0);

        

    }
}