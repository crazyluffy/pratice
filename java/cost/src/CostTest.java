import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CostTest {
    private List<Cost> costList = null;
//    private static List<Cost> costList = new ArrayList<Cost>();

    public String getMaxPerson(String date){
       Cost cost = null;
       Cost t = null;
       if(costList == null){
           return null;
       }
       Iterator<Cost> it = costList.iterator();
       while(it.hasNext()){
           t = it.next();
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

        Iterator<Cost> it = costList.iterator();
        while(it.hasNext()){
           cost =  it.next();
           if(cost.getName().equals(name) && cost.getDate().equals(date)){
               return cost.getValue();
           }
        }
        return null;
    }

    public void insertCost(Cost cost){
        Iterator<Cost> it = costList.iterator();
        while(it.hasNext()){

        }
    }

//    public String getPerson(String date) {
//        return Optional.ofNullable(costList.stream().collect(Collectors.groupingBy(Cost::getDate)).get(date))
//                .orElse(Collections.emptyList()).stream().sorted((a, b) -> Double.compare(b.getValue(), a.getValue())).findFirst().orElse(new Cost()).getName();
//    }
//    public Double getValue(String name, String date) {
//        return Optional.ofNullable(costList.stream().collect(Collectors.groupingBy(c -> new CostKey(c.getName(), c.getDate()))).get(new CostKey(name, date)))
//                .orElse(Collections.emptyList()).stream().findFirst().orElse(new Cost()).getValue();
//    }

    public static void main(String[] args) {

    }
}
