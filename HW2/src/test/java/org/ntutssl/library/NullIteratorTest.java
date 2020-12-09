package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class NullIteratorTest {
    @Test
    public void testNullIteratorHasNext() {
        Item bk1 = new Book("name", "description", "author", "isbn");
        Iterator<Item> it = bk1.iterator();
        assertFalse(it.hasNext());
    }

    @Test
    public void testNullIteratorNextThrowException() {
        Item bk1 = new Book("name", "description", "author", "isbn");
        Iterator<Item> it = bk1.iterator();
        try {
            it.next();
            fail("ERROR");
        } catch (NoSuchElementException e) {
            assertEquals("Null Iterator does not point to any element", e.getMessage());
        }
    }
}
