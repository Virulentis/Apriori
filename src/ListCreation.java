import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ListCreation {


    /**
     * creates the first list of apriori algorithm,
     * which holds the items for the candidate set
     *
     * @param listItem a datatype that holds the list of items, items removed previously and count of items
     * @param dataMap the item order number and list provided from the original file
     * @return listItem with the first list added
     */
    public static ListOfItems firstList(ListOfItems listItem, ArrayList<ArrayList<Integer>> dataMap) {

        HashMap<Integer, Double> tempList = new HashMap<>();
        int temp;

        for (ArrayList<Integer> integers : dataMap) {

            for (Integer integer : integers) {

                temp = integer;
                if (tempList.containsKey(temp))
                    tempList.put(temp, tempList.get(temp) + 1);
                else
                    tempList.put(temp, 1.0);
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
}



















