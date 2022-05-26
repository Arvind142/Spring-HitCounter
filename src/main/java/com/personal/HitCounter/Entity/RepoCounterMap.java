package com.personal.HitCounter.Entity;

import java.util.HashMap;
import java.util.Map;

public class RepoCounterMap {
    Map<String, Map> map;

    public RepoCounterMap() {
        map = new HashMap<>();
    }

    public int getCount(String userName, String repositoryName) {
        if (map.containsKey(userName)) {
            Map repositoryMap = map.get(userName);
            if (repositoryMap.containsKey(repositoryName)) {
                repositoryMap.replace(repositoryName, (int) repositoryMap.get(repositoryName) + 1);
                map.replace(userName, repositoryMap);
                return (int) repositoryMap.get(repositoryName);
            } else {
                repositoryMap.replace(repositoryName, 1);
                map.replace(userName, repositoryMap);
                return 1;
            }
        } else {
            Map repositoryMap = new HashMap<String,Integer>();
            repositoryMap.put(repositoryName, 1);
            map.put(userName, repositoryMap);
            return 1;
        }
    }
}
