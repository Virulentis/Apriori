import java.util.*;

public class Combinations {

    /**
     * Joins the current list together then removes any duplicates or subsets of infrequent itemsets
     *
     * @param itemList a datatype that holds the list of items, items removed previously and count of items
     */
    public static void combinations(ListOfItems itemList)
    {
        ArrayList<Set<Integer>> temp = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < itemList.list.size(); i++)
        {
            for(int j = i+1; j < itemList.list.size(); j++)
            {
                temp.add(new HashSet<>());
                temp.get(count).addAll(itemList.list.get((i)));
                temp.get(count).addAll(itemList.list.get(j));
                count++;
            }
        }

        //Adds all the items into a set to remove duplicates
        Set<Set<Integer>> removeDup = new HashSet<>(temp);
        temp.clear();
        temp.addAll(removeDup);


        for(Set<Integer> x: removeDup) {
            for (Set<Integer> y: itemList.removedCanadates) {
                if (x.containsAll(y)) {
                    temp.remove(x);
                    break;
                }
            }
        }


        itemList.removedCanadates.clear();
        itemList.list = temp;
    }
}