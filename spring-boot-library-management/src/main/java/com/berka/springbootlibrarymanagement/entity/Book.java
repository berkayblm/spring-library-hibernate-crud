package com.berka.springbootlibrarymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "title")
    private String title;

    @Column(name = "pages")
    private int pages;

    @Column(name = "link")
    private String link;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH,
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "user_library",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userList;

    @Column(name = "photo_path")
    private String photoPath;


    public Book() {}

    public Book(String bookName, String title, int pages, String link, String photoPath) {
        this.bookName = bookName;
        this.title = title;
        this.pages = pages;
        this.link = link;
        this.photoPath = photoPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    private void addUser(User theUser) {

        if (userList == null) {
            userList = new ArrayList<>();
        }

        userList.add(theUser);

    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", link='" + link + '\'' +
                '}';
    }
}
