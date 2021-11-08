package com.example.recruitmenttask.Services;

import com.example.recruitmenttask.models.UrlsDataSimple;
import com.example.recruitmenttask.repositories.UrlsRepository;

import javax.inject.Inject;
import java.util.List;

public class UrlsService {

    private UrlsRepository urlsRepository;

    public UrlsService() {
    }

    @Inject
    public UrlsService(UrlsRepository urlsRepository) {
        this.urlsRepository = urlsRepository;
    }

    public List<UrlsDataSimple> getAllUrlsSimple() {
        return urlsRepository.getAllUrlsSimple();
    }
}
