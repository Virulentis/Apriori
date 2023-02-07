import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

//        File f = new File("D:\\java\\473\\Apriori2\\src\\Datasets\\data.txt");
        File f = new File("C:\\Users\\Mrwil\\Documents\\MyCode\\Java\\CPSC473\\Apriori\\src\\Datasets\\data.txt");


        ArrayList<ArrayList<Integer>> dataMap =  new ArrayList<>();
        ListOfItems itemList = new ListOfItems();

        int minSup = 21;


        dataMap = ReadFile.readFile(f);
        itemList = ListCreation.firstList(itemList, dataMap);
        System.out.println(itemList.list.toString());
        CountItems.count(itemList, dataMap);
        CountItems.prune(itemList, minSup);


//        Combinations.permiations(itemList);
//        CountItems.count(itemList, dataMap);
//        CountItems.prune(itemList, minSup);



//        while(itemList.list.size() > 1)
        for(int i = 0; i < 9; i++)
        {
            Combinations.permiations(itemList);
            CountItems.count(itemList, dataMap);
            CountItems.prune(itemList, minSup);


        }

        

    }
}