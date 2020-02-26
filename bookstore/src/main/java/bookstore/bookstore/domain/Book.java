package bookstore.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String author;
    @Column
    private String title;
    @Column
    private int year;
    @Column
    private String isbn;
    @Column
    private BigDecimal price;


    public Book(String author, String title, int year, String isbn, BigDecimal price) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //text needs to be changed
    @Override
    public String toString() {
        return "Book{" +
                "author: " + author + '\'' +
                ", title: " + title + '\'' +
                ", year: " + year +
                ", isbn: " + isbn + '\'' +
                ", price: " + price +
                '}';
    }
}
