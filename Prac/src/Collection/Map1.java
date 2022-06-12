package Collection;

import java.util.*;  
class Map1{  
public static void main(String args[]){
    HashMap<Integer, String> hp = new HashMap<>();
    hp.put(1,"India");
    hp.put(2,"US");
    hp.put(3,"CA");
    Set s = hp.entrySet();
    Iterator it = s.iterator();
    while(it.hasNext()){
        Map.Entry entry = (Map.Entry)it.next();
          System.out.println(entry.getKey()+" "+ entry.getValue());
    }
}  
}  