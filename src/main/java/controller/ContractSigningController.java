package controller;

import entity.Author;
import entity.Publisher;
import service.ContractService;
import service.NamesService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
public class ContractSigningController implements Serializable {

    @Inject
    private NamesService namesService;

    @Inject
    private ContractService contractService;

    @Inject
    private FacesContext facesContext;

    private String selectedAuthor;

    private List<String> authors;

    private String selectedPublisher;

    private List<String> publishers;


    @PostConstruct
    public void initAuthorsNPublishers(){
        authors = namesService.getAuthorNames();
        publishers = namesService.getPublisherNames();
    }

    public void createContractForAuthorAndPublisher(){
        //SHOULD USE A CONVERTER FOR JSF INSTEAD OF 2 ACCESSES TO DB, BUT I DON'T KNOW HOW
        //THIS IS VERY INEFFICIENT
        Author author = namesService.getAuthorByName(selectedAuthor);

        Publisher publisher = namesService.getPublisherByName(selectedPublisher);

        if (contractService.createContract(author, publisher)) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Contract signed", "Contract signed");
            facesContext.addMessage(null, m);
        }
        else {
            FacesMessage m = new FacesMessage((FacesMessage.SEVERITY_INFO), "Contract already exists", "Contract already exists");
            facesContext.addMessage(null, m);
        }
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
