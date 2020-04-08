package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;

import org.junit.Test;

public class LibraryTest {
    @Test
    public void testOfLib() {
        Library lib = new Library();
        Item col = new Collection("Dystopia", "People will forget it.");
        Item bk1 = new Book("Nineteen Eighty-Four [1984]",
                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                "George Orwell", "1973370360");
        Item bk2 = new Book("1984 in 2020s",
                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                "Grwelge Ol", "12260");
        Item col1 = new Collection("CCP", "People will forget it.");
        lib.add(bk1);
        lib.add(col);
        col.add(bk2);
        col.add(col1);
        Iterator<Item> itLib = lib.iterator();
        Iterator<Item> itCol = col.iterator();
        assertEquals("Nineteen Eighty-Four [1984]", itLib.next().name());
        assertEquals("People will forget it.", itLib.next().description());
        assertEquals(bk2, itCol.next());
        assertEquals("CCP", itCol.next().name());
        assertFalse(bk1.iterator().hasNext());
        assertEquals(1, col.size());
        assertEquals(2, lib.size());
    }
}
