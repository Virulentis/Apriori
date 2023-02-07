import java.util.ArrayList;

public class Combinations {


    public static ListOfItems permiations(ListOfItems itemList)
    {

        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < itemList.list.size(); i++)
        {
            for(int j = i+1; j < itemList.list.size(); j++)
            {
                temp.add(new ArrayList<>());
                temp.get(count).addAll(itemList.list.get((i)));
                temp.get(count).addAll(itemList.list.get(j));
                count++;
            }


        }
        System.out.println("Permiations "+temp.toString());
        itemList.list = temp;

        return itemList;
    }
}
