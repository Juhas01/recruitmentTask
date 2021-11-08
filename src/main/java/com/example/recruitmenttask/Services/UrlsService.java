package com.example.recruitmenttask.Services;

import com.example.recruitmenttask.mappers.UrlsMapper;
import com.example.recruitmenttask.models.UrlsDataSimple;
import com.example.recruitmenttask.repositories.UrlsRepository;

import javax.inject.Inject;
import java.util.List;

public class UrlsService {

    private UrlsRepository urlsRepository;
    private UrlsMapper urlsMapper;

    public UrlsService() {
    }

    @Inject
    public UrlsService(UrlsRepository urlsRepository, UrlsMapper urlsMapper) {
        this.urlsRepository = urlsRepository;
        this.urlsMapper = urlsMapper;
    }

    public List<UrlsDataSimple> getAllUrlsSimple() {
        return urlsRepository.getAllUrlsSimple();
    }

    public UrlsDataSimple addUrl(UrlsDataSimple urlToAdd) {
        return urlsMapper.mapToSimple(urlsRepository.addUrl(urlsMapper.mapFromSimple(urlToAdd)));
    }
}
