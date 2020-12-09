package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;

import org.junit.Test;

public class LibraryTest {
        @Test
        public void testOfComplexLibMixedTest() {
                Library lib = new Library();
                Item col = new Collection("Dystopia", "People will forget it.");
                Item bk1 = new Book("1984",
                                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                                "George Orwell", "1973370360");
                Item bk2 = new Book("1984",
                                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                                "Grwelge Ol", "12260");
                Item col1 = new Collection("1984", "People will forget it.");
                lib.add(bk1);
                lib.add(col);
                col.add(bk2);
                col.add(col1);
                Iterator<Item> itLib = lib.iterator();
                Iterator<Item> itCol = col.iterator();
                assertEquals("1984", itLib.next().name());
                assertEquals("People will forget it.", itLib.next().description());
                assertEquals(bk2, itCol.next());
                assertEquals("1984", itCol.next().name());
                assertFalse(bk1.iterator().hasNext());
                assertEquals(1, col.size());
                assertEquals(2, lib.size());
                assertEquals(bk1.toString() + "\n" + bk2.toString() + "\n" + col1.toString() + "\n",
                                lib.findByName("1984"));
        }

        @Test
        public void testOfSimplyLibMixedTest() {
                Library lib = new Library();
                Item bk2 = new Book("1984",
                                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                                "Grwelge Ol", "12260");
                Item bk1 = new Book("1984",
                                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                                "George Orwell", "1973370360");
                lib.add(bk1);
                lib.add(bk2);
                Iterator<Item> itLib = lib.iterator();
                assertEquals("1984", itLib.next().name());
                assertEquals("12260", itLib.next().isbn());
                assertEquals(2, lib.size());
                FindVisitorByName findVisitorByName = new FindVisitorByName("1984");
                findVisitorByName.visitBook((Book) bk2);
                findVisitorByName.visitBook((Book) bk1);
                assertEquals(String.format("%s", bk1.toString() + "\n" + bk2.toString() + "\n"),
                                lib.findByName("1984"));
        }

        @Test
        public void testOfComplexLibFindByName() {
                Library lib = new Library();
                Item col = new Collection("Dystopia", "People will forget it.");
                Item bk1 = new Book("1984",
                                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                                "George Orwell", "1973370360");
                Item bk2 = new Book("1984",
                                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                                "Grwelge Ol", "12260");
                Item col1 = new Collection("1984", "People will forget it.");
                lib.add(bk1);
                lib.add(col);
                col.add(bk2);
                col.add(col1);
                assertEquals(bk1.toString() + "\n" + bk2.toString() + "\n" + col1.toString() + "\n",
                                lib.findByName("1984"));
        }

        @Test
        public void testOfSimplyLibFindByName() {
                Library lib = new Library();
                Item bk2 = new Book("1984",
                                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                                "Grwelge Ol", "12260");
                Item bk1 = new Book("1984",
                                "The Party told you to reject the evidence of your eyes and ears. It was their final, most essential command.",
                                "George Orwell", "1973370360");
                lib.add(bk1);
                lib.add(bk2);
                assertEquals(String.format("%s", bk1.toString() + "\n" + bk2.toString() + "\n"),
                                lib.findByName("1984"));
        }
}
