package Collection;

import java.util.*;  
class Set1{  
public static void main(String args[]){
    
    LinkedHashSet<String> li = new LinkedHashSet<>();
    li.add("Surbhi");
    li.add("kourav");
    li.add("xyz");
    
    Iterator it = li.iterator();
    while(it.hasNext()){
        System.out.println(it.next());
    }
}  
}  
