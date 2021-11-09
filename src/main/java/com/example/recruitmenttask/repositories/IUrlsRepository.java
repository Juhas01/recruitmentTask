package com.example.recruitmenttask.repositories;

import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.models.UrlsDataSimple;

import java.util.List;

public interface IUrlsRepository {

    public List<UrlsDataSimple> getAllUrlsSimple();

    public UrlData addUrl(UrlData urlData);
}
