package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
}
