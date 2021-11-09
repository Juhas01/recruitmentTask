package com.example.recruitmenttask.models;

public class UrlDataSimple {

    private Long id;
    private String url;
    private Boolean isDownloaded;

    public UrlDataSimple() {
    }

    public UrlDataSimple(String url) {
        this.url = url;
    }

    public UrlDataSimple(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public UrlDataSimple(Long id, String url, Boolean isDownloaded) {
        this.id = id;
        this.url = url;
        this.isDownloaded = isDownloaded;
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

    public Boolean getDownloaded() {
        return isDownloaded;
    }

    public void setDownloaded(Boolean downloaded) {
        isDownloaded = downloaded;
    }
}
