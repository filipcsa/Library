package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Book {

    @NotNull
    private String title;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date publicationDate;


    private String genre;

    @NotNull
    @Column(unique = true)
    private String ISBN;

    @Id
    @GeneratedValue
    private long id;

    /*
    @ManyToMany(mappedBy = "booksInLibrary")
    private List<Library> libraries;
    */

    @ManyToMany
    private List<Author> authors;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object obj) {
        Book other = (Book) obj;
        return other.getISBN().equals(this.getISBN());
    }
}
