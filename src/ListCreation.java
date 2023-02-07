
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ListCreation {




    public static ListOfItems firstList(ListOfItems listItem, ArrayList<ArrayList<Integer>> dataMap)
    {
//        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
//        temp = listItem.list;
        HashMap<Integer, Double> tempList = new HashMap<>();
        int temp = 0;

        for(int i = 0; i < dataMap.size(); i++)
        {
            for(int j = 0; j < dataMap.get(i).size(); j++)
            {
                temp = dataMap.get(i).get(j);
                if(tempList.containsKey(temp))
                {
                    tempList.put(temp,tempList.get(temp)+1);
                }
                else
                {
                    tempList.put(temp, 1.0);
                }

            }
        }

        //Moving the dataset to the list
        temp = 0;
        for (int x : tempList.keySet()) {

            Set<Integer> tempSet = new HashSet<>();
            listItem.list.add(tempSet);
            listItem.list.get(temp).add(x);
            temp++;
        }



        return listItem;
    }





















    /*private static ArrayList<ArrayList<Integer>> listNum(HashMap<Integer, ArrayList<Integer>> dataMap)
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
                list.add(new ArrayList<>());
                list.get(j).add(temp.get(j));
            }

        }
        System.out.println("The list is: "+list.toString());

        return list;
    }*/
}
