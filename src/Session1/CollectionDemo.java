package Session1;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        //list
        List<String> Obj = new ArrayList<String>();
        System.out.println("The size is : "+ Obj.size());
        for (int ctr = 1; ctr <=10; ctr++){
            Obj.add("Value is: " + ctr);
        }
        for(String str : Obj){
            System.out.println(str);
        }
        HashSet<String> set = new HashSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Three");
        set.add("Two");
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        //MAp
        HashMap<String,Empoyee_Data> map = new HashMap<String,Empoyee_Data>();
        Empoyee_Data e1  = new Empoyee_Data(":Nguyen van A");
        map.put("e1",e1);

        Empoyee_Data e2  = new Empoyee_Data(":Nguyen van B");
        map.put("e2",e2);

        Empoyee_Data o = map.get("e1");

        Collection<Empoyee_Data> c = map.values();
        Iterator<Empoyee_Data> it2 = c.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
