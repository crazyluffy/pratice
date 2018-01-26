import java.util.Iterator;
import java.util.List;

public class CostTest {
    private List<Cost> costList = null;
//    private static List<Cost> costList = new ArrayList<Cost>();

    public String getMaxPerson(String date){
       Cost cost = null;
       Cost t = null;
       if(costList == null){
           return null;
       }
       Iterator it = costList.iterator();
       while(it.hasNext()){
           t = (Cost) it.next();
           if (t.getDate().equals(date)){
               if(cost == null){
                   cost = t;
               } else {
                   if(t.getValue().compareTo(cost.getValue()) > 0){
                       cost = t;
                   }
               }
           }
       }
       return cost.getName();
    }

    public Double getValue(String name, String date){
        Cost cost;
        if(costList == null){
            return null;
        }

        Iterator it = costList.iterator();
        while(it.hasNext()){
           cost = (Cost) it.next();
           if(cost.getName().equals(name) && cost.getDate().equals(date)){
               return cost.getValue();
           }
        }
        return null;
    }

    public void insertCost(Cost cost){

    }

    public static void main(String[] args) {

    }
}
