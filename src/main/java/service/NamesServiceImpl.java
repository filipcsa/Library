package service;

import dao.AuthorDAOImpl;
import dao.BookDAOImpl;
import dao.LibraryDAOImpl;
import dao.PublisherDAOImpl;
import entity.Author;
import entity.Book;
import entity.Library;
import entity.Publisher;

import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class NamesServiceImpl implements NamesService {

    //IT WOULD BE BETTER TO USE QUERIES FOR GETTING ENTITIES BY NAMES!!!!
    //NOT STREAMS !!!

    @Inject
    private AuthorDAOImpl authorDAO;

    @Inject
    private PublisherDAOImpl publisherDAO;

    @Inject
    private BookDAOImpl bookDAO;

    @Inject
    private LibraryDAOImpl libraryDAO;

    @Inject
    private Logger logger;

    @Override
    public List<String> getAuthorNames() {
        logger.info("Retrieving names of authors");
        return authorDAO.list().stream()
                .map(a -> a.getFirstname() + " " + a.getLastname()).collect(Collectors.toList());
    }

    @Override
    public List<String> getPublisherNames() {
        logger.info("Retrieving names of publishers");
        return publisherDAO.list().stream()
                .map(Publisher::getName).collect(Collectors.toList());
    }

    @Override
    public Author getAuthorByName(String name) {
        logger.info("Retrieving author with name " + name);
        return authorDAO.list().stream()
                .filter(a -> (a.getFirstname() + " " + a.getLastname()).equals(name)).findFirst().get();
    }

    @Override
    public Publisher getPublisherByName(String name) {
        logger.info("Retrieving publisher with name " + name);
        return publisherDAO.list().stream()
                .filter(p -> p.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<String> getBookTitles() {
        logger.info("Retrieving book titles");
        return bookDAO.list().stream()
                .map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public Book getBookByTitle(String title) {
        logger.info("Retrieving book by title");
        return bookDAO.list().stream()
                .filter(b -> b.getTitle().equals(title)).findFirst().get();
    }

    @Override
    public List<String> getLibraryNames() {
        logger.info("Retrieving library names");
        return libraryDAO.list().stream()
                .map(Library::getName).collect(Collectors.toList());
    }

    @Override
    public Library getLibraryByName(String name) {
        logger.info("Retrieving library by name");
        return libraryDAO.list().stream()
                .filter(l -> l.getName().equals(name)).findFirst().get();
    }
}
