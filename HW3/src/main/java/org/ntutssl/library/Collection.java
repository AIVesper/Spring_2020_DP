package org.ntutssl.library;

import java.util.Iterator;
import java.util.Vector;

public class Collection extends Readable {
    private String name, description;
    Vector<Item> items = new Vector<Item>();

    public Collection(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    public void add(Item item) {
        items.add(item);
    }

    public int size() {
        int size = 0;
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    public Iterator<Item> iterator() {
        return items.iterator();
    }

    @Override
    public String toString() {
        return "Collection Name: " + this.name + "\n\tDescription:" + this.description;
    }
}
