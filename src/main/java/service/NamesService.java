package service;

import entity.Author;
import entity.Book;
import entity.Library;
import entity.Publisher;

import java.util.List;

public interface NamesService {

    List<String> getAuthorNames();

    List<String> getPublisherNames();

    Author getAuthorByName(String name);

    Publisher getPublisherByName(String name);

    List<String> getBookTitles();

    Book getBookByTitle(String title);

    List<String> getLibraryNames();

    Library getLibraryByName(String name);
}
