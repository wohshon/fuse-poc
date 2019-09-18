package com.redhat;

import java.util.HashMap;
import java.util.Map;

public class Cache {

    private static Cache cache;
    public static Cache getInstance() {
        if (cache==null) {
            cache=new Cache();
        }
        return cache;
    }
    
    private Cache() {
        map=new HashMap<String, String>();
    }

    private Map<String, String> map;

    public void put(String key, String value) {
        this.map.put(key, value);
    }

    public String get(String key) {
        return this.map.get(key);
    }    
}