package com.example.recruitmenttask.services;


import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.repositories.IUrlsRepository;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.List;

@Singleton
@Startup
public class DownloadInitializer{

    private IDownloadManager downloadManager;
    private IUrlsRepository urlsRepository;

    public DownloadInitializer() {
    }

    @Inject
    public DownloadInitializer(IDownloadManager downloadManager, IUrlsRepository urlsRepository) {
        this.downloadManager = downloadManager;
        this.urlsRepository = urlsRepository;
        startDownloadingIfNecessary();
    }

    private void startDownloadingIfNecessary() {
        List<UrlData> notDownloadedUrls = urlsRepository.getNotDownloadedUrls();
        if (notDownloadedUrls!=null && !notDownloadedUrls.isEmpty()){
            downloadManager.addListToDownloadingQueue(notDownloadedUrls);
            System.out.println("Added " + notDownloadedUrls.size() + " to downloading queue");
        }
    }
}
