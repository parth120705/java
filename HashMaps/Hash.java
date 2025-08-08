package HashMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hash {
    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("India", 120);
        hm.put("China", 110);
        hm.put("USA", 100);

        System.out.println(hm);
        hm.put("China", 130);
        System.out.println(hm);

        if(hm.containsKey("China")){
            System.out.println("china is present");
        }
        else{
            System.out.println("nahi hai");
        }

        System.out.println(hm.get("India"));
        System.out.println(hm.get("UAE"));

        for (Map.Entry<String,Integer> e:hm.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }
        Set<String> keys=hm.keySet();
        for(String key:keys){
            System.out.println(key+" "+hm.get(key));
        }

        hm.remove("China");
        System.out.println(hm);

        

    }
}
