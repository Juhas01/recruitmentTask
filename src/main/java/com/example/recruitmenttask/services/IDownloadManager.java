package com.example.recruitmenttask.services;

import com.example.recruitmenttask.models.UrlData;

import java.util.List;
import java.util.Queue;

public interface IDownloadManager {

    void addToDownloadQueue(UrlData urlData);

    void addListToDownloadingQueue(List<UrlData> urlsToAdd);

    Queue<UrlData> getDownloadingQueue();
}
