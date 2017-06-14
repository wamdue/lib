package net.wamdue.lib;

import net.wamdue.lib.beans.Book;
import net.wamdue.lib.files.LoadFromFile;
import net.wamdue.lib.utils.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wamdue
 * @version 1.0
 * @since 31.05.2017
 */
public class Main {
    public static void main(String[] args){
        LoadFromFile files = new LoadFromFile();
        List<Book> books = new ArrayList<>();
        books = files.getAllBooks();
        int value;
        while(true) {
            Menu.drawMenu();
            value = Menu.readInt();
            switch (value){
                case 1 : books.add(Menu.addNewBook()); break;
                case 5 : Menu.viewBooks(books);
                         System.out.println(); break;
                case 6 : files.saveBooks(books);
                         System.exit(0);
                         break;
            }
        }

    }
}
