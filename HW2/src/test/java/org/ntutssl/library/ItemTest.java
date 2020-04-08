package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;

import org.junit.Test;

public class ItemTest {
    @Test
    public void testOfItemBook() {
        Item bk1 = new Book("Hey", "404 NOT FOUND", "author", "114514");
        Item bk2 = new Book("ggg", "408 REQUEST TIMEOUT", "gg", "11432514");
        assertEquals("Hey", bk1.name());
        assertEquals("404 NOT FOUND", bk1.description());
        assertEquals("author", bk1.author());
        assertEquals("114514", bk1.isbn());

        assertEquals("ggg", bk2.name());
        assertEquals("408 REQUEST TIMEOUT", bk2.description());
        assertEquals("gg", bk2.author());
        assertEquals("11432514", bk2.isbn());
        assertFalse(bk1.iterator().hasNext());
        assertFalse(bk2.iterator().hasNext());
    }

    @Test
    public void testOfItemCollection() {
        Item bk1 = new Book("Hey", "404 NOT FOUND", "author", "114514");
        Item bk2 = new Book("ggg", "408 REQUEST TIMEOUT", "gg", "11432514");
        Item ct1 = new Collection("History", "People will forget it.");
        ct1.add(bk1);
        ct1.add(bk2);
        Iterator<Item> it = ct1.iterator();
        assertEquals("History", ct1.name());
        assertEquals("People will forget it.", ct1.description());
        assertEquals(bk1, it.next());
        assertEquals(bk2, it.next());
    }
}
