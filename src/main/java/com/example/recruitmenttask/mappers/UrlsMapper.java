package com.example.recruitmenttask.mappers;

import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.models.UrlsDataSimple;

public class UrlsMapper {

    public UrlData mapFromSimple(UrlsDataSimple urlsDataSimple){
        return new UrlData(urlsDataSimple.getId(), urlsDataSimple.getUrl());
    }

    public UrlsDataSimple mapToSimple(UrlData urlData){
        return new UrlsDataSimple(urlData.getId(), urlData.getUrl());
    }
}
