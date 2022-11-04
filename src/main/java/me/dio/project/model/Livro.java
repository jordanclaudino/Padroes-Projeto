package me.dio.project.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    @ElementCollection
    private List<String> publishers = null;
    @JsonProperty("number_of_pages")
    private Integer numberOfPages;
    @ElementCollection
    @JoinColumn(name = "livro_id")
    private List<Long> covers = null;
    @ElementCollection
    @JsonProperty("isbn_10")
    @JoinColumn(name = "livro_id")
    private List<String> isbn10 = null;
    /*@ManyToOne(targetEntity = Autor.class, fetch = FetchType.EAGER)
    private List<Autor> authors = null;*/
    private String title;
    @ElementCollection
    @JsonProperty("isbn_13")
    @JoinColumn(name = "livro_id")
    private List<String> isbn13 = null;
    @JsonProperty("publish_date")
    private String publishDate;
    @JsonProperty("latest_revision")
    private Integer latestRevision;
    private Integer revision;
    private boolean emprestado = false;

    public Livro() {
    }

    public Livro(Long id, String isbn, List<String> publishers, Integer numberOfPages, List<Long> covers, List<String> isbn10, String title, List<String> isbn13, String publishDate, Integer latestRevision, Integer revision, boolean emprestado) {
        this.id = id;
        this.isbn = isbn;
        this.publishers = publishers;
        this.numberOfPages = numberOfPages;
        this.covers = covers;
        this.isbn10 = isbn10;
        this.title = title;
        this.isbn13 = isbn13;
        this.publishDate = publishDate;
        this.latestRevision = latestRevision;
        this.revision = revision;
        this.emprestado = emprestado;
    }

    public Long getId() {
        return id;
    }

    public List<String> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public List<String> getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(List<String> isbn10) {
        this.isbn10 = isbn10;
    }

    /*public List<Autor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Autor> authors) {
        this.authors = authors;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(List<String> isbn13) {
        this.isbn13 = isbn13;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getLatestRevision() {
        return latestRevision;
    }

    public void setLatestRevision(Integer latestRevision) {
        this.latestRevision = latestRevision;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public boolean isEmprestado() {
        return emprestado;
    }
    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public List<Long> getCovers() {
        return covers;
    }

    public void setCovers(List<Long> covers) {
        this.covers = covers;
    }
}
