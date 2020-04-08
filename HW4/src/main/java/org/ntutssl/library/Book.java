package org.ntutssl.library;

public class Book extends Readable {
    private String name, description, author, isbn;

    public Book(String name, String description, String author, String isbn) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.isbn = isbn;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public String author() {
        return author;
    }

    public String isbn() {
        return isbn;
    }

    public int size() {
        return 1;
    }

    public String toString() {
        return "Book Name: " + this.name + "\n\tAuthor: " + this.author + "\n\tDescription: " + this.description
                + "\n\tISBN: " + this.isbn;
    }

    public void accept(Visitor visitor) {
        visitor.visitBook(this);
    }
}
