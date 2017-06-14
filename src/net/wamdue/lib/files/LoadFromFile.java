package net.wamdue.lib.files;

import net.wamdue.lib.beans.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wamdue
 * @version 1.0
 * @since 31.05.2017
 */
public class LoadFromFile {
    //    private File authorFile;
//    private File genreFile;
    private File bookFile;
//    private File publisherFile;

    public LoadFromFile() {
//        authorFile = new File("author.txt");
//        genreFile = new File("genre.txt");
        bookFile = new File("book.txt");
        if (!bookFile.exists()) {
            try {
                bookFile.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
//        publisherFile = new File("publisher.txt");
    }

    public List<Book> getAllBooks() {
        try (FileReader fr = new FileReader(bookFile)) {
            List<Book> books = new ArrayList<>();
            BufferedReader br = new BufferedReader(fr);
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] fields = line.split("##");
                Book book = new Book();
                book.setId(Integer.valueOf(fields[0]));
                book.setGenre(fields[1]);
                book.setAuthor(fields[2]);
                book.setPublisher(fields[3]);
                book.setIsbn(fields[4]);
                book.setPublishDate(fields[5]);
                book.setName(fields[6]);
                book.setDescription(fields[7]);
                books.add(book);
            }
            return books;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void saveBooks(List<Book> books) {
        if (books != null && books.size() > 0) {
            StringBuilder line = new StringBuilder();

            for (Book b : books) {
                line.append(String.format("%s##%s##%s##%s##%s##%s##%s##%s", b.getId(), b.getGenre()
                        ,b.getAuthor(), b.getPublisher(),b.getIsbn(), b.getPublishDate(), b.getName()
                        , b.getDescription()));
            }

            try (FileWriter fw = new FileWriter(bookFile);
                 BufferedWriter bw = new BufferedWriter(fw)) {

                bw.write(line.toString());
                bw.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
