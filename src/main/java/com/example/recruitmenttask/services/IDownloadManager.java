package com.example.recruitmenttask.services;

import com.example.recruitmenttask.models.UrlData;

public interface IDownloadManager {

    void addToDownloadQueue(UrlData urlData);
}
