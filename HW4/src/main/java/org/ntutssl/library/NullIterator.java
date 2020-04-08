package org.ntutssl.library;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NullIterator implements Iterator<Item> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Item next() {
        throw new NoSuchElementException("Null Iterator does not point to any element");
    }
}
