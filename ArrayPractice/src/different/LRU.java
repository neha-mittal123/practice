package different;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LRU {

    Map<Object,LRUData> cache = new ConcurrentHashMap<>();
    public static void main(String[] args){


    }

    public void writeToCache(Object data){
        Date lowestDate = new Date("12:10:2100 ");

        if(cache.containsKey(data)){
            LRUData d = cache.get(data);
            d.t = new Date();
            if(d.t.before(lowestDate)){
                lowestDate = d.t;
            }
            cache.put(data,d);
        }
        Iterator<Map.Entry<Object,LRUData>> itr  = cache.entrySet().iterator();

        while(itr.hasNext()){

        }
    }

    public void readData(int data){

    }


}

class LRUData<Object>{
    Object Data;
    Date t;
}
