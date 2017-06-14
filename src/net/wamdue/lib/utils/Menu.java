package net.wamdue.lib.utils;

import net.wamdue.lib.beans.Book;

import java.util.List;
import java.util.Scanner;

/**
 * @author Wamdue
 * @version 1.0
 * @since 14.06.2017
 */
public class Menu {
    private static StringBuilder mainMenu = new StringBuilder();
    private static Scanner scan = new Scanner(System.in);

    static{
        mainMenu.append("1 - Добавить книгу\n");
        mainMenu.append("2 - Найти книгу по названию\n");
        mainMenu.append("3 - Найти книгу по автору\n");
        mainMenu.append("4 - Удалить книгу\n");
        mainMenu.append("5 - Вывести полный список книг\n");
        mainMenu.append("6 - Выход\n");

    }
    public static void drawMenu(){
        System.out.println(mainMenu.toString());
    }

    public static int readInt(){
        return scan.nextInt();
    }

    public static String readString() {
        return scan.next();
    }

    public static String bookToString(Book book){
        return String.format("%s %s %s %s %s %s %s", book.getId(), book.getGenre()
                ,book.getAuthor(), book.getPublisher(),book.getIsbn(), book.getPublishDate()
                ,book.getName(), book.getDescription());
    }

    public static Book addNewBook(){
        Book book = new Book();
        System.out.println("Введите Жанр: ");
        book.setGenre(readString());
        System.out.println("Введите Автора: ");
        book.setAuthor(readString());
        System.out.println("Введите Издателя: ");
        book.setPublisher(readString());
        System.out.println("Введите ISBN: ");
        book.setIsbn(readString());
        System.out.println("Введите дату издания: ");
        book.setPublishDate(readString());
        System.out.println("Введите название книги: ");
        book.setName(readString());
        System.out.println("Введите Описание: ");
        book.setDescription(readString());

        return book;
    }

    public static void viewBooks(List<Book> bookList){
        for(Book book :bookList){
            System.out.println(bookToString(book));
        }
    }
}
