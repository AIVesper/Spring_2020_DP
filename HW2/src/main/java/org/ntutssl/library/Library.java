package org.ntutssl.library;

import java.util.Iterator;
import java.util.Vector;

public class Library {
    Vector<Item> items = new Vector<Item>();

    public Library() {

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
}
