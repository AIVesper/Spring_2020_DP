package org.ntutssl.library;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VisitorTest {
    @Test
    public void testListDetailVisitor() {
        ListDetailVisitor listDetailVisitor = new ListDetailVisitor();
        Item bk1 = new Book("1", "1", "1", "bk1");
        Item col1 = new Collection("1", "col1");
        Item bk1_col1 = new Book("1", "1", "1", "bk1col1");
        Item col2 = new Collection("12", "col2");
        col1.add(bk1_col1);
        bk1.accept(listDetailVisitor);
        col1.accept(listDetailVisitor);
        col2.accept(listDetailVisitor);
        String expectbk1 = "Book Name: 1\n\tAuthor: 1\n\tDescription: 1\n\tISBN: bk1\n";
        String expectcol1 = "Collection Name: 1\n\tDescription: col1\n\t";
        String expectbk1_col1 = "Book Name: 1\n\t\tAuthor: 1\n\t\tDescription: 1\n\t\tISBN: bk1col1\n";
        String expectcol2 = "Collection Name: 12\n\tDescription: col2\n";
        assertEquals(String.format("%s", expectbk1 + expectcol1 + expectbk1_col1 + expectcol2),
                listDetailVisitor.getResult());
    }

    @Test
    public void testFindVistorByName() {
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
}