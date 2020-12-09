package org.ntutssl.library;

import java.util.Iterator;
import java.util.Scanner;

public class InputOutput {

    public InputOutput() {

    }

    public void printLibraryInstructions() {
        System.out.println("Please enter the instruction as following to manage the library:");
        System.out.println("\t1. 'Add book': to add book to the library");
        System.out.println("\t2. 'Add collection': to add a collection to the library");
        System.out.println("\t3. 'list': to list all the items name in the library");
        System.out.println("\t4. 'list all': to list the detail of all the items in the library");
        System.out.println("\t5. 'find': to find the item(s) in the library.");
        System.out.println("\t6. 'exit': to exit the program.");
    }

    public void handleLibraryInstructions(String instruction, Library library) {
        switch (instruction) {
            case "1":
                library.items.add(addBookInstructions());
                break;
            case "2":
                library.items.add(addCollectionInstructions());
                break;
            case "3":
                listBooksInfo(library);
                break;
            case "4":
                listBooksInfoDetail(library);
                break;
            case "5":
                findItems(library);
                break;
            case "6":
                System.exit(0);
                break;
            default:
                break;
        }

    }

    Item addBookInstructions() {
        String name, description, author, isbn;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the informations of books:");
        System.out.print("Name of book: ");
        name = sc.nextLine();
        System.out.print("Description of book: ");
        description = sc.nextLine();
        System.out.print("Author of book: ");
        author = sc.nextLine();
        System.out.print("ISBN of book: ");
        isbn = sc.nextLine();
        System.out.println("Book " + name + " added");
        return new Book(name, description, author, isbn);
    }

    Item addCollectionInstructions() {
        String name, description;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the infomations of collection:");
        System.out.print("Name of collection: ");
        name = sc.nextLine();
        System.out.print("Description of collection: ");
        description = sc.nextLine();
        Collection collection = new Collection(name, description);
        loopHandleCollection(collection);
        System.out.println("Collection " + name + " added");
        return collection;

    }

    public void printCollectionInstructions() {
        System.out.println("Please enter the instruction as following to manage the collection:");
        System.out.println("\t1. 'Add book': to add book to the collection");
        System.out.println("\t2. 'Add collection': to add a collection to the collection");
        System.out.println("\t3. 'exit': to exit the process.");
    }

    public void handleCollectionInstructions(String instruction, Collection collection) {
        switch (instruction) {
            case "1":
                collection.items.add(addBookInstructions());
                break;
            case "2":
                collection.items.add(addCollectionInstructions());
                break;
            case "3":
                break;
            default:
                break;
        }
    }

    public void loopHandleCollection(Collection collection) {

        String instruction;
        Scanner sc = new Scanner(System.in);
        do {
            printCollectionInstructions();
            instruction = sc.nextLine();
            handleCollectionInstructions(instruction, collection);
        } while (!instruction.equals("3"));

    }

    public void listBooksInfo(Library library) {
        Iterator<Item> it = library.iterator();
        while (it.hasNext()) {
            Item temp = it.next();
            System.out.println(temp.name());
            listItemInfo(temp);
        }
    }

    public void listBooksInfoDetail(Library library) {
        ListDetailVisitor listDetailVisitor = new ListDetailVisitor();
        Iterator<Item> it = library.iterator();
        while (it.hasNext()) {
            Item temp = it.next();
            if (temp.iterator().hasNext() == false && temp.size() == 1) {
                listDetailVisitor.visitBook((Book) temp);
            } else {
                listDetailVisitor.visitCollection((Collection) temp);
            }
        }
        System.out.println(listDetailVisitor.getResult());
    }

    private void listItemInfo(Item item) {
        Iterator<Item> temp = item.iterator();
        while (temp.hasNext()) {
            Item temp1 = temp.next();
            System.out.println(temp1.name());
            listItemInfo(temp1);
        }
    }

    public void findItems(Library library) {
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the item to find:");
        name = sc.nextLine();
        System.out.println(library.findByName(name));
    }

}
