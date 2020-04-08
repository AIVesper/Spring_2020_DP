package org.ntutssl.library;

import java.util.Iterator;

public class ListDetailVisitor implements Visitor {
    private String listResultString = "";
    private int levels = 0;

    public ListDetailVisitor() {

    }

    public void visitBook(Book book) {
        listResultString += determineIndent();
        listResultString += String.format("Book Name: %s\n\t", book.name());
        listResultString += determineIndent();
        listResultString += String.format("Author: %s\n\t", book.author());
        listResultString += determineIndent();
        listResultString += String.format("Description: %s\n\t", book.description());
        listResultString += determineIndent();
        listResultString += String.format("ISBN: %s\n", book.isbn());
    }

    public void visitCollection(Collection collection) {
        listResultString += determineIndent();
        listResultString += String.format("Collection Name: %s\n\t", collection.name());
        listResultString += determineIndent();
        listResultString += String.format("Description: %s\n", collection.description());
        Iterator<Item> it = collection.iterator();
        levels++;
        while (it.hasNext()) {
            it.next().accept(this);
        }
        levels--;
    }

    public String getResult() {
        return listResultString;
    }

    private String determineIndent() {
        String indent = "";
        for (int i = 0; i < levels; i++) {
            indent += "\t";
        }
        return indent;
    }
}
