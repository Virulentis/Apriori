import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class CountItems {


    public static ListOfItems count(ListOfItems itemList, ArrayList<ArrayList<Integer>> dataMap) {


        for(int i = 0; i < dataMap.size(); i++)
        {
            for(int j = 0; j < itemList.list.size(); j++)
            {

                if(dataMap.get(i).containsAll(itemList.list.get(j)))
                {
//                    System.out.println("HIT: Temp val "+itemList.list.get(j).toString() + " itemList: "+itemList.list.get(j).toString()+" datamap: "+ dataMap.get(i).toString());
                    if(itemList.countOfItems.get(j) == null)
                        itemList.countOfItems.put(j, 1);
                    else
                        itemList.countOfItems.put(j, itemList.countOfItems.get(j) + 1);
                }
            }
        }

        System.out.println("Counted Items: " + itemList.countOfItems.toString());
        return itemList;
    }


    public static ListOfItems prune(ListOfItems itemList, int minSup)
    {
        Iterator<Map.Entry<Integer, Integer>> iterator = itemList.countOfItems.entrySet().iterator();
        Double size = 0.0;
        int numRem = 0;
        size += itemList.countOfItems.size();

        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> entry = iterator.next();


            if((entry.getValue()/size) < (double) minSup/100)
            {

                itemList.list.remove((int) entry.getKey() - numRem);
                iterator.remove();

                numRem++;

            }
            else
            {
                System.out.print(" "+entry.getKey()+" ");
                iterator.remove();
            }
        }


        System.out.println("\npruned: "+itemList.list.toString());
        return itemList;
    }

}





//This method is to count all the possible combinations
    /*


    for (Object i : itemList.countOfItems.keySet()) {

            // checking the minsup
            //TODO: add the removed canadates to the removed list
            if((Double) itemList.countOfItems.get(i)/(itemList.countOfItems.size()) < minSup/100)
            {
                System.out.print(" "+itemList.countOfItems.get(i) + ":r ");
                itemList.countOfItems.remove(i);
                itemList.list.remove(i);

            }
            else
            {
                System.out.print(" "+ itemList.countOfItems.remove(i) +":p");
            }

            System.out.println();
        }















    */