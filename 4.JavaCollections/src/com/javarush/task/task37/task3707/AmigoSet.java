package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>(Math.max(16, (int)Math.ceil(collection.size() / .75f)));
        this.addAll(collection);
    }

    private void writeObject(ObjectOutputStream out) throws IOException
    {
        out.defaultWriteObject();

        out.write(map.size());
        for (E element: map.keySet()) {
            out.writeObject(element);
        }
        out.writeFloat((float)HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        out.writeInt((int)HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        int size = in.read();
        Set<E> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add((E)in.readObject());
        }

        float loadFactor = in.readFloat();
        int capacity = in.readInt();

        map = new HashMap<>(capacity, loadFactor);
        for (E element: set) {
            map.put(element,PRESENT);
        }
    }

    @Override
    public boolean add(Object o) {
        return map.put((E) o, PRESENT) == null;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)==PRESENT;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {
        try {
            AmigoSet copy = (AmigoSet) super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch (Exception e) {
            throw new InternalError();
        }
    }


}
