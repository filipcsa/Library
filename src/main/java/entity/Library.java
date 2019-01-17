package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
public class Library implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min = 1, max = 25)
    private String name;

    @NotNull
    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_library", joinColumns = @JoinColumn(name = "library_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> booksInLibrary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooksInLibrary() {
        return booksInLibrary;
    }

    public void setBooksInLibrary(List<Book> booksInLibrary) {
        this.booksInLibrary = booksInLibrary;
    }
}
