package service;

import dao.AuthorDAOImpl;
import dao.BookDAOImpl;
import dao.PublisherDAOImpl;
import entity.Author;
import entity.Book;
import entity.Publisher;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

@Stateless
public class PublishingServiceImpl implements PublishingService {

    @Inject
    private BookDAOImpl bookDAO;

    @Inject
    private Logger logger;

    @Override
    public int publishBook(Book book, Author author, Publisher publisher) {
        if (!isAuthorContracted(author, publisher)) return 2;
        book.setPublisher(publisher);
        book.setPublicationDate(new Date());
        try {
            bookDAO.save(book);
        }catch (Exception e){
            logger.info("Duplicate isbn");
            return 1;
        }
        logger.info("Book published");
        return 0;
    }

    private boolean isAuthorContracted(Author author, Publisher publisher){
        logger.info("Checking the contract");
        return author.getContracts().contains(publisher);
    }
}
