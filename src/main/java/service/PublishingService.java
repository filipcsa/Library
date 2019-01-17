package service;

import entity.Author;
import entity.Book;
import entity.Publisher;

public interface PublishingService {

    /**
     *
     * @param book
     * @param author
     * @param publisher
     * @return 0 on success, 1 is duplicate isbn, 2 is no contract
     */
    int publishBook(Book book, Author author, Publisher publisher);
}
