package com.renm.gitpractice.java.memcache;
import java.util.Date;
import java.util.HashMap;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

class SMMemberInfo <K> {
    private K key;
    private long date;

    public void SMMemberInfo(K key){
        this.key = key;
        this.date = System.currentTimeMillis();
    }

    public void SMMemberInfo(K key, long date){
        this.key = key;
        this.date = date;
    }

    public void updateTime(){
        this.date = System.currentTimeMillis();
    }
}
public class SimpleMemcache<K, V> implements Memcache<K,V>{
    private HashMap<K, V> map = new HashMap<K,V>();
    private long expire = 60000L;
    public K put(K key, V val){
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    public SimpleMemcache() {
        createMonitorThread();
    }

    public SimpleMemcache(long  msec){
        this();
        this.expire = msec;
    }

    public void createMonitorThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(expire);
            }
        }).start();
    }
}
