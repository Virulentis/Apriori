import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {


    //reads the file and put the Order number, and items bought into a hashmap indexed by the ordernum
    //and holds an array list.
    private static HashMap<Integer, ArrayList<Integer>> readFile(File fileRead) throws FileNotFoundException {
        Scanner sc = new Scanner(fileRead);
        HashMap<Integer, ArrayList<Integer>> dataMap = new HashMap<>();
        sc.nextInt();
        int orderNum;
        int itemInLine = 0;


        while(sc.hasNextInt())
        {

            orderNum = sc.nextInt();
            itemInLine = sc.nextInt();
            dataMap.put(orderNum, new ArrayList<>());
            for(int i = 0; i < itemInLine; i++)
            {
                dataMap.get(orderNum).add(sc.nextInt());
            }

        }


        System.out.println(dataMap.toString());
        return dataMap;
    }


    //A very basic off the ground approach to making a list
    private static ArrayList<ArrayList<Integer>> listNum(HashMap<Integer, ArrayList<Integer>> dataMap)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());

        //TODO replace the i = 1 with a more future-proof alternative
        for(int i = 1; i < dataMap.size(); i++)
        {
            temp = dataMap.get(i);

            System.out.println("The array provided "+temp.toString());
            for(int j = 0; j < temp.size(); j++)
            {

                //Not sure if I need this or not
                //if(!list.get(0).contains(temp.get(j)))
                        list.get(0).add(temp.get(j));
            }

        }
        System.out.println("The list is: "+list.toString());

        return list;
    }


    //This method is to count all the possible combinations
    private static HashMap<Integer, Double> countNum(ArrayList<ArrayList<Integer>> list)
    {
        HashMap<Integer, Double> countList = new HashMap<>();
        for(ArrayList tempArray: list)
        {
            for(int i = 0; i < tempArray.size(); i++)
            {
                if(countList.get(tempArray.get(i)) == null)
                {
                    countList.put((Integer) tempArray.get(i), 1.0);
                }
                else
                {
                    countList.put((Integer) tempArray.get(i),  countList.get(tempArray.get(i))+1);
                }

                //test
            }
        }

        System.out.println("The count is: " + countList.toString());
        return countList;
    }


    private static void permiations(ArrayList<ArrayList<Integer>> list)
    {
        int start = 0;
        for(int i = start; i < list.size()-1; i++)
        {
            list.get(i).addAll(list.get(i+1));

        }


        System.out.println("Permiations "+list.toString());


    }

    
    


    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("C:\\Users\\Mrwil\\Documents\\MyCode\\Java\\CPSC473\\Apriori\\src\\Datasets\\data.txt");

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list = listNum(readFile(f));

        countNum(list);
        permiations(list);
        
        
        
        

    }
}