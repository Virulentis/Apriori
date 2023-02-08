import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Combinations {


    public static ListOfItems permiations(ListOfItems itemList)
    {

        ArrayList<Set<Integer>> temp = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < itemList.list.size(); i++)
        {
            for(int j = i+1; j < itemList.list.size(); j++)
            {
                Set<Integer> temp2 = new HashSet<>();
                temp.add(temp2);
                temp.get(count).addAll(itemList.list.get((i)));
                temp.get(count).addAll(itemList.list.get(j));
                count++;
            }


        }
//        System.out.println("Permiations "+temp.toString());
        temp.removeAll(itemList.removedCanadates);

        itemList.list = temp;

        return itemList;
    }
}
