package controller;

import entity.Book;
import entity.Library;
import service.BookToLibraryService;
import service.ContractService;
import service.NamesService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

@Model
public class AddToLibraryController {

    private List<String> books;

    private String selectedBook;

    private List<String> libraries;

    private String selectedLibrary;

    @Inject
    private NamesService namesService;

    @Inject
    private BookToLibraryService bookToLibraryService;

    @Inject
    private FacesContext facesContext;

    @PostConstruct
    public void initAuthorsNPublishers(){
        books = namesService.getBookTitles();
        libraries = namesService.getLibraryNames();
    }

    public void addBookToLibrary(){
        Book book = namesService.getBookByTitle(selectedBook);
        Library library = namesService.getLibraryByName(selectedLibrary);

        if(bookToLibraryService.addBookToLibrary(book, library)){
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Book added", "Book added");
            facesContext.addMessage(null, m);
        }
        else {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Too many copies, book can't be added",
                    "Book can't be added");
            facesContext.addMessage(null, m);
        }
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public String getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(String selectedBook) {
        this.selectedBook = selectedBook;
    }

    public List<String> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<String> libraries) {
        this.libraries = libraries;
    }

    public String getSelectedLibrary() {
        return selectedLibrary;
    }

    public void setSelectedLibrary(String selectedLibrary) {
        this.selectedLibrary = selectedLibrary;
    }
}
