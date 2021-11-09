package com.example.recruitmenttask.repositories;

import com.example.recruitmenttask.models.DownloadingError;
import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.models.UrlDataSimple;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public interface IUrlsRepository {

    List<UrlDataSimple> getAllUrlsSimple();

    UrlData saveOrUpdateUrlData(UrlData urlData);

    void downloadDataFromUrlAndSave(URL url, UrlData urlData) throws IOException;

    void addDownloadingError(DownloadingError downloadingError);
}
