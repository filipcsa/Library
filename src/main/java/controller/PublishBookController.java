package controller;

import entity.Author;
import entity.Book;
import entity.Publisher;
import service.NamesService;
import service.PublishingService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Model
public class PublishBookController {

    private String selectedAuthor;

    private List<String> authors;

    private String selectedPublisher;

    private List<String> publishers;

    @Produces
    @Named
    private Book newBook;

    @Inject
    private NamesService namesService;

    @Inject
    private PublishingService publishingService;

    @Inject
    private FacesContext facesContext;

    @PostConstruct
    public void initStuff(){
        authors = namesService.getAuthorNames();
        publishers = namesService.getPublisherNames();
        newBook = new Book();
    }


    public void publishBook(){
        Author author = namesService.getAuthorByName(selectedAuthor);
        Publisher publisher = namesService.getPublisherByName(selectedPublisher);
        FacesMessage m = null;
        switch (publishingService.publishBook(newBook, author, publisher)){
            case 0:
                m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Book published", "Book published");
                break;
            case 1:
                m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Duplicate isbn", "Duplicate isbn");
                break;
            case 2:
                m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Author has no contract", "No freaking contract");
        }
        facesContext.addMessage(null, m);
    }

    public String getSelectedAuthor() {
        return selectedAuthor;
    }

    public void setSelectedAuthor(String selectedAuthor) {
        this.selectedAuthor = selectedAuthor;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getSelectedPublisher() {
        return selectedPublisher;
    }

    public void setSelectedPublisher(String selectedPublisher) {
        this.selectedPublisher = selectedPublisher;
    }

    public List<String> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }
}
