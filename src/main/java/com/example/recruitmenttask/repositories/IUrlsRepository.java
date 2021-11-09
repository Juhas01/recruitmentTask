package com.example.recruitmenttask.repositories;

import com.example.recruitmenttask.models.DownloadingError;
import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.models.UrlsDataSimple;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public interface IUrlsRepository {

    public List<UrlsDataSimple> getAllUrlsSimple();

    public UrlData addUrl(UrlData urlData);

    void downloadDataFromUrlAndSave(URL url, UrlData urlData) throws IOException;

    void addDownloadingError(DownloadingError downloadingError);
}
