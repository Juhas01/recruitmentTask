package com.example.recruitmenttask.services;

import com.example.recruitmenttask.mappers.UrlsMapper;
import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.models.UrlsDataSimple;
import com.example.recruitmenttask.repositories.IUrlsRepository;

import javax.inject.Inject;
import java.util.List;

public class UrlsService implements IUrlsService{

    private IUrlsRepository urlsRepository;
    private UrlsMapper urlsMapper;
    private IDownloadManager downloadManager;

    public UrlsService() {
    }

    @Inject
    public UrlsService(IUrlsRepository urlsRepository, UrlsMapper urlsMapper, IDownloadManager downloadManager) {
        this.urlsRepository = urlsRepository;
        this.urlsMapper = urlsMapper;
        this.downloadManager = downloadManager;
    }

    @Override
    public List<UrlsDataSimple> getAllUrlsSimple() {
        return urlsRepository.getAllUrlsSimple();
    }

    @Override
    public UrlsDataSimple addUrl(UrlsDataSimple urlToAdd) {
        UrlData urlDataAddedToDb = urlsRepository.saveOrUpdateUrlData(urlsMapper.mapFromSimple(urlToAdd));
        downloadManager.addToDownloadQueue(urlDataAddedToDb);
        return urlsMapper.mapToSimple(urlDataAddedToDb);
    }
}
