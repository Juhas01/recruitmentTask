package com.example.recruitmenttask.services;

import com.example.recruitmenttask.models.DownloadingError;
import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.repositories.IUrlsRepository;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Singleton
public class DownloadManager implements IDownloadManager{

    private Queue<UrlData> downloadingQueue;
    private boolean isDownloading;
    private IUrlsRepository urlsRepository;

    public DownloadManager() {
    }

    @Inject
    public DownloadManager(IUrlsRepository urlsRepository) {
        this.urlsRepository = urlsRepository;
    }

    @Override
    public void addToDownloadQueue(UrlData urlData) {
        if(downloadingQueue == null){
            downloadingQueue = new LinkedList<>();
        }
        downloadingQueue.add(urlData);
        if (!isDownloading){
            startDownloading();
        }

    }

    @Override
    public void addListToDownloadingQueue(List<UrlData> urlsToAdd) {
        for (UrlData url : urlsToAdd             ) {
            addToDownloadQueue(url);
        }
    }

    private void startDownloading() {
        isDownloading = true;
       new Thread(() ->{
           while (!downloadingQueue.isEmpty()){
               downloadUrlData(downloadingQueue.poll());
           }
           isDownloading = false;
        }).start();
    }

    private void downloadUrlData(UrlData urlData){
        try {
            URL url = new URL(urlData.getUrl());
            System.out.println("downloading data to url with id: " + urlData.getId() + " started");
            urlsRepository.downloadDataFromUrlAndSave(url, urlData);
            System.out.println("downloading data to url with id: " + urlData.getId() + " finished");
            urlData.setDownloaded(true);
            urlsRepository.saveOrUpdateUrlData(urlData);
        } catch (IOException e) {
            e.printStackTrace();
            DownloadingError downloadingError = new DownloadingError();
            downloadingError.setUrlData(urlData);
            downloadingError.setErrorMessage(e.getMessage());
            urlsRepository.addDownloadingError(downloadingError);
        }
    }
}
