package org.ntutssl.library;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindVisitorByNameTest {
    @Test
    public void testFindVistorByNameComplexItems() {
        FindVisitorByName findVisitorByName = new FindVisitorByName("1");
        Item bk1 = new Book("1", "1", "1", "1sb");
        Item col1 = new Collection("1", "1sb");
        Item bk1_col1 = new Book("1", "1", "1", "1gggeww");
        col1.add(bk1_col1);
        bk1.accept(findVisitorByName);
        col1.accept(findVisitorByName);
        assertEquals(String.format("%s", bk1.toString() + "\n" + col1.toString() + "\n" + bk1_col1.toString() + "\n"),
                findVisitorByName.getResult());
    }

    @Test
    public void testFindVistorByNameSimpleBook() {
        FindVisitorByName findVisitorByName = new FindVisitorByName("1");
        Item bk1 = new Book("1", "1", "1", "1sb");
        bk1.accept(findVisitorByName);
        assertEquals(String.format("%s", bk1.toString() + "\n"), findVisitorByName.getResult());
    }

    @Test
    public void testFindVistorByNameSimpleCollection() {
        FindVisitorByName findVisitorByName = new FindVisitorByName("1");
        Item col1 = new Collection("1", "1sb");
        col1.accept(findVisitorByName);
        assertEquals(String.format("%s", col1.toString() + "\n"), findVisitorByName.getResult());
    }
}
