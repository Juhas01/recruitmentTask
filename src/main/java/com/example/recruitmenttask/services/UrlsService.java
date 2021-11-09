package com.example.recruitmenttask.services;

import com.example.recruitmenttask.mappers.UrlsMapper;
import com.example.recruitmenttask.models.UrlsDataSimple;
import com.example.recruitmenttask.repositories.IUrlsRepository;
import com.example.recruitmenttask.repositories.UrlsRepository;

import javax.inject.Inject;
import java.util.List;

public class UrlsService implements IUrlsService{

    private IUrlsRepository urlsRepository;
    private UrlsMapper urlsMapper;

    public UrlsService() {
    }

    @Inject
    public UrlsService(IUrlsRepository urlsRepository, UrlsMapper urlsMapper) {
        this.urlsRepository = urlsRepository;
        this.urlsMapper = urlsMapper;
    }

    @Override
    public List<UrlsDataSimple> getAllUrlsSimple() {
        return urlsRepository.getAllUrlsSimple();
    }

    @Override
    public UrlsDataSimple addUrl(UrlsDataSimple urlToAdd) {
        return urlsMapper.mapToSimple(urlsRepository.addUrl(urlsMapper.mapFromSimple(urlToAdd)));
    }
}
