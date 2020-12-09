package org.ntutssl.library;

import java.util.Iterator;

public abstract class Readable implements Item 
{
    public void add(Item items) {
        throw new RuntimeException("Illegal Operation");
    }

    public String isbn() {
        throw new RuntimeException("Illegal Operation");
    }

    public String author() {
        throw new RuntimeException("Illegal Operation");
    }
    
    public Iterator<Item> iterator(){
        return new NullIterator();
    }
}
