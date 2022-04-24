package guru.springframework.springwebapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String publisherName;
    private String publisherAdressLine1;
    private String publisherCity;
    private String publisherState;
    private String publisherZip;

//     @ManyToMany
//     @JoinTable(name = "publisher_author", joinColumns = @JoinColumn(name = "publisher_id"),
//             inverseJoinColumns = @JoinColumn(name = "author_id"))
//     Set<Author> publishedAuthors = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "publisher_id")
     Set<Book> publishedBooks = new HashSet<>();

    public Publisher() {}

    public Publisher(String publisherName, String publisherAdressLine1, String publisherCity, String publisherState, String publisherZip/*, Set<Author> publishedAuthors, Set<Book> publishedBooks*/) {
        this.publisherName = publisherName;
        this.publisherAdressLine1 = publisherAdressLine1;
        this.publisherCity = publisherCity;
        this.publisherState = publisherState;
        this.publisherZip = publisherZip;
        //this.publishedAuthors = publishedAuthors;
        //this.publishedBooks = publishedBooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAdressLine1() {
        return publisherAdressLine1;
    }

    public void setPublisherAdressLine1(String publisherAdressLine1) {
        this.publisherAdressLine1 = publisherAdressLine1;
    }

    public String getPublisherCity() {
        return publisherCity;
    }

    public void setPublisherCity(String publisherCity) {
        this.publisherCity = publisherCity;
    }

    public String getPublisherState() {
        return publisherState;
    }

    public void setPublisherState(String publisherState) {
        this.publisherState = publisherState;
    }

    public String getPublisherZip() {
        return publisherZip;
    }

    public void setPublisherZip(String publisherZip) {
        this.publisherZip = publisherZip;
    }

//    public Set<Author> getPublishedAuthors() {
//        return publishedAuthors;
//    }
//
//    public void setPublishedAuthors(Set<Author> publishedAuthors) {
//        this.publishedAuthors = publishedAuthors;
//    }

    public Set<Book> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(Set<Book> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisherName='" + publisherName + '\'' +
                ", publisherAdressLine1='" + publisherAdressLine1 + '\'' +
                ", publisherCity='" + publisherCity + '\'' +
                ", publisherState='" + publisherState + '\'' +
                ", publisherZip='" + publisherZip + '\'' +
               // ", publishedAuthors=" + publishedAuthors +
                ", publishedBooks=" + publishedBooks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
