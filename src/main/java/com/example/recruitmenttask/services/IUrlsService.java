package com.example.recruitmenttask.services;

import com.example.recruitmenttask.models.UrlDataSimple;

import java.util.List;

public interface IUrlsService {

    public List<UrlDataSimple> getAllUrlsSimple();

    public UrlDataSimple addUrl(UrlDataSimple urlToAdd);

    UrlDataSimple getUrlById(Long urlId);

    List<UrlDataSimple> addListOfUrls(List<UrlDataSimple> urlsToAdd);

    List<UrlDataSimple> getDownloadingQueue();
}
