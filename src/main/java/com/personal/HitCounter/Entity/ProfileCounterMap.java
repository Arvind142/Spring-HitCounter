package com.personal.HitCounter.Entity;

import java.util.HashMap;
import java.util.Map;

public class ProfileCounterMap {
    Map<String,Integer> map;
    public ProfileCounterMap(){
        map = new HashMap<>();
    }
    public int getCount(String userName){
        if(map.containsKey(userName)){
            map.put(userName, map.get(userName)+1);
            return map.get(userName);
        }
        else{
            map.put(userName, 1);
            return 1;
        }
    }
}
