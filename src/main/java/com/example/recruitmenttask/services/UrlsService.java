package com.example.recruitmenttask.services;

import com.example.recruitmenttask.exceptionMappers.URlDataNotFoundException;
import com.example.recruitmenttask.mappers.UrlsMapper;
import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.models.UrlDataSimple;
import com.example.recruitmenttask.repositories.IUrlsRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<UrlDataSimple> getAllUrlsSimple() {
        return urlsRepository.getAllUrlsSimple();
    }

    @Override
    public UrlDataSimple addUrl(UrlDataSimple urlToAdd) {
        urlToAdd.setDownloaded(false);
        UrlData urlDataAddedToDb = urlsRepository.saveOrUpdateUrlData(urlsMapper.mapFromSimple(urlToAdd));
        downloadManager.addToDownloadQueue(urlDataAddedToDb);
        return urlsMapper.mapToSimple(urlDataAddedToDb);
    }

    @Override
    public UrlDataSimple getUrlById(Long urlId) {
        UrlData urlDataById = urlsRepository.getUrlDataById(urlId);
        if(urlDataById==null){
            throw new URlDataNotFoundException("Url data with id: " + urlId + " not exists");
        }
        return urlsMapper.mapToSimple(urlDataById);
    }

    @Override
    public List<UrlDataSimple> addListOfUrls(List<UrlDataSimple> urlsToAdd) {
        List<UrlData> urlsFromSimple = urlsToAdd.stream().map(url -> urlsMapper.mapFromSimple(url)).collect(Collectors.toList());
        List<UrlData> urlsAdded = urlsRepository.saveOrUpdateListOfUrls(urlsFromSimple);
        downloadManager.addListToDownloadingQueue(urlsAdded);
        return urlsAdded.stream().map(url -> urlsMapper.mapToSimple(url)).collect(Collectors.toList());
    }
}
