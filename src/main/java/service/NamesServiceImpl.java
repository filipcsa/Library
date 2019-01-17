package service;

import dao.AuthorDAOImpl;
import dao.PublisherDAOImpl;
import entity.Author;
import entity.Publisher;

import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class NamesServiceImpl implements NamesService {

    @Inject
    private AuthorDAOImpl authorDAO;

    @Inject
    private PublisherDAOImpl publisherDAO;

    @Inject
    private Logger logger;

    @Override
    public List<String> getAuthorNames() {
        return authorDAO.list().stream()
                .map(a -> a.getFirstname() + " " + a.getLastname()).collect(Collectors.toList());
    }

    @Override
    public List<String> getPublisherNames() {
        return publisherDAO.list().stream()
                .map(Publisher::getName).collect(Collectors.toList());
    }

    @Override
    public Author getAuthorWithName(String name) {
        logger.info("Retrieving author with name " + name);
        return authorDAO.list().stream()
                .filter(a -> (a.getFirstname() + " " + a.getLastname()).equals(name)).findFirst().get();
    }

    @Override
    public Publisher getPublisherWithName(String name) {
        logger.info("Retrieving publisher with name " + name);
        return publisherDAO.list().stream()
                .filter(p -> p.getName().equals(name)).findFirst().get();
    }
}
