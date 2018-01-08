import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

class SMMemberInfo <K> {
    private K key;
    private long date;

    public SMMemberInfo(K key){
        this.key = key;
        this.date = System.currentTimeMillis();
    }

    public SMMemberInfo(K key, long date){
        this.key = key;
        this.date = date;
    }

    public void updateTime(){ // update()?
        this.date = System.currentTimeMillis();
    }

    public long getDate(){
        return date;
    }
}
public class SimpleMemcache<K, V> implements Memcache<K,V>{
    private HashMap<K, V> map = new HashMap<K,V>();
    private HashMap<K, SMMemberInfo<K>> infoMap = new HashMap<K, SMMemberInfo<K>>();
    private long expire = 60000L;
    private long loop = 10000L;
    private Thread t;
    private boolean run = false;
    static HashMap<KVKey, SimpleMemcache> instanceMap;

    @Override
    public synchronized V put(K key, V val){
        SMMemberInfo<K> info = infoMap.get(key);

        if (info != null){
            info.updateTime();
        } else {
            info = new SMMemberInfo<K>(key);
            infoMap.put(key, info);
        }
        return map.put(key, val);
    }

    @Override
    public synchronized V get(K key) {
        SMMemberInfo info = infoMap.get(key);
        if (info != null){
            info.updateTime();
        }
        return map.get(key);
    }

    private SimpleMemcache() {
        createMonitorThread();
        start();
    }

    private SimpleMemcache(long  msec){
        this();
        this.expire = msec;
    }

    public static <K,V> SimpleMemcache<K,V> getSimpleMemcache(Class<K> key, Class<V> val){
        if (key == null) return null;
        if (val == null) return null;

        if (instanceMap == null){
            instanceMap = new HashMap<KVKey, SimpleMemcache>();
        }
        KVKey kvKey = new KVKey(key, val);
        SimpleMemcache cache = instanceMap.get(kvKey);
        if (cache == null){
            cache = new SimpleMemcache<K,V>();
            instanceMap.put(kvKey, cache);
        }
        return cache;
    }

    public void createMonitorThread(){
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                long now = System.currentTimeMillis();
                System.out.println(expire);
                while (run) {
                    synchronized(this){
                        Iterator iter = infoMap.entrySet().iterator();
                        while(iter.hasNext()){
                            Map.Entry<K,SMMemberInfo> entry = (Map.Entry<K,SMMemberInfo>) iter.next();
                            K key = entry.getKey();
                            SMMemberInfo info = entry.getValue();
                            if (info.getDate() + expire < now){
                                map.remove(key);
                                iter.remove();
                            }
                        }
                    }
                    try {
                        Thread.sleep(loop);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
    }

    public void start(){
        run = true;
        t.setDaemon(true);
        t.start();
    }

    public void stop(){
        run = false;
    }
}
