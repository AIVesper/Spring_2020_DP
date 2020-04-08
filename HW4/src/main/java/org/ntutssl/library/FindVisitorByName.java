package org.ntutssl.library;

import java.util.Iterator;
import java.util.Vector;

public class FindVisitorByName implements Visitor {
    private String name;
    Vector<Item> items = new Vector<Item>();

    public FindVisitorByName(String name) {
        this.name = name;
    }

    public void visitBook(Book book) {
        if (book.name().equals(this.name)) {
            items.add(book);
        }

    }

    public void visitCollection(Collection collection) {
        if (collection.name().equals(this.name)) {
            items.add(collection);
            Iterator<Item> it = collection.iterator();
            while (it.hasNext()) {
                it.next().accept(this);
            }
        } else {
            Iterator<Item> it = collection.iterator();
            while (it.hasNext()) {
                it.next().accept(this);
            }
        }
    }

    public String getResult() {
        String result = "";
        Iterator<Item> temp = items.iterator();
        while (temp.hasNext()) {
            result += temp.next().toString() + "\n";
        }
        return result;
    }
}
