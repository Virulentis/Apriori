import java.util.*;

/**
 * The object that holds the
 * previously removed candidates, the current candidates
 * the count of the current candidates
 * as well as the output string and amount of items found
 */
public class ListOfItems {
    ArrayList<Set<Integer>> list = new ArrayList<>();
    ArrayList<Set<Integer>> removedCanadates = new ArrayList<>();
    HashMap<Integer, Integer> countOfItems = new HashMap<>();
    String output ="";
    int itemsFound = 0;



    /**
     * counts the items in list that are in datamap
     *
     * @param itemList a datatype that holds the list of items, items removed previously and count of items
     * @param dataMap  the item order number and list provided from the original file
     */
    public static void count(ListOfItems itemList, ArrayList<ArrayList<Integer>> dataMap) {

        for (ArrayList<Integer> integers : dataMap) {
            for (int j = 0; j < itemList.list.size(); j++) {
                if (integers.containsAll(itemList.list.get(j)))
                    if (itemList.countOfItems.putIfAbsent(j, 1) != null)
                        itemList.countOfItems.put(j, itemList.countOfItems.get(j) + 1);
            }
        }

    }


    /**
     * removes any items that is not equal to or above the minimum support threshold
     *
     * @param itemList a datatype that holds the list of items, items removed previously and count of items
     * @param minSup   the minimum support threshold
     */
    public static void prune(ListOfItems itemList, int minSup, ArrayList<ArrayList<Integer>> datamap)
    {
        Iterator<Map.Entry<Integer, Integer>> iterator = itemList.countOfItems.entrySet().iterator();

        Double size = (double) datamap.size();
        int numRem = 0;


        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> entry = iterator.next();
            //If they are not in minsup
            if((entry.getValue()/size) < (double) minSup/100)
            {
                itemList.removedCanadates.add(itemList.list.remove((int) entry.getKey() - numRem));
                iterator.remove();
                numRem++;
            }

            //If they are in minsup
            else
            {
                itemList.itemsFound++;
                itemList.output = itemList.output + itemList.list.get(entry.getKey()-numRem) + " : " + entry.getValue() + "\n";
                iterator.remove();
            }
        }
    }

}
