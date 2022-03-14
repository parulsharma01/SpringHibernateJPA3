package com.parul.springdata.springdatajpa3.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_address",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"), // info related to current column
            inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"))  // info related to the other column
    Set<Address> addresses;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Book> books;

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

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

    public void addBook(Book book)
    {
        if(book!=null) {
            if (this.books == null) this.books = new HashSet<>();
            book.setAuthor(this);
            this.books.add(book);
        }
    }

    public void addAddress(Address address)
    {
        if(address!=null) {
            if (this.addresses == null) this.addresses = new HashSet<>();
            address.addAuthor(this);
            this.addresses.add(address);
        }
    }

}
