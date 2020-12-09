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

    public String findByName(String name) {
        FindVisitorByName findVisitorByName = new FindVisitorByName(name);
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            Item temp = it.next();
            if (temp.iterator().hasNext() == false && temp.size() == 1) {
                findVisitorByName.visitBook((Book) temp);
            } else {
                findVisitorByName.visitCollection((Collection) temp);
            }
        }
        return findVisitorByName.getResult();
    }
}
