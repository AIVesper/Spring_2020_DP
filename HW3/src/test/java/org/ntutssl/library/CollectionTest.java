package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;

import org.junit.Test;

public class CollectionTest {
    @Test
    public void testOfCollectionWithBooksAndCollections() {
        Collection col = new Collection("Dystopia", "People will forget it.");
        Book bk1 = new Book("Nineteen Eighty-Four [1984]",
                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                "George Orwell", "1973370360");
        Book bk2 = new Book("1984 in 2020s",
                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                "Grwelge Ol", "12260");
        Collection col1 = new Collection("CCP", "People will forget it.");
        col.add(bk1);
        col.add(bk2);
        col.add(col1);
        Iterator<Item> it = col.iterator();
        assertEquals("Dystopia", col.name());
        assertEquals("People will forget it.", col.description());
        assertEquals(bk1, it.next());
        assertEquals("1984 in 2020s", it.next().name());
        assertEquals("CCP", it.next().name());
        assertFalse(bk1.iterator().hasNext());
        assertEquals(2, col.size());
    }

    @Test
    public void testOfCollectionWithOutBooks() {
        Collection col = new Collection("Dystopia", "People will forget it.");
        assertEquals(0, col.size());
    }

    @Test
    public void testOfCollectionWithOnlyBooks() {
        Collection col = new Collection("Dystopia", "People will forget it.");
        Book bk1 = new Book("Nineteen Eighty-Four [1984]",
                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                "George Orwell", "1973370360");
        Book bk2 = new Book("1984 in 2020s",
                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                "Grwelge Ol", "12260");
        col.add(bk1);
        col.add(bk2);
        Iterator<Item> it = col.iterator();
        assertEquals("Dystopia", col.name());
        assertEquals("People will forget it.", col.description());
        assertEquals(bk1, it.next());
        assertEquals("1984 in 2020s", it.next().name());
        assertFalse(bk1.iterator().hasNext());
        assertEquals(2, col.size());
    }

    @Test
    public void testOfCollectionWithOnlyCollections() {
        Collection col = new Collection("Dystopia", "People will forget it.");
        Collection col1 = new Collection("CCP", "People will forget it.");
        Collection col2 = new Collection("gggg2", "gggg.");
        col.add(col1);
        col.add(col2);
        Iterator<Item> it = col.iterator();
        assertEquals("Dystopia", col.name());
        assertEquals("People will forget it.", col.description());
        assertEquals(col1, it.next());
        assertEquals("gggg2", it.next().name());
        assertEquals(0, col.size());
    }
}
