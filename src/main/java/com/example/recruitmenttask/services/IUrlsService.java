package com.example.recruitmenttask.services;

import com.example.recruitmenttask.models.UrlsDataSimple;

import java.util.List;

public interface IUrlsService {

    public List<UrlsDataSimple> getAllUrlsSimple();

    public UrlsDataSimple addUrl(UrlsDataSimple urlToAdd);
}
