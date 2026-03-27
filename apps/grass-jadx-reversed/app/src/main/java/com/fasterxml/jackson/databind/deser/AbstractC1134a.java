package com.fasterxml.jackson.databind.deser;

import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1134a {

    /* JADX INFO: renamed from: a */
    public static final HashMap f3927a;

    /* JADX INFO: renamed from: b */
    public static final HashMap f3928b;

    static {
        HashMap map = new HashMap();
        map.put(Collection.class.getName(), ArrayList.class);
        map.put(List.class.getName(), ArrayList.class);
        map.put(Set.class.getName(), HashSet.class);
        map.put(SortedSet.class.getName(), TreeSet.class);
        map.put(Queue.class.getName(), LinkedList.class);
        map.put(AbstractList.class.getName(), ArrayList.class);
        map.put(AbstractSet.class.getName(), HashSet.class);
        map.put(Deque.class.getName(), LinkedList.class);
        map.put(NavigableSet.class.getName(), TreeSet.class);
        f3927a = map;
        HashMap map2 = new HashMap();
        map2.put(Map.class.getName(), LinkedHashMap.class);
        map2.put(AbstractMap.class.getName(), LinkedHashMap.class);
        map2.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
        map2.put(SortedMap.class.getName(), TreeMap.class);
        map2.put(NavigableMap.class.getName(), TreeMap.class);
        map2.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
        f3928b = map2;
    }
}
