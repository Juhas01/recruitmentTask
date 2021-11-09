package com.example.recruitmenttask.services;

import com.example.recruitmenttask.models.UrlData;

import java.util.List;

public interface IDownloadManager {

    void addToDownloadQueue(UrlData urlData);

    void addListToDownloadingQueue(List<UrlData> urlsToAdd);
}
