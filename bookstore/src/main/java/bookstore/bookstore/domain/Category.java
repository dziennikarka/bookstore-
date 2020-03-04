package bookstore.bookstore.domain;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @OneToMany
    private ArrayList<Book> books;

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
