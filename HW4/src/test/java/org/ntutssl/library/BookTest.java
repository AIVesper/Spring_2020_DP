package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class BookTest {
    @Test
    public void testOfBookAdd() {
        Book bk1 = new Book("Nineteen Eighty-Four [1984]",
                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                "George Orwell", "1973370360");
        assertNotNull("should not be null", bk1);
    }

    Book bk1 = new Book("Nineteen Eighty-Four [1984]",
            "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
            "George Orwell", "1973370360");

    @Test
    public void testOfBookName() {
        assertEquals("Nineteen Eighty-Four [1984]", bk1.name());
    }

    @Test
    public void testOfBookDescription() {
        assertEquals(
                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                bk1.description());
    }

    @Test
    public void testOfBookAuthor() {
        assertEquals("George Orwell", bk1.author());
    }

    @Test
    public void testOfBookISBN() {
        assertEquals("1973370360", bk1.isbn());
    }

    @Test
    public void testOfBookSize() {
        assertEquals(1, bk1.size());
    }

    @Test
    public void testOfBookIteratorHasNext() {
        Book bk1 = new Book("name", "description", "author", "isbn");
        Iterator<Item> it = bk1.iterator();
        assertFalse(it.hasNext());
    }

    @Test
    public void testOfBookIteratorThrowException() {
        Book bk1 = new Book("name", "description", "author", "isbn");
        Iterator<Item> it = bk1.iterator();
        try {
            it.next();
            fail("ERROR");
        } catch (NoSuchElementException e) {
            assertEquals("Null Iterator does not point to any element", e.getMessage());
        }
    }

    @Test
    public void testOfBookToString() {
        Book bk1 = new Book("name", "description", "author", "isbn");
        assertEquals("Book Name: name\n\tAuthor: author\n\tDescription: description\n\tISBN: isbn", bk1.toString());
    }

    @Test
    public void testOfBookAccept() {
        Book bk1 = new Book("name", "description", "author", "isbn");
        ListDetailVisitor listDetailVisitor = new ListDetailVisitor();
        bk1.accept(listDetailVisitor);
        assertEquals(bk1.toString() + "\n", listDetailVisitor.getResult());
    }
}
