package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
public class Publisher implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min = 1, max = 25)
    private String name;

    @NotNull
    private String address;

    @OneToMany
    private List<Book> publishedBooks;

    //dont't really need it
    /*
    @ManyToMany(mappedBy = "contracts")
    private List<Author> contracts;
    */


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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        Publisher other = (Publisher) obj;
        return other.getName().equals(this.name);
    }
}
