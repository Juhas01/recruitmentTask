package com.example.recruitmenttask.models;


import javax.persistence.*;
import java.sql.Blob;

@Entity
public class UrlData {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private String url;
    @Lob
    private Blob file;

    public UrlData() {
    }

    public UrlData(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }
}
