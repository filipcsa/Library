package service;

import entity.Author;
import entity.Publisher;

import java.util.List;

public interface NamesService {

    public List<String> getAuthorNames();

    public List<String> getPublisherNames();

    public Author getAuthorWithName(String name);

    public Publisher getPublisherWithName(String name);
}
