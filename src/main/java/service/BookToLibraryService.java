package service;

import entity.Book;
import entity.Library;

public interface BookToLibraryService {

    /**
     * @param book
     * @param library
     * @return true if success (there are no more than 4 + this copies
     * of the book in the library), false otherwise(more than 5 + 1)
     */
    boolean addBookToLibrary(Book book, Library library);
}
